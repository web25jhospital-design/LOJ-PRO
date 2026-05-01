package com.imaltuna.geks.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.Gela;


@Repository // Spring-i esaten dio klase honek datu-basearekin komunikazioa kudeatzen duela
public interface GelaRepository extends JpaRepository<Gela, Integer> {


    
    @Query("select idGela from Gela where idEraikina= :idEraikinapasa  ")
    public List <Integer> findByIdEraikina(@Param("idEraikinapasa") String idEraikinapasa);
   
    /* Hemen ez dugu metodorik idatzi behar momentuz.
       JpaRepository luzatzean, Spring-ek automatikoki ematen dizkigu:
       - findAll(): Erabiltzaile guztiak zerrendan lortzeko.
       - save(erabiltzailea): Erabiltzaile berri bat gordetzeko edo eguneratzeko.
       - findById(id): Id baten bidez erabiltzailea bilatzeko.
       - deleteById(id): Erabiltzailea ezabatzeko.
    */
}
