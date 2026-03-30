package com.propertybuy.rentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "forward:/usersignin.html";
    }

    @GetMapping("/owner/login")
    public String ownerLogin() {
        return "forward:/ownersignin.html";
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/about.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "forward:/contact.html";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "forward:/privacy.html";
    }

    @GetMapping("/propertyDetails")
    public String propertyDetails() {
        return "forward:/propertyDetails.html";
    }
}
