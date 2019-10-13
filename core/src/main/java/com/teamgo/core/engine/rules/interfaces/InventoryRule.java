package com.teamgo.core.engine.rules.interfaces;

import com.teamgo.core.bo.InventoryItem;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.Room;
import com.teamgo.core.engine.events.Event;

import java.util.List;

public interface InventoryRule extends Rule {
    public List<Event> performRule(Player player, InventoryItem item);
}
