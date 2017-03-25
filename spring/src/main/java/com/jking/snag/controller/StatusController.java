package com.jking.snag.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author john.king
 */
@Controller
@RequestMapping(value = "/app_status")
public class StatusController {

    @Value("${app.version}")
    private String version;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<String> getAppStatus() {
        return new ResponseEntity<>("Up. Current version: " + version, HttpStatus.OK);
    }
}
