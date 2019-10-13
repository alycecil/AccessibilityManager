package com.teamgo.core.engine.rules.abstracts;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.InventoryItem;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.Room;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.rules.interfaces.InventoryRule;

import java.util.List;

public abstract class ItemValueRule implements InventoryRule {

    @Override
    public List<Event> performRule(Player player, Entity... entities) {
        for (Entity entity : entities) {
            if (entity instanceof InventoryItem) {
                performRule(player, entity);
            } else {
                throw new IllegalArgumentException(entity + "must by a Item of some kind.");
            }
        }
        return null;
    }

    @Override
    public abstract List<Event> performRule(Player player, InventoryItem item);
}
