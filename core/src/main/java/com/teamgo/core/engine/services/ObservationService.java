package com.teamgo.core.engine.services;

import com.teamgo.core.bo.Entity;
import com.teamgo.core.bo.Player;
import com.teamgo.core.bo.ScreenData;

import java.util.List;



///TODO Decide if this is a goood approach
//other option is to have player send entities back based on what it sees.
// Letting one player be the master per room, ordered by uuid assigned
@Deprecated
public class ObservationService {

    public List<Entity> reviewObservations(Player player, ScreenData screenData){
        //todo
        return null;
    }
}
