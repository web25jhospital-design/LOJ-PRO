package com.imaltuna.geks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imaltuna.geks.model.erabiltzailea;
import com.imaltuna.geks.model.rola;
import com.imaltuna.geks.repository.erabiltzaileaRepository;

@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class loginController {

    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
    private final erabiltzaileaRepository erabiltzaileaRepository;

    @Autowired // Lotura automatikoa. Spring-ek automatikoki bilatuko du Repository-aren
               // inplementazioa
    public loginController(erabiltzaileaRepository erabiltzaileaRepository) {
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }

    //Login.html exekutatzen da.
    @GetMapping("/") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String login(Model model) {
        return "index";
    }


    // Erabiltzaileak logina ongi burutu duen konprobatzen da
    @PostMapping("/")
    public String loginaOnetsi(@RequestParam String erabiltzailea, @RequestParam String pasahitza, Model model) {
    // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an erabili ahal izateko
        rola erabiltzaileRola= rola.admin;
        
        erabiltzailea erabDB = erabiltzaileaRepository.findByerabiltzaileIzena(erabiltzailea);
        // Erabiltzailea zuzena den konprobatzen da
        if (erabDB != null && erabDB.getPasahitza().equals(pasahitza)) {
            model.addAttribute("logeatutakoErab", erabDB.getErabiltzaileIzena());
            
            if (erabDB.getErabiltzaileRola()==erabiltzaileRola){
                //erabiltzailea zuzena bada eta admin baimenak baditu admin.html exekutatuko da
                return "redirect:/admin"; // ✪
            }else {
                //erabiltzailea zuzena bada eta arrunta baimenak baditu arrunta.html exekutatuko da
                return "redirect:/arrunta"; // ✪
            }

        } else {
            //Erabiltzailea zuzena ez bada mezua bidaltzen da login.htmlra erabiltzaileari abixatzeko
            model.addAttribute("mezua", "* Erabiltzaile edo pasahitza okerra! Saiatu berriro");
            return "index";
        }
    }
}
