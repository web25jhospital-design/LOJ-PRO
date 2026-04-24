package com.imaltuna.geks.controller;

import java.util.List; // ✪ OXEL

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.imaltuna.geks.model.Kudeatu;
import com.imaltuna.geks.repository.EgonRepository;
import com.imaltuna.geks.repository.EraikinaRepository; // ✪ OXEL
import com.imaltuna.geks.repository.GailuElektronikoaRepository;
import com.imaltuna.geks.repository.GelaRepository;
import com.imaltuna.geks.repository.KudeatuRepository;


@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class arruntaController {


    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
   //private final erabiltzaileaRepository erabiltzaileaRepository;
    private final EraikinaRepository eraikinaRepository; // ✪ OXEL
    private final GailuElektronikoaRepository gailuelektronikoaRepository;
    private final EgonRepository egonRepository;
    private final GelaRepository gelaRepository;
    private final KudeatuRepository KudeatuRepository;


    @Autowired // Lotura automatikoa.  Spring-ek automatikoki bilatuko du Repository-aren inplementazioa
    public arruntaController(EraikinaRepository eraikinaRepository, GailuElektronikoaRepository gailuelektronikoaRepository,
        EgonRepository egonRepository, GelaRepository gelaRepository, KudeatuRepository kudeatuRepository) {
        // this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.eraikinaRepository = eraikinaRepository; // ✪ OXEL
        this.gailuelektronikoaRepository = gailuelektronikoaRepository;
        this.egonRepository = egonRepository;
        this.gelaRepository = gelaRepository;
        this.KudeatuRepository = kudeatuRepository;
    }

    @GetMapping("/arrunta") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String arrunta(Model model) {

        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        //model.addAttribute("erabiltzailea", erabiltzaileaRepository.findAll());
        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        model.addAttribute("eraikina", eraikinaRepository.findAll()); // ✪ OXEL


        //GailuElektronikoak
        model.addAttribute("gailuak", gailuelektronikoaRepository.findAll());
        model.addAttribute("gailuEgoerak", gailuelektronikoaRepository.findDistinctEgoera());
        model.addAttribute("gailuMotak", gailuelektronikoaRepository.findDistinctMota());
        model.addAttribute("gailuakGaurEgun", gailuelektronikoaRepository.findGailuakGaurEgun());
        

        //Egon
        model.addAttribute("gailuaNon", egonRepository.findAll());

        //Gela
        model.addAttribute("gelak", gelaRepository.findAll());




        // OXEL ↓
        // --- NUEVOS CONTADORES ---

        // Total de dispositivos
        long guztiraGailuak = gailuelektronikoaRepository.count();
        model.addAttribute("guztiraGailuak", guztiraGailuak);

        // 2. Dispositivos disponibles (Filtrando por el ENUM 'erabilgarri')
        long erabilgarri = gailuelektronikoaRepository.contarDisponibles();
        model.addAttribute("erabilgarri", erabilgarri);

        // Total de edificios
        model.addAttribute("guztiraEraikinak", eraikinaRepository.count());

        // Total de aulas
        model.addAttribute("guztiraGelak", gelaRepository.count());

        // Mantentzean daudenak, bajan, ...
        model.addAttribute("mantenuan", gailuelektronikoaRepository.contarMantenuan());
        model.addAttribute("bajan", gailuelektronikoaRepository.contarBajan());



         // Azken 3 gailuak lortu
        List<Kudeatu> azkenMugimenduak = KudeatuRepository.findKudeatuObjects();
    
        // HTMLra bidali
        model.addAttribute("azkenMugimenduak", azkenMugimenduak);


        // OXEL ↑



        // GAKOA: "arrunta" hitzak esaten dio Spring-i templates/arrunta.html fitxategia bilatzeko
        return "arrunta";
        }
}