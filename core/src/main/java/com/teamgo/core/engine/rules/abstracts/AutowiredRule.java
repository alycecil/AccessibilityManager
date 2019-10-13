package com.teamgo.core.engine.rules.abstracts;

import com.teamgo.core.engine.rooms.CombatRoomManager;
import com.teamgo.core.engine.rooms.RoomManager;
import com.teamgo.core.engine.rules.interfaces.Rule;

public abstract class AutowiredRule implements Rule {
    public RoomManager roomManager;
    public CombatRoomManager combatRoomManager;

}
