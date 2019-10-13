package com.teamgo.commandersapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Health {

    @GetMapping("/health")
    public String health() {
        return "A-OK-" + new Date().getTime();
    }

}
