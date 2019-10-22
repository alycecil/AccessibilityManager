package com.teamgo.core.engine.events;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.statics.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Event implements Comparable<Event> {
    public Entity source;
    public List<Entity> targets = new ArrayList<>();
    public Action action;
    public int priority = 100;
    public String __id = UUID.randomUUID().toString();


    public Entity getSource() {
        return source;
    }

    public void setSource(Entity source) {
        this.source = source;
    }

    public List<Entity> getTargets() {
        return targets;
    }

    public void setTargets(List<Entity> targets) {
        this.targets = targets;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String get__id() {
        return __id;
    }

    public void set__id(String __id) {
        this.__id = __id;
    }


    @Override
    public int compareTo(Event o) {
        int diff = priority - o.priority;
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getAction() == event.getAction() &&
                Objects.equals(get__id(), event.get__id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAction(), get__id());
    }


    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", targets=" + targets +
                ", action=" + action +
                ", priority=" + priority +
                ", __id='" + __id + '\'' +
                '}';
    }
}
