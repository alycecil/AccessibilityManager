package com.teamgo.commandersapi.rest;

import com.teamgo.commandersapi.errors.NotLoggedIn;
import com.teamgo.commandersapi.services.EventManager;
import com.teamgo.commandersapi.services.PlayerManager;
import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class GetOrdersPlayer {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    PlayerManager playerManager;

    @Autowired
    EventManager eventManager;

    @GetMapping("/event/{playerName}")
    @ResponseBody
    public Event event(@PathVariable String playerName) {
        Player p = playerManager.identifyPlayer(playerName, false);
        if (p == null) {
            throw new NotLoggedIn();
        }

        Event e = eventManager.emitEvent(p);

        if (e == null) {
            throw new NothingNew();
        }else{
            logger.info("Assigning "+playerName+" event "+e);
        }

        return e;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No New Events")
    private class NothingNew extends RuntimeException {
    }
}
