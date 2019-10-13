package com.teamgo.core.engine.services;

import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.statics.State;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.events.EventQueue;
import com.teamgo.core.engine.rooms.CombatRoomManager;
import com.teamgo.core.engine.rooms.RoomManager;
import com.teamgo.core.engine.rules.common.RulesEngine;
import com.teamgo.core.engine.statics.AutowireHelperRules;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerService {
    CombatRoomManager combatRoomManager = new CombatRoomManager();
    RoomManager roomManager = new RoomManager();

    AutowireHelperRules autowireHelperRules = new AutowireHelperRules(combatRoomManager, roomManager);
    RulesEngine rulesEngine = new RulesEngine(autowireHelperRules);

    Map<Player, EventQueue> playerEvents = new ConcurrentHashMap<>();

    public Set<Player> listPlayers(){
        return playerEvents.keySet();
    }

    public Player identifyPlayer(String name){
        for (Player player : listPlayers()) {
            if(Objects.equals(player.getName(), name)){
                return player;
            }
        }
        return null;
    }

    public void handleLogin(Player player) {
        getPlayerQueue(player);
    }

    public void handleLogout(Player player) {
        //TODO remove from room manager - is memory leak
        //TODO remove playerEvents
    }


    public Event emitEvent(Player player) {
        Event request = null;

        PriorityQueue<Event> priorityQueue = getPlayerQueue(player).getEventPriorityQueue();

        if (!priorityQueue.isEmpty()) {
            request = priorityQueue.poll();
        }

        if (request == null) {
            List<Event> events = rulesEngine.performStep(player);

            if (!events.isEmpty()) {
                ListIterator<Event> listIterator = events.listIterator();

                //get first
                request = listIterator.next();

                //queue the rest
                while(listIterator.hasNext()){
                    priorityQueue.add(listIterator.next());
                }
            }
        }

        return request;
    }

    private EventQueue getPlayerQueue(Player player) {
        playerEvents.putIfAbsent(player, new EventQueue());
        return playerEvents.get(player);
    }


    public void playerInCombat(Player p) {
        p.setCurrentState(State.combat);

    }


    public void playerNotInCombat(Player p) {
        if(State.combat.equals(p.getCurrentState())) {
            p.setCurrentState(State.idle);
        }
    }
}
