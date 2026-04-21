package com.imaltuna.geks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imaltuna.geks.repository.EgonRepository;
import com.imaltuna.geks.repository.ErabiltzaileaRepository;
import com.imaltuna.geks.repository.EraikinaRepository;
import com.imaltuna.geks.repository.GailuElektronikoaRepository;
import com.imaltuna.geks.repository.GelaRepository;

@Controller
public class adminController {

    private final EraikinaRepository eraikinaRepository;
    private final GailuElektronikoaRepository gailuelektronikoaRepository;
    private final EgonRepository egonRepository;
    private final GelaRepository gelaRepository;
    private final ErabiltzaileaRepository erabiltzaileaRepository;

    @Autowired
    public adminController(EraikinaRepository eraikinaRepository,
                           GailuElektronikoaRepository gailuelektronikoaRepository,
                           EgonRepository egonRepository,
                           GelaRepository gelaRepository,
                           ErabiltzaileaRepository erabiltzaileaRepository) {

        this.eraikinaRepository = eraikinaRepository;
        this.gailuelektronikoaRepository = gailuelektronikoaRepository;
        this.egonRepository = egonRepository;
        this.gelaRepository = gelaRepository;
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }

    @GetMapping("/admin")
    public String admin(Model model) {

        // Eraikinak
        model.addAttribute("eraikina", eraikinaRepository.findAll());

        // GailuElektronikoak
        model.addAttribute("gailuak", gailuelektronikoaRepository.findAll());
        model.addAttribute("gailuaNon", egonRepository.findAll());
        model.addAttribute("gailuEgoerak", gailuelektronikoaRepository.findDistinctEgoera());
        model.addAttribute("gailuMotak", gailuelektronikoaRepository.findDistinctMota());

        // Gelak
        model.addAttribute("gelak", gelaRepository.findAll());

        // Erabiltzaileak
        model.addAttribute("erabiltzaileak", erabiltzaileaRepository.findAll());

        return "admin";
    }
}