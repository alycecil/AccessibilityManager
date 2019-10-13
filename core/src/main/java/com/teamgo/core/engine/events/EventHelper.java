package com.teamgo.core.engine.events;

import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.statics.Action;
import com.teamgo.core.bo.statics.Direction;
import com.teamgo.core.bo.statics.TeleportDestinations;

public class EventHelper {
    public static Event checkStatus(Player player) {
        Event event = buildEvent(player);
        event.action = Action.checkStatus;
        return event;
    }

    public static Event repair(Player player) {
        Event event = buildEvent(player);
        event.action = Action.repair;
        return event;
    }

    public static Event sell(Player player) {
        Event event = buildEvent(player);
        event.action = Action.sellInventory;
        return event;
    }

    public static Event teleport(Player player, TeleportDestinations where) {
        Event event = buildEvent(player);
        event.action = Action.teleport;
        event.targets.add(where.getEntity());
        return event;
    }

    public static Event move(Player player, Direction direction) {
        Event event = buildEvent(player);
        event.action = Action.move;
        event.targets.add(direction.getEntity());
        return event;
    }

    public static Event guard(Player player) {
        Event event = buildEvent(player);
        event.action = Action.combatGuard;
        return event;
    }


    //////////////////////////////////////////////////////// private inner helpers

    private static Event buildEvent(Player player) {
        Event event = new Event();
        event.source = player;
        return event;
    }


}
