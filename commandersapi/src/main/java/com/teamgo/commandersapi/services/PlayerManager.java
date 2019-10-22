package com.teamgo.commandersapi.services;

import com.teamgo.core.api.PlayerUpdate;
import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.services.PlayerService;
import com.teamgo.core.util.Expiring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.BiConsumer;

@Service
public class PlayerManager {
    @Autowired
    EventManager eventManager;

    PlayerService playerService = new PlayerService();
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Set<Player> listPlayers() {
        return playerService.listPlayers();
    }

    public Player identifyPlayer(String name) {
        return identifyPlayer(name, true);
    }

    public Player identifyPlayer(String name, boolean autoLogin) {
        Player player = playerService.identifyPlayer(name);
        if (autoLogin && player == null) {
            LOGGER.info("Logging in ["+name+"]");
            Player p = new Player();
            p.setName(name);
            playerService.handleLogin(p);
            //lets not just return p.

            return identifyPlayer(name, false/*no recursion even if some bug*/);
        }
        return player;
    }

    /*package*/ Event emitEvent(Player player) {
        return playerService.emitEvent(player);
    }

    public void handleUpdate(Player p, PlayerUpdate playerUpdate) {

        handleUpdate(p, playerUpdate.getHp(), Player::setHp);
        handleUpdate(p, playerUpdate.getMana(), Player::setMana);
        handleUpdate(p, playerUpdate.getWeaponStatus(), Player::setWeaponStatus);
        handleUpdate(p, playerUpdate.getWeight(), Player::setWeight);

        if (playerUpdate.isCombatWindowOpen()) {
            if(playerService.playerInCombat(p)){
                eventManager.completeCurrentJob(p, eventManager.getCurrentJob(p));
            }
        } else if (playerUpdate.isExitedCombat()) {
            playerService.playerNotInCombat(p);
        }

        //TODO FUTURE whenever I add to player status ; this need love
    }

    private <T> void handleUpdate(Player p, T value, BiConsumer<Player, Expiring<T>> field) {
        if (value != null) {
            Expiring<T> expiring;
            //TODO IDEALY AN ANNOTATION WOULD BE USED
            switch (p.getCurrentState()) {
                case combat:
                    expiring = Expiring.expireIn(value, 30, 0);
                    break;
                default:
                    expiring = Expiring.expireIn(value, 30, 15);
                    break;
            }
            field.accept(p, expiring);
        }
    }
}
