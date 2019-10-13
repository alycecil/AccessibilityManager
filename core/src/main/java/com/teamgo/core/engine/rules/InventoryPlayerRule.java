package com.teamgo.core.engine.rules;

import com.teamgo.core.bo.statics.Direction;
import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.statics.TeleportDestinations;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.rules.interfaces.PlayerRule;
import com.teamgo.core.engine.rules.interfaces.Rule;

import java.util.LinkedList;
import java.util.List;

import static com.teamgo.core.engine.events.EventHelper.*;

public class InventoryPlayerRule implements Rule, PlayerRule {
    @Override
    public List<Event> performRule(Player player) {
        List<Event> result = new LinkedList<>();
        if(player.getWeaponStatus().isExpired() || player.getWeight().isExpired()){
            result.add(checkStatus(player));
            //TODO result.add(checkInventory(player));
        }else if(player.getWeaponStatus().getValue() < 41 || player.getWeight().getValue() > 80){

            result.add(teleport(player, TeleportDestinations.AVALON));
            result.add(move(player, Direction.LEFT));
            result.add(repair(player));
            result.add(sell(player));
            //TODO Sell Rules
        }

        return result;
    }



    @Override
    public List<Event> performRule(Player player, Entity... room) {
        return performRule(null);
    }
}
