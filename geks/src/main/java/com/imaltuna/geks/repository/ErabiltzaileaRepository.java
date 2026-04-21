package com.imaltuna.geks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaltuna.geks.model.Erabiltzailea;

@Repository
public interface ErabiltzaileaRepository extends JpaRepository<Erabiltzailea, Long> {

    public Erabiltzailea findByerabiltzaileIzena(String erabiltzailea);
}