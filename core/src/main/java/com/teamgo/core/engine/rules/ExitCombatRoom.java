package com.teamgo.core.engine.rules;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.rules.interfaces.CombatRule;

import java.util.List;

public class ExitCombatRoom implements CombatRule {
    @Override
    public List<Event> performRule(Player player, Entity... entities) {

        return null;
    }
}
