package com.teamgo.commandersapi.services;

import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EventManager {
    @Autowired
    PlayerManager playerManager;

    Map<Player, Event> currentJob;

    public Event emitEvent(Player player) {
        Event event = getCurrentJob(player);
        if (event != null) {
            return event;
        }

        event = playerManager.emitEvent(player);

        if (event != null) {
            currentJob.put(player, event);
            return event;
        }

        return null;
    }

    public Event getCurrentJob(Player player) {
        if (currentJob.containsKey(player)) {
            return currentJob.get(player);
        }
        return null;
    }

    public boolean completeCurrentJob(Player p, Event event) {
        return currentJob.remove(p, event);
    }
}
