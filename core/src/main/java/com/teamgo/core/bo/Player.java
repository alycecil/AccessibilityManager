package com.teamgo.core.bo;

import com.teamgo.core.bo.statics.State;
import com.teamgo.core.util.Expiring;

public class Player extends Entity {


    Expiring<Integer> weaponStatus = Expiring.EXPIRED,
            weight = Expiring.EXPIRED,
            hp = Expiring.EXPIRED,
            mana = Expiring.EXPIRED;
    State currentState = State.login;

    public Expiring<Integer> getMana() {
        return mana;
    }

    public void setMana(Expiring<Integer> mana) {
        this.mana = mana;
    }

    public Expiring<Integer> getHp() {
        return hp;
    }

    public void setHp(Expiring<Integer> hp) {
        this.hp = hp;
    }

    public Expiring<Integer> getWeaponStatus() {
        return weaponStatus;
    }

    public void setWeaponStatus(Expiring<Integer> weaponStatus) {
        this.weaponStatus = weaponStatus;
    }

    public Expiring<Integer> getWeight() {
        return weight;
    }

    public void setWeight(Expiring<Integer> weight) {
        this.weight = weight;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
