package com.teamgo.commandersapi.rest;

import com.teamgo.commandersapi.services.PlayerManager;
import com.teamgo.core.bo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetPlayer {
    private static final boolean DEFAULT_AUTOLOGIN = true;

    @Autowired
    PlayerManager playerManager;

    @ResponseBody
    @GetMapping("/player/{playerName}")
    public Player getDetails(@PathVariable String playerName, @RequestParam(name = "login", required = false) Boolean login) {
        boolean autoLogin = login == null ? DEFAULT_AUTOLOGIN : login;

        return playerManager.identifyPlayer(playerName, autoLogin);
    }

}
