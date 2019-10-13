package com.teamgo.core.engine.events;

import java.util.PriorityQueue;

public class EventQueue {
    PriorityQueue<Event> eventPriorityQueue = new PriorityQueue<Event>();

    public PriorityQueue<Event> getEventPriorityQueue() {
        return eventPriorityQueue;
    }
}
