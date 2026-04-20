package com.imaltuna.geks.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// Jakarta Persistence API. Hibernatek datu-basearekin lan egiteko erabiltzen dituen arau multzoak.

// import jakarta.persistence.Entity;
// @Entity etiketa erabili ahal izateko. EZ da klase arrunt bat, datu-baseko taula baten irudikapena da".
// Hibernatek hau ikusten duenean, badaki klase horrekin MySQL taula bat kudeatu behar duela.


// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// GenerationType eta GeneratedValue batera doaz. Erabiltzaile berri bat sortzen den bakoitzean balio bat sortuko du.


// import jakarta.persistence.Id; @Id etiketa erabili ahal izateko. Gako nagusia zein den adierazten da.


// import jakarta.persistence.Table; @Table etiketa erabili ahal izateko.
// Datu baseko zein taula erabili behar duen adieraziko zaio.



@Entity
@Table(name = "erabiltzailea")
public class Erabiltzailea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idErabiltzailea;

    private String izena;
    private String abizena;
    private String erabiltzaileIzena;

    // public enum Rola{
    //     admin,
    //     arrunta
    // }

    @Enumerated(EnumType.STRING) // <- hau da garrantzitsua
    @Column(name = "erabiltzaileRola", nullable = false)
    private Rola erabiltzaileRola;
    private Date altaData;
    private Date bajaData;
    private String pasahitza;


    public Integer getIdErabiltzailea() {
        return idErabiltzailea;
    }
    public void setIdErabiltzailea(Integer idErabiltzailea) {
        this.idErabiltzailea = idErabiltzailea;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getAbizena() {
        return abizena;
    }
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }
    public String getErabiltzaileIzena() {
        return erabiltzaileIzena;
    }
    public void setErabiltzaileIzena(String erabiltzaileIzena) {
        this.erabiltzaileIzena = erabiltzaileIzena;
    }
    public Rola getErabiltzaileRola() {
        return erabiltzaileRola;
    }
    public void setErabiltzaileRola(Rola erabiltzaileRola) {
        this.erabiltzaileRola = erabiltzaileRola;
    }
    public Date getAltaData() {
        return altaData;
    }
    public void setAltaData(Date altaData) {
        this.altaData = altaData;
    }
    public Date getBajaData() {
        return bajaData;
    }
    public void setBajaData(Date bajaData) {
        this.bajaData = bajaData;
    }
    public String getPasahitza() {
        return pasahitza;
    }
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
   

    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)
}