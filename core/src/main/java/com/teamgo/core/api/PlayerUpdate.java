package com.teamgo.core.api;

public class PlayerUpdate {
    String name;
    Integer mana;
    Integer hp;
    Integer weight;
    Integer weaponStatus;
    boolean combatWindowOpen;
    boolean exitedCombat;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeaponStatus() {
        return weaponStatus;
    }

    public void setWeaponStatus(Integer weaponStatus) {
        this.weaponStatus = weaponStatus;
    }

    public boolean isCombatWindowOpen() {
        return combatWindowOpen;
    }

    public void setCombatWindowOpen(boolean combatWindowOpen) {
        this.combatWindowOpen = combatWindowOpen;
    }

    public boolean isExitedCombat() {
        return exitedCombat;
    }

    public void setExitedCombat(boolean exitedCombat) {
        this.exitedCombat = exitedCombat;
    }
}
