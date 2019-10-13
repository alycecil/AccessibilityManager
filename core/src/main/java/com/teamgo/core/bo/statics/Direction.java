package com.teamgo.core.bo.statics;

import com.teamgo.core.bo.Entity;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    DOOR,
    TRAPDOOR,
    EXIT;


    Entity entity;
    Direction() {
        this.entity = new Entity();
        this.entity.name = this.name();
    }

    public Entity getEntity() {
        return entity;
    }
}
