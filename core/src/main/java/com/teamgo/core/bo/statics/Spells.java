package com.teamgo.core.bo.statics;

import com.teamgo.core.bo.Entity;

public enum Spells {
    Multiblade("Multiblade"),
    Fear("Fear"),
    WOG("WRATH OF THE GODS"),
    DV("Duach's Vengeance"),
    LIGHT_DART("Light Dart"),
    ACID_SPHERE("Acid Sphere"),
    Shift("Shift"),
    StealHeal1("Steal Life"),
    StealMassHeal1("Mass Drain"),
    Heal("Heal"),
    Heal2("Greater Heal"),
    HealParty1("Mass Heal"),
    HealParty2("Enid's Blessing"),
    ;

    Entity entity;
    Spells(String name){
        entity = new Entity();
        entity.name = name;
    }


}
