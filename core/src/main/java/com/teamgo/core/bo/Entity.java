package com.teamgo.core.bo;

import java.beans.Transient;
import java.util.Objects;
import java.util.UUID;

public class Entity {
    public String __id = UUID.randomUUID().toString();
    public String name;

    @Transient
    public String get__id() {
        return __id;
    }

    public String getName() {
        return name;
    }

    public void set__id(String __id) {
        this.__id = __id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
