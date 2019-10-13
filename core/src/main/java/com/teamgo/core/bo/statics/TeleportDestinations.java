package com.teamgo.core.bo.statics;

import com.teamgo.core.bo.Entity;

public enum TeleportDestinations {
    HOME,
    AVALON,

    ;

    Entity entity;
    TeleportDestinations() {
        this.entity = new Entity();
        this.entity.name = this.name();
    }

    public Entity getEntity() {
        return entity;
    }
}
