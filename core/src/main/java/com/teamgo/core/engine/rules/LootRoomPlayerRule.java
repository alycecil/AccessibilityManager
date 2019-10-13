package com.teamgo.core.engine.rules;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.rules.interfaces.CombatRule;
import com.teamgo.core.engine.rules.interfaces.PlayerRule;
import com.teamgo.core.engine.rules.abstracts.AutowiredRule;

import java.util.List;

public class LootRoomPlayerRule extends AutowiredRule implements PlayerRule, CombatRule {
    @Override
    public List<Event> performRule(Player player) {
        return null;
    }

    @Override
    public List<Event> performRule(Player player, Entity... entities) {
        return null;
    }
}
