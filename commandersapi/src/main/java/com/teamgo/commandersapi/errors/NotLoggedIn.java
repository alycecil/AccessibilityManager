package com.teamgo.commandersapi.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, reason = "Not Logged In")
public class NotLoggedIn extends RuntimeException {
}