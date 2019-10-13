package com.teamgo.commandersapi.rest;

import com.teamgo.commandersapi.errors.NotLoggedIn;
import com.teamgo.commandersapi.services.EventManager;
import com.teamgo.commandersapi.services.PlayerManager;
import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetOrdersPlayer {

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
        }

        return e;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No New Events")
    private class NothingNew extends RuntimeException {
    }
}
