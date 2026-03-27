package com.imaltuna.geks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imaltuna.geks.repository.erabiltzaileaRepository;


@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class hasieraController {


    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
    private final erabiltzaileaRepository erabiltzaileaRepository;


    @Autowired // Lotura automatikoa.  Spring-ek automatikoki bilatuko du Repository-aren inplementazioa
    public hasieraController(erabiltzaileaRepository erabiltzaileaRepository) {
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }


    @GetMapping("/") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String kaixo(Model model) {
        // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an erabili ahal izateko
       
        // GAKOA: "mezua" izena HTML-an ${mezua} bidez deituko dugu
        model.addAttribute("mezua", "Ongi etorri Miguel Altunako Gailuen Kudeatzailera!");
       
        // Datu-baseko erabiltzaile guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "erabiltzaileak" erabiliko dugu (th:each bidez normalean)
        model.addAttribute("erabiltzailea", erabiltzaileaRepository.findAll());
       
        // GAKOA: "index" hitzak esaten dio Spring-i templates/index.html fitxategia bilatzeko
        return "index";
    }
}