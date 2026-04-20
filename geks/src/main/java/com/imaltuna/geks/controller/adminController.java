package com.imaltuna.geks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imaltuna.geks.repository.EgonRepository;
import com.imaltuna.geks.repository.EraikinaRepository; // ✪ OXEL
import com.imaltuna.geks.repository.GailuElektronikoaRepository;
import com.imaltuna.geks.repository.GelaRepository;


@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class adminController {


    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
    // private final erabiltzaileaRepository erabiltzaileaRepository;
    private final EraikinaRepository eraikinaRepository; // ✪ OXEL
    private final GailuElektronikoaRepository gailuelektronikoaRepository;
    private final EgonRepository egonRepository;
    private final GelaRepository gelaRepository;


    @Autowired // Lotura automatikoa.  Spring-ek automatikoki bilatuko du Repository-aren inplementazioa
    public adminController(EraikinaRepository eraikinaRepository, GailuElektronikoaRepository gailuelektronikoaRepository,
        EgonRepository egonRepository, GelaRepository gelaRepository) {
        // this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.eraikinaRepository = eraikinaRepository; // ✪ OXEL
        this.gailuelektronikoaRepository = gailuelektronikoaRepository;
        this.egonRepository = egonRepository;
        this.gelaRepository = gelaRepository;
    }

    @GetMapping("/admin") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String admin(Model model) {
        // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an erabili ahal izateko

        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        model.addAttribute("eraikina", eraikinaRepository.findAll()); // ✪ OXEL

        //GailuElektronikoak
        model.addAttribute("gailuak", gailuelektronikoaRepository.findAll());
        model.addAttribute("gailuaNon", egonRepository.findAll());
        model.addAttribute("gailuEgoerak", gailuelektronikoaRepository.findDistinctEgoera());
        model.addAttribute("gailuMotak", gailuelektronikoaRepository.findDistinctMota());

        //Gela
        model.addAttribute("gelak", gelaRepository.findAll());
        

        // GAKOA: "admin" hitzak esaten dio Spring-i templates/admin.html fitxategia bilatzeko
        return "admin";
    }
}