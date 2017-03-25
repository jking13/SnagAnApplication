package com.jking.snag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by john on 3/25/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage(){
        return "homepage";
    }
}
