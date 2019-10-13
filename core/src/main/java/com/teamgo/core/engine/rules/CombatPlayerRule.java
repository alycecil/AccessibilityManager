package com.teamgo.core.engine.rules;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.statics.State;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.events.EventHelper;
import com.teamgo.core.engine.rules.abstracts.AutowiredRule;
import com.teamgo.core.engine.rules.interfaces.CombatRule;
import com.teamgo.core.engine.rules.interfaces.PlayerRule;
import com.teamgo.core.engine.rules.interfaces.Rule;

import java.util.LinkedList;
import java.util.List;

public class CombatPlayerRule extends AutowiredRule implements Rule, PlayerRule, CombatRule {
    @Override
    public List<Event> performRule(Player player) {
        List<Event> result = new LinkedList<>();

        //todo if heal
        //todo if cast
        //todo if hitter

        result.add(EventHelper.guard(player));


        return result;
    }



    @Override
    public List<Event> performRule(Player player, Entity... room) {
        return performRule(null);
    }
}
