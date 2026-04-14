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
@Table(name = "egon")
public class egon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_egon;

    private Integer id_gailua;
    private Integer id_gela;
    private Date hasiera_data;
    private Date amaiera_data;


    public Integer getId_egon() {
        return id_egon;
    }
    public void setId_egon(Integer id_egon) {
        this.id_egon = id_egon;
    }
    public Integer getId_gailua() {
        return id_gailua;
    }
    public void setId_gailua(Integer id_gailua) {
        this.id_gailua = id_gailua;
    }
    public Integer getId_gela() {
        return id_gela;
    }
    public void setId_gela(Integer id_gela) {
        this.id_gela = id_gela;
    }
    public Date getHasiera_data() {
        return hasiera_data;
    }
    public void setHasiera_data(Date hasiera_data) {
        this.hasiera_data = hasiera_data;
    }
    public Date getAmaiera_data() {
        return amaiera_data;
    }
    public void setAmaiera_data(Date amaiera_data) {
        this.amaiera_data = amaiera_data;
    }
    
    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)
}