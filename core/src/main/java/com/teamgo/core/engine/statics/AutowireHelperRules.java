package com.teamgo.core.engine.statics;

import com.teamgo.core.engine.rooms.CombatRoomManager;
import com.teamgo.core.engine.rooms.RoomManager;
import com.teamgo.core.engine.rules.abstracts.AutowiredRule;
import com.teamgo.core.engine.rules.interfaces.Rule;

public class AutowireHelperRules {
    private CombatRoomManager combatRoomManager;
    private RoomManager roomManager;

    public AutowireHelperRules(CombatRoomManager combatRoomManager, RoomManager roomManager) {
        this.combatRoomManager = combatRoomManager;
        this.roomManager = roomManager;
    }

    public void autowire(Rule rule){
        if(rule instanceof AutowiredRule){
            AutowiredRule autowiredRule = (AutowiredRule) rule;
            autowiredRule.combatRoomManager = this.combatRoomManager;
            autowiredRule.roomManager = this.roomManager;
        }
    }
}
