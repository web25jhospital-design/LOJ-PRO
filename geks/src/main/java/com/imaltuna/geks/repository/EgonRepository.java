package com.imaltuna.geks.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.Egon;


@Repository // Spring-i esaten dio klase honek datu-basearekin komunikazioa kudeatzen duela
public interface EgonRepository extends JpaRepository<Egon, Long> {
   
    @Query("select e from Egon e where e.idGailua= :gailuaIda and e.amaieraData is null")
    public Egon findByidGailuaGelanGaurEgun(@Param("gailuaIda") Integer gailuaIda);

    @Query("select e from Egon e where e.idGela= :gelaIdea and e.amaieraData is null")
    public List <Egon> findByidGelaGaurEgun(@Param("gelaIdea") Integer gelaIdea);

    
    /* Hemen ez dugu metodorik idatzi behar momentuz.
       JpaRepository luzatzean, Spring-ek automatikoki ematen dizkigu:
       - findAll(): Erabiltzaile guztiak zerrendan lortzeko.
       - save(erabiltzailea): Erabiltzaile berri bat gordetzeko edo eguneratzeko.
       - findById(id): Id baten bidez erabiltzailea bilatzeko.
       - deleteById(id): Erabiltzailea ezabatzeko.
    */
}
