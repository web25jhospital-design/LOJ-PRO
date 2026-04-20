package com.imaltuna.geks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.Gailuelektronikoa;

@Repository // Spring-i esaten dio klase honek datu-basearekin komunikazioa kudeatzen duela
public interface GailuelektronikoaRepository extends JpaRepository<Gailuelektronikoa, Long> {

    @Query("select distinct egoera from Gailuelektronikoa")
    public List<String> findDistinctEgoera();
    // public GailuElektronikoa findDistinctByEgoera();


    
    @Query("select distinct mota from Gailuelektronikoa")
    public List<String> findDistinctMota();



    /*
     * Hemen ez dugu metodorik idatzi behar momentuz.
     * JpaRepository luzatzean, Spring-ek automatikoki ematen dizkigu:
     * - findAll(): Erabiltzaile guztiak zerrendan lortzeko.
     * - save(erabiltzailea): Erabiltzaile berri bat gordetzeko edo eguneratzeko.
     * - findById(id): Id baten bidez erabiltzailea bilatzeko.
     * - deleteById(id): Erabiltzailea ezabatzeko.
     */
}