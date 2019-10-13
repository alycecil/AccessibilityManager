package com.teamgo.core.bo;

import com.teamgo.core.util.Expiring;

import java.util.Objects;

public class Fightable extends Entity {
    Expiring<Integer> hp;

    public Expiring<Integer> getHp() {
        return hp;
    }

    public void setHp(Expiring<Integer> hp) {
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fightable)) return false;
        if (!super.equals(o)) return false;
        Fightable fightable = (Fightable) o;
        return Objects.equals(getHp(), fightable.getHp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHp());
    }
}
