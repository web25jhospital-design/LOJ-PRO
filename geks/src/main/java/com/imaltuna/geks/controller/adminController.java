package com.imaltuna.geks.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // ✪ OXEL
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.imaltuna.geks.model.Egon;
import com.imaltuna.geks.model.Erabiltzailea;
import com.imaltuna.geks.model.GailuEgoera;
import com.imaltuna.geks.model.GailuElektronikoa;
import com.imaltuna.geks.model.GailuTaulaGaurEgun;
import com.imaltuna.geks.model.Kudeatu;
import com.imaltuna.geks.repository.EgonRepository;
import com.imaltuna.geks.repository.ErabiltzaileaRepository;
import com.imaltuna.geks.repository.EraikinaRepository;
import com.imaltuna.geks.repository.GailuElektronikoaRepository;
import com.imaltuna.geks.repository.GelaRepository;
import com.imaltuna.geks.repository.KudeatuRepository;

import jakarta.servlet.http.HttpSession; // ✪ OXEL

@Controller // Spring-i esaten dio klase honek HTTP eskariak (URLak) jasoko dituela
public class adminController {

    private final arruntaController arruntaController;
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
            ErabiltzaileaRepository erabiltzaileaRepository, arruntaController arruntaController) {
        // this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.eraikinaRepository = eraikinaRepository; // ✪ OXEL
        this.gailuelektronikoaRepository = gailuelektronikoaRepository;
        this.egonRepository = egonRepository;
        this.gelaRepository = gelaRepository;
        this.kudeatuRepository = kudeatuRepository;
        this.erabiltzaileaRepository = erabiltzaileaRepository;
        this.arruntaController = arruntaController;
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
    // GailuElektronikoa Gehitu INSERT
    // --------------------------------------------------------------
    @PostMapping("/admin")
    public String sortuGailua(@ModelAttribute GailuElektronikoa gailuBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // AltaData automatikoa momentukoa jarri
        gailuBerria.setAltaData(new Date());
        // null hasieran
        // gailuBerria.setBajaData(null);

        gailuelektronikoaRepository.save(gailuBerria);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // GailuElektronikoa Aldatu UPDATE
    // --------------------------------------------------------------
    @PostMapping("/admin/update")
    public String aldatuGailua(@ModelAttribute GailuTaulaGaurEgun gailua, HttpSession session) {
        boolean amaieraFetxaHutsik = false;
        boolean gelaAldatu = false;
        boolean esleituta = false;

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Gela aldatu den konprobatu
        List<GailuTaulaGaurEgun> gailuakTaulaGaurEgun = gailuelektronikoaRepository.findGailuakGaurEgun();
        for (GailuTaulaGaurEgun item : gailuakTaulaGaurEgun) {
            if (item.getIdGailua().equals(gailua.getIdGailua())) {// arridura ikurra kendu dot
                if ((item.getIdGela() != null) && (gailua.getIdGela() != null)) {
                    if (!item.getIdGela().equals(gailua.getIdGela())) {
                        gelaAldatu = true;
                        break;
                    }
                } else {
                    if ((item.getIdGela() == null) && (gailua.getIdGela() == null)) {
                        break;
                    } else {
                        gelaAldatu = true;
                    }
                }
                break;
            }
        }

        // Gela aldatu bada:
        if (gelaAldatu) {
            // Gailua gela bati esleituta dagoen ziurtatu
            Egon egonDataHutsik = egonRepository.findByidGailuaGelanGaurEgun(gailua.getIdGailua());
            if (egonDataHutsik != null) {
                // Esleituta badago amaitutzat eman (Egon taulan). Berriz esleitu ahal izateko.
                // if ((gailua.getIdGela() != null)) {
                egonDataHutsik.setAmaieraData(new Date());
                egonRepository.save(egonDataHutsik);
                esleituta = true;
                // }
            }
            // Esleipen berria grabatu Egon taulan
            if (gailua.getIdGela() != null) {
                Egon egonBerria = new Egon();
                egonBerria.setIdGailua(gailua.getIdGailua());
                egonBerria.setIdGela(gailua.getIdGela());
                Date orain = new Date();
                egonBerria.setHasieraData(orain);
                egonRepository.save(egonBerria);
                // ondorengoa, historikorako egiten da.
                // berez gailua gela bati esleitu zaiola ager dadin. Besterik ez
                if (!esleituta) {
                    Date segunduBatGehixau = new Date(orain.getTime() + 1000);
                    egonBerria.setHasieraData(segunduBatGehixau);
                    egonRepository.save(egonBerria);
                }
            }

        }

        // GailuElektronikoak taulan gailua aurkitu:
        GailuElektronikoa datubasekoGailua = gailuelektronikoaRepository.findById(gailua.getIdGailua())
                .orElseThrow(() -> new RuntimeException("Gailua ez da aurkitu ID: " + gailua.getIdGailua()));

        // Gailua prestatu gordetzeko(Updatea egiteko)
        datubasekoGailua.setMarka(gailua.getMarka());
        datubasekoGailua.setModeloa(gailua.getModeloa());
        datubasekoGailua.setSerieZenb(gailua.getSerieZenb());
        datubasekoGailua.setMota(gailua.getMota());
        datubasekoGailua.setEgoera(gailua.getEgoera());
        // Updatea egin:
        gailuelektronikoaRepository.save(datubasekoGailua);

        return "redirect:/admin";
    }

    // --------------------------------------------------------------
    // GailuElektronikoa Ezabatu UPDATE
    // --------------------------------------------------------------
    // Gailua ez da ezabatuko, update bat egingo da baja data sartuaz eta egoera
    // bajan jarriaz.
    @PostMapping("/admin/delete")
    public String ezabatuGailua(@ModelAttribute GailuTaulaGaurEgun gailua, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Gela esleituta dagoen konprobatu, hala bada amaiera data ezarri
        Egon egonDataHutsik = egonRepository.findByidGailuaGelanGaurEgun(gailua.getIdGailua());
        if (egonDataHutsik != null) {
            egonDataHutsik.setAmaieraData(new Date());
            egonRepository.save(egonDataHutsik);
        }

        // GailuElektronikoak taulan gailua aurkitu:
        GailuElektronikoa datubasekoGailua = gailuelektronikoaRepository.findById(gailua.getIdGailua())
                .orElseThrow(() -> new RuntimeException("Gailua ez da aurkitu ID: " + gailua.getIdGailua()));

        // Gailua prestatu gordetzeko(Updatea egiteko)
        datubasekoGailua.setBajaData(new Date());
        datubasekoGailua.setEgoera(GailuEgoera.bajan);
        // Updatea egin:
        gailuelektronikoaRepository.save(datubasekoGailua);

        return "redirect:/admin";

    }

}