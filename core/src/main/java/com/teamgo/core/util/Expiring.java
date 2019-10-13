package com.teamgo.core.util;

import java.util.Calendar;
import java.util.Date;

public class Expiring<T> {
    public static Expiring EXPIRED = new Expiring();

     Date expiresAt;
     T t;

    public Expiring() {
    }

    public Expiring(T t) {
        this.t = t;
    }

    public Expiring(Date expiresAt, T t) {
        this.expiresAt = expiresAt;
        this.t = t;
    }

    public T getValue() {
        if(isExpired()){
            return null;
        }
        return t;
    }

    public boolean isExpired() {
        return expiresAt == null || expiresAt.before(Calendar.getInstance().getTime());
    }



    public static <T> Expiring<T> expireIn(T j, int seconds, int minutes){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, seconds);
        c.add(Calendar.MINUTE, minutes);

        return new Expiring<>(c.getTime(), j);
    }
}
