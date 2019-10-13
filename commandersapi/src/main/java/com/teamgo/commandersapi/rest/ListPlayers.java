package com.teamgo.commandersapi.rest;

import com.teamgo.commandersapi.services.PlayerManager;
import com.teamgo.core.bo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ListPlayers {
    @Autowired
    PlayerManager playerManager;

    @ResponseBody
    @GetMapping("/players")
    public Collection<Player> players() {
        return playerManager.listPlayers();
    }
}
