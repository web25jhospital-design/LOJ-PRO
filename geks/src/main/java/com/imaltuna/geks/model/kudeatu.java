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
@Table(name = "kudeatu")
public class kudeatu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKudeatu;

    private Integer idGailua;
    private Integer idErabiltzailea;
    private Date kudeatzeData;

    public enum kudeaketaMota{
        gehitu,
        editatu,
        ezabatu
    }

    @Enumerated(EnumType.STRING) // <- hau da garrantzitsua
    @Column(name = "kudeatzeMota", nullable = false)
    private kudeaketaMota kudeatzeMota;

    public Integer getIdKudeatu() {
        return idKudeatu;
    }

    public void setIdKudeatu(Integer idKudeatu) {
        this.idKudeatu = idKudeatu;
    }

    public Integer getIdGailua() {
        return idGailua;
    }

    public void setIdGailua(Integer idGailua) {
        this.idGailua = idGailua;
    }

    public Integer getIdErabiltzailea() {
        return idErabiltzailea;
    }

    public void setIdErabiltzailea(Integer idErabiltzailea) {
        this.idErabiltzailea = idErabiltzailea;
    }

    public Date getKudeatzeData() {
        return kudeatzeData;
    }

    public void setKudeatzeData(Date kudeatzeData) {
        this.kudeatzeData = kudeatzeData;
    }

    public kudeaketaMota getKudeatzeMota() {
        return kudeatzeMota;
    }

    public void setKudeatzeMota(kudeaketaMota kudeatzeMota) {
        this.kudeatzeMota = kudeatzeMota;
    }

    

    
    
    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)

}
