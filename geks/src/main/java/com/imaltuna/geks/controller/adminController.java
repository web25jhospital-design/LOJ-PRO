package com.imaltuna.geks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imaltuna.geks.repository.eraikinaRepository; // ✪ OXEL


@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class adminController {


    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
    // private final erabiltzaileaRepository erabiltzaileaRepository;
    private final eraikinaRepository eraikinaRepository; // ✪ OXEL


    @Autowired // Lotura automatikoa.  Spring-ek automatikoki bilatuko du Repository-aren inplementazioa
    public adminController(eraikinaRepository eraikinaRepository) {
        // this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.eraikinaRepository = eraikinaRepository; // ✪ OXEL
    }

    @GetMapping("/admin") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String admin(Model model) {
        // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an erabili ahal izateko

        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        // model.addAttribute("erabiltzailea", erabiltzaileaRepository.findAll());
        model.addAttribute("eraikina", eraikinaRepository.findAll()); // ✪ OXEL

        // GAKOA: "admin" hitzak esaten dio Spring-i templates/admin.html fitxategia bilatzeko
        return "admin";
    }
}