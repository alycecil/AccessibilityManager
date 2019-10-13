package com.teamgo.commandersapi.rest;

import com.teamgo.commandersapi.services.PlayerManager;
import com.teamgo.core.api.PlayerUpdate;
import com.teamgo.core.bo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdatePlayer {
    @Autowired
    PlayerManager playerManager;

    @ResponseBody
    @PostMapping("/player/{playerName}")
    public Player playerUpdate(@PathVariable String playerName,
                               @RequestBody PlayerUpdate playerUpdate) {
        Player p = playerManager.identifyPlayer(playerName);
        playerUpdate.setName(playerName);

        //TODO HANDLE

        playerManager.handleUpdate(p, playerUpdate);

        return p;
    }

}
