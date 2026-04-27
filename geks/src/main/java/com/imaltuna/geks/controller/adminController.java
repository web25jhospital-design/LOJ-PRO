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
import com.imaltuna.geks.model.Eraikina;
import com.imaltuna.geks.model.GailuEgoera;
import com.imaltuna.geks.model.GailuElektronikoa;
import com.imaltuna.geks.model.GailuTaulaGaurEgun;
import com.imaltuna.geks.model.Gela;
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
        // Model-a "motxila" bat bezalakoa da: Javan sartzen ditugu datuak HTML-an
        // erabili ahal izateko

        // Datu-baseko eraikin guztiak zerrenda batean lortu eta HTMLra pasatu
        // HTML-an "eraikinak" erabiliko dugu (th:each bidez normalean)
        model.addAttribute("eraikina", eraikinaRepository.findAll()); // ✪ OXEL
        // model.addAttribute("eraikinIDak", eraikinaRepository.findDistinctID)

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

        // GAKOA: "admin" hitzak esaten dio Spring-i templates/admin.html fitxategia
        // bilatzeko
        return "admin";
    }

    // --------------------------------------------------------------
    // GailuElektronikoa Gehitu INSERT
    // --------------------------------------------------------------
    @PostMapping("/gailua/gehitu")
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
    @PostMapping("/gailua/update")
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
            if (item.getIdGailua().equals(gailua.getIdGailua())) {
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
    // GailuElektronikoa Ezabatu DELETE
    // --------------------------------------------------------------
    // Gailua ez da ezabatuko, update bat egingo da baja data sartuaz eta egoera
    // bajan jarriaz.
    @PostMapping("/gailua/delete")
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

    // --------------------------------------------------------------
    // Erabiltzailea Gehitu INSERT
    // --------------------------------------------------------------
    @PostMapping("/erabiltzailea/gehitu")
    public String sortuErabiltzailea(@ModelAttribute Erabiltzailea erabBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // AltaData automatikoa momentukoa jarri
        erabBerria.setAltaData(new Date());
        // null hasieran
        // gailuBerria.setBajaData(null);

        erabiltzaileaRepository.save(erabBerria);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // Erabiltzailea Aldatu UPDATE
    // --------------------------------------------------------------
    @PostMapping("/erabiltzailea/update")
    public String updateErabiltzailea(@ModelAttribute Erabiltzailea erabBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Erabiltzailea taulan erabiltzailea aurkitu:
        Erabiltzailea datubasekoErabiltzailea = erabiltzaileaRepository.findById(erabBerria.getIdErabiltzailea())
                .orElseThrow(() -> new RuntimeException(
                        "Erabiltzailea ez da aurkitu ID: " + erabBerria.getIdErabiltzailea()));

        // Pasahitza aldatu den konprobatu:
        if (!erabBerria.getPasahitza().equals("*********")) {
            datubasekoErabiltzailea.setPasahitza(erabBerria.getPasahitza());
        }
        datubasekoErabiltzailea.setIzena(erabBerria.getIzena());
        datubasekoErabiltzailea.setAbizena(erabBerria.getAbizena());
        datubasekoErabiltzailea.setErabiltzaileIzena(erabBerria.getErabiltzaileIzena());
        datubasekoErabiltzailea.setErabiltzaileRola(erabBerria.getErabiltzaileRola());

        erabiltzaileaRepository.save(datubasekoErabiltzailea);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // Erabiltzailea Ezabatu DELETE
    // --------------------------------------------------------------
    @PostMapping("/erabiltzailea/delete")
    public String ezabatuErabiltzailea(@ModelAttribute Erabiltzailea erabBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Erabiltzailea taulan erabiltzailea aurkitu:
        Erabiltzailea datubasekoErabiltzailea = erabiltzaileaRepository.findById(erabBerria.getIdErabiltzailea())
                .orElseThrow(() -> new RuntimeException(
                        "Erabiltzailea ez da aurkitu ID: " + erabBerria.getIdErabiltzailea()));

        // Erabiltzailea prestatu baja emateko:
        datubasekoErabiltzailea.setBajaData(new Date());

        erabiltzaileaRepository.save(datubasekoErabiltzailea);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // Gela Gehitu INSERT
    // --------------------------------------------------------------
    @PostMapping("/gela/gehitu")
    public String sortuGela(@ModelAttribute Gela gelaBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        gelaRepository.save(gelaBerria);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // Gela Aldatu INSERT
    // --------------------------------------------------------------
    @PostMapping("/gela/update")
    public String aldatuGela(@ModelAttribute Gela gelaBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Gela taulan gela aurkitu:
        Gela datubasekoGela = gelaRepository.findById(gelaBerria.getIdGela())
                .orElseThrow(() -> new RuntimeException("Gela ez da aurkitu ID: " + gelaBerria.getIdGela()));

        datubasekoGela.setIdEraikina(gelaBerria.getIdEraikina());
        datubasekoGela.setIzena(gelaBerria.getIzena());
        datubasekoGela.setDeskribapena(gelaBerria.getDeskribapena());
        gelaRepository.save(datubasekoGela);
        return "redirect:/admin"; // Orria freskatu
    }

    // --------------------------------------------------------------
    // Gela Ezabatu INSERT
    // --------------------------------------------------------------
    @PostMapping("/gela/delete")
    public String ezabatuGela(@ModelAttribute Gela gelaBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        // Gela esleituta dagoen konprobatu, hala bada erabilgarri utzi
        List<Egon> egonDataHutsik = egonRepository.findByidGelaGaurEgun(gelaBerria.getIdGela());
        if (egonDataHutsik != null) {
            for (Egon item : egonDataHutsik) {
                GailuElektronikoa datubasekoGailua = gailuelektronikoaRepository.findById(item.getIdGailua())
                        .orElseThrow(() -> new RuntimeException("Gailua ez da aurkitu ID: " + item.getIdGailua()));
                if (datubasekoGailua.getEgoera() == GailuEgoera.esleitua) {
                    // Gailua prestatu gordetzeko(Updatea egiteko)
                    datubasekoGailua.setEgoera(GailuEgoera.erabilgarri);
                    // Updatea egin:
                    gailuelektronikoaRepository.save(datubasekoGailua);
                }
            }
        }
        // gela ezabatu datu basetik.
        gelaRepository.deleteById(gelaBerria.getIdGela());
        return "redirect:/admin"; // Orria freskatu
    }
    // --------------------------------------------------------------
    // Eraikina Gehitu INSERT
    // --------------------------------------------------------------
    @PostMapping("/eraikina/gehitu")
    public String sortuGela(@ModelAttribute Eraikina eraikinBerria, HttpSession session) {

        // Logeatutako erabiltzailea lortu SQLari pasatzeko:
        Erabiltzailea erabiltzailea = (Erabiltzailea) session.getAttribute("logeatutakoErab");
        // MySQL-ko sesio aldagaia ezarri
        jdbcTemplate.execute("SET @erabiltzailea = '" + erabiltzailea.getIdErabiltzailea() + "'");

        eraikinaRepository.save(eraikinBerria);
        return "redirect:/admin"; // Orria freskatu
    }

}