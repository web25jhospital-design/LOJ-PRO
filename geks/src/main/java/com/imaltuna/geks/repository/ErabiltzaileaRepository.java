package com.imaltuna.geks.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.Erabiltzailea;


@Repository // Spring-i esaten dio klase honek datu-basearekin komunikazioa kudeatzen duela
public interface ErabiltzaileaRepository extends JpaRepository<Erabiltzailea, Long> {

    public Erabiltzailea findByerabiltzaileIzena(String erabiltzailea);
    
   
    /* Hemen ez dugu metodorik idatzi behar momentuz.
       JpaRepository luzatzean, Spring-ek automatikoki ematen dizkigu:
       - findAll(): Erabiltzaile guztiak zerrendan lortzeko.
       - save(erabiltzailea): Erabiltzaile berri bat gordetzeko edo eguneratzeko.
       - findById(id): Id baten bidez erabiltzailea bilatzeko.
       - deleteById(id): Erabiltzailea ezabatzeko.
    */
}
