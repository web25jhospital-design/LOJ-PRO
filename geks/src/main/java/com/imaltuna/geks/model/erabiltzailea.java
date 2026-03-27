package com.imaltuna.geks.model;


import java.util.Date;

import jakarta.persistence.Entity;
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
public class erabiltzailea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_erabiltzailea;

    private String izena;
    private String abizena;
    private String erabiltzaile_izena;
    private String erabiltzaile_rola;
    private Date alta_data;
    private Date baja_data;
    private String pasahitza;

    // public erabiltzailea(String izena, String abizena, String erabiltzaile_izena,
    //         String erabiltzaile_rola, Date alta_data, Date baja_data, String pasahitza) {
    //     this.izena = izena;
    //     this.abizena = abizena;
    //     this.erabiltzaile_izena = erabiltzaile_izena;
    //     this.erabiltzaile_rola = erabiltzaile_rola;
    //     this.alta_data = alta_data;
    //     this.baja_data = baja_data;
    //     this.pasahitza = pasahitza;
    // }
    public int getId_erabiltzailea() {
        return id_erabiltzailea;
    }
    public void setId_erabiltzailea(int id_erabiltzailea) {
        this.id_erabiltzailea = id_erabiltzailea;
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
    public String getErabiltzaile_izena() {
        return erabiltzaile_izena;
    }
    public void setErabiltzaile_izena(String erabiltzaile_izena) {
        this.erabiltzaile_izena = erabiltzaile_izena;
    }
    public String getErabiltzaile_rola() {
        return erabiltzaile_rola;
    }
    public void setErabiltzaile_rola(String erabiltzaile_rola) {
        this.erabiltzaile_rola = erabiltzaile_rola;
    }
    public Date getAlta_data() {
        return alta_data;
    }
    public void setAlta_data(Date alta_data) {
        this.alta_data = alta_data;
    }
    public Date getBaja_data() {
        return baja_data;
    }
    public void setBaja_data(Date baja_data) {
        this.baja_data = baja_data;
    }
    public String getPasahitza() {
        return pasahitza;
    }
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)
}