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
public class CompleteOrdersPlayer {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String SPECIAL_ALL = "~";

    @Autowired
    PlayerManager playerManager;


    @Autowired
    EventManager eventManager;

    @PostMapping("/event/{playerName}/{eventId}")
    @ResponseBody
    public String event(@PathVariable String playerName,
                        @PathVariable String eventId,
                        @RequestParam(name = "complete") boolean complete) {
        Player p = playerManager.identifyPlayer(playerName, false);
        if (p == null) {
            throw new NotLoggedIn();
        }

        Event event = eventManager.getCurrentJob(p);

        if (event == null) {
            logger.info("Complete on empty queue");
            throw new NoContent();
        }
        if (SPECIAL_ALL.equals(eventId) || event.get__id().equals(eventId)) {
            if (complete) {
                logger.info("Competed Event " + event);
                if (eventManager.completeCurrentJob(p, event))
                    throw new SuccessFullyRemoved();
                else
                    throw new IllegalStateException("Expected to complete the job");
            } else {
                throw new VerifiedNonCompleteCall();
            }
        } else {
            throw new InvalidEventId();
        }
    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No Events Queued")
    private class NoContent extends RuntimeException {
    }

    @ResponseStatus(value = HttpStatus.NOT_MODIFIED, reason = "complete=true will completed task")
    private class VerifiedNonCompleteCall extends RuntimeException {
    }

    @ResponseStatus(value = HttpStatus.RESET_CONTENT, reason = "completed task")
    private class SuccessFullyRemoved extends RuntimeException {
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid EventId")
    private class InvalidEventId extends RuntimeException {
    }
}
