package com.imaltuna.geks.controller;

import java.util.Date;
import java.util.List; // ✪ OXEL

import org.springframework.beans.factory.annotation.Autowired; // ✪ OXEL
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.imaltuna.geks.model.Erabiltzailea;
import com.imaltuna.geks.model.GailuElektronikoa;
import com.imaltuna.geks.model.Kudeatu;
import com.imaltuna.geks.repository.EgonRepository;
import com.imaltuna.geks.repository.ErabiltzaileaRepository;
import com.imaltuna.geks.repository.EraikinaRepository;
import com.imaltuna.geks.repository.GailuElektronikoaRepository; // ✪ OXEL
import com.imaltuna.geks.repository.GelaRepository;
import com.imaltuna.geks.repository.KudeatuRepository;

import jakarta.servlet.http.HttpSession;

@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class adminController {

    // 'final' jartzen dugu behin esleituta ez dela aldatuko ziurtatzeko
    // private final erabiltzaileaRepository erabiltzaileaRepository;
    private final EraikinaRepository eraikinaRepository; // ✪ OXEL
    private final GailuElektronikoaRepository gailuelektronikoaRepository;
    private final EgonRepository egonRepository;
    private final GelaRepository gelaRepository;
    private final KudeatuRepository kudeatuRepository;
    private final ErabiltzaileaRepository erabiltzaileaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired // Lotura automatikoa. Spring-ek automatikoki bilatuko du Repository-aren
               // inplementazioa
    public adminController(EraikinaRepository eraikinaRepository,
            GailuElektronikoaRepository gailuelektronikoaRepository,
            EgonRepository egonRepository, GelaRepository gelaRepository, KudeatuRepository kudeatuRepository,
            ErabiltzaileaRepository erabiltzaileaRepository) {
        // this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.eraikinaRepository = eraikinaRepository; // ✪ OXEL
        this.gailuelektronikoaRepository = gailuelektronikoaRepository;
        this.egonRepository = egonRepository;
        this.gelaRepository = gelaRepository;
        this.kudeatuRepository = kudeatuRepository;
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }

    // --------------------------------------------------------------
    // ADMIN.HTML Kargatu
    // --------------------------------------------------------------
    @GetMapping("/admin") // Nabigatzailean http://localhost:8080/ idaztean (GET eskaria)
    public String admin(Model model) {
        // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an erabili ahal izateko

        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        model.addAttribute("eraikina", eraikinaRepository.findAll()); // ✪ OXEL

        // GailuElektronikoak
        model.addAttribute("gailuak", gailuelektronikoaRepository.findAll());
        model.addAttribute("gailuEgoerak", gailuelektronikoaRepository.findDistinctEgoera());
        model.addAttribute("gailuMotak", gailuelektronikoaRepository.findDistinctMota());
        model.addAttribute("gailuakGaurEgun", gailuelektronikoaRepository.findGailuakGaurEgun());

        // Egon
        model.addAttribute("gailuaNon", egonRepository.findAll());

        // Gela
        model.addAttribute("gelak", gelaRepository.findAll());

        // Kudeaketa
        model.addAttribute("kudeaketak", kudeatuRepository.findAll());
        model.addAttribute("kudeaketaMotak", kudeatuRepository.findDistinctKudeatzeMota());

        // Erabiltzaileak
        model.addAttribute("erabiltzaileak", erabiltzaileaRepository.findAll());



        // OXEL ↓
        // --- NUEVOS CONTADORES ---

        // Gailuak guztira
        long guztiraGailuak = gailuelektronikoaRepository.count();
        model.addAttribute("guztiraGailuak", guztiraGailuak);

        // 2. Dispositivos disponibles (Filtrando por el ENUM 'erabilgarri')
        long erabilgarri = gailuelektronikoaRepository.contarDisponibles();
        model.addAttribute("erabilgarri", erabilgarri);

        // Eraikinak guztira
        model.addAttribute("guztiraEraikinak", eraikinaRepository.count());

        // Gelak guztira
        model.addAttribute("guztiraGelak", gelaRepository.count());

        // Mantentzean daudenak, bajan, ...
        model.addAttribute("mantenuan", gailuelektronikoaRepository.contarMantenuan());
        model.addAttribute("bajan", gailuelektronikoaRepository.contarBajan());



         // Azken 3 gailuak lortu
        List<Kudeatu> azkenMugimenduak = kudeatuRepository.findKudeatuObjects(); // ✪ OXEL
    
        // HTMLra bidali
        model.addAttribute("azkenMugimenduak", azkenMugimenduak); // ✪ OXEL
        // OXEL ↑



        // GAKOA: "admin" hitzak esaten dio Spring-i templates/admin.html fitxategia bilatzeko
        return "admin";
    }

    // --------------------------------------------------------------
    // GailuElektronikoa Gehitu
    // --------------------------------------------------------------
    @PostMapping("/admin")
    public String sortuGailua(@ModelAttribute GailuElektronikoa gailuBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        System.out.println(erabiltzailea.getIdErabiltzailea());
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // AltaData automatikoa momentukoa jarri
        gailuBerria.setAltaData(new Date());
        // null hasieran
        gailuBerria.setBajaData(null); // null hasieran

        gailuelektronikoaRepository.save(gailuBerria);
        return "redirect:/admin"; // Orria freskatu
    }
}