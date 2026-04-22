package com.imaltuna.geks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.GailuElektronikoa;
import com.imaltuna.geks.model.GailuTaulaGaurEgun;

@Repository // Spring-i esaten dio klase honek datu-basearekin komunikazioa kudeatzen duela
public interface GailuElektronikoaRepository extends JpaRepository<GailuElektronikoa, Long> {


    
    // OXEL ↓

        // Usamos una consulta nativa (SQL puro) para ir a lo seguro
    @Query(value = "SELECT COUNT(*) FROM gailuelektronikoa WHERE egoera = 'erabilgarri'", nativeQuery = true)
    long contarDisponibles();

    // Cuenta dispositivos cuyo campo 'egoera' coincida con el texto pasado
    long countByEgoera(String egoera);

    // OXEL ↑



    @Query("select distinct egoera from GailuElektronikoa")
    public List<String> findDistinctEgoera();
    // public GailuElektronikoa findDistinctByEgoera();

    @Query("select distinct mota from GailuElektronikoa")
    public List<String> findDistinctMota();

    // Gailuen taula erakutsi ahal izateko selecta: hemen GailuElektronikoa eta Egon
    // taulakin bat sortuko da:
    @Query("SELECT new com.imaltuna.geks.model.GailuTaulaGaurEgun("
            + "g.idGailua, g.marka, g.modeloa, g.serieZenb, g.mota, g.egoera, g.altaData, g.bajaData, e.idGela, e.hasieraData)"
            +
            "FROM GailuElektronikoa g LEFT JOIN Egon e ON g.idGailua = e.idGailua AND e.amaieraData IS NULL")
    List<GailuTaulaGaurEgun> findGailuakGaurEgun();



    // OXEL ↓

    @Query(value = "SELECT COUNT(*) FROM gailuelektronikoa WHERE egoera = 'mantenuan'", nativeQuery = true)
    long contarMantenuan();

    @Query(value = "SELECT COUNT(*) FROM gailuelektronikoa WHERE egoera = 'bajan'", nativeQuery = true)
    long contarBajan();

    // OXEL ↑



    /*
     * Hemen ez dugu metodorik idatzi behar momentuz.
     * JpaRepository luzatzean, Spring-ek automatikoki ematen dizkigu:
     * - findAll(): Erabiltzaile guztiak zerrendan lortzeko.
     * - save(erabiltzailea): Erabiltzaile berri bat gordetzeko edo eguneratzeko.
     * - findById(id): Id baten bidez erabiltzailea bilatzeko.
     * - deleteById(id): Erabiltzailea ezabatzeko.
     */
}
