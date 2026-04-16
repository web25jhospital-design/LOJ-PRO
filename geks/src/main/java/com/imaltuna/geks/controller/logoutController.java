package com.imaltuna.geks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class logoutController {
    
    // Edo POST bidez segurtasun gehiagorako
    @PostMapping("/logout")
    public String logoutPost(HttpSession session) {
        session.invalidate();
        // return "redirect:/?logout=true";
        return "index";
    }
}
