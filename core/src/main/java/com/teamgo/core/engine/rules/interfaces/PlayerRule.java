package com.teamgo.core.engine.rules.interfaces;

import com.teamgo.core.bo.Player;
import com.teamgo.core.engine.events.Event;

import java.util.List;

public interface PlayerRule extends Rule {
    public List<Event> performRule(Player player);
}
