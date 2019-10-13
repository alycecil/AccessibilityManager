package com.teamgo.core.engine.rules.common;

import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.statics.State;
import com.teamgo.core.engine.events.Event;
import com.teamgo.core.engine.rules.CombatPlayerRule;
import com.teamgo.core.engine.rules.ExitCombatRoom;
import com.teamgo.core.engine.rules.InventoryPlayerRule;
import com.teamgo.core.engine.rules.LootRoomPlayerRule;
import com.teamgo.core.engine.rules.abstracts.AutowiredRule;
import com.teamgo.core.engine.rules.interfaces.CombatRule;
import com.teamgo.core.engine.rules.interfaces.FightableRule;
import com.teamgo.core.engine.rules.interfaces.PlayerRule;
import com.teamgo.core.engine.rules.interfaces.Rule;
import com.teamgo.core.engine.statics.AutowireHelperRules;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {
    private final AutowireHelperRules autowireHelperRules;

    CombatRule[] combatRules = new CombatRule[]{
            new CombatPlayerRule(),
            new LootRoomPlayerRule(),
            new ExitCombatRoom()
    };

    //Noncombat
    PlayerRule[] noncombatRules = new PlayerRule[]{
            new InventoryPlayerRule(),
            new LootRoomPlayerRule()
    };

    //Noncombat, Start
    FightableRule[] combatStartingRules = new FightableRule[]{

    };

    public RulesEngine(/*@Autowired*/ AutowireHelperRules autowireHelperRules){
        this.autowireHelperRules = autowireHelperRules;
    }


    public List<Event> performStep(Player player){
        List<Event> results = new ArrayList<>();
        if(State.combat.equals(player.getCurrentState())){
            doRules(results, combatRules, player);

        }else{
            doRules(results, noncombatRules, player);
            doRules(results, combatStartingRules, player);
        }

        return  results;
    }

    private void doRules(List<Event> results, Rule[] rules, Player player) {
        if(!results.isEmpty()) return; //already got orders

        if(rules==null) return;
        if(rules.length==0) return;

        for (Rule rule : rules) {
            doRule(results, rule, player);
        }


        //TODO RESULTS

    }

    private void doRule(List<Event> results, Rule rule, Player player) {
        if(!results.isEmpty()) return; //already got orders
        if(rule==null) return;

        if(rule instanceof AutowiredRule){
            autowireHelperRules.autowire(rule);
        }

        if(rule instanceof PlayerRule){
            ((PlayerRule)rule).performRule(player);
        }else{
            rule.performRule(player);
        }

    }


}
