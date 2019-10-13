package com.teamgo.core.engine.rooms;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomManager {
    Map<Player, Room> playerRoomManager = new HashMap<Player, Room>();


    public void playerFoundPlayer(Player p1, Player p2) {
        if (p1 == p2) return;

        Room r1 = playerRoomManager.get(p1);
        Room r2 = playerRoomManager.get(p2);
        mergeRooms(r1, r2);

        playerRoomManager.put(p2, r1);
    }

    private synchronized void mergeRooms(Room r1, Room r2) {
        if (r1 == r2)
            //already a single room
            return;

        if (r1.entities == null) {
            r1.entities = r2.entities;
        } else if (r2.entities != null) {
            r1.entities.addAll(r2.entities);
        }

    }
}
