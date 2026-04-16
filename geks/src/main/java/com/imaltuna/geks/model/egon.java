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
    private Integer idEgon;

    private Integer idGailua;
    private Integer idGela;
    private Date hasieraData;
    private Date amaieraData;
    
    public Integer getIdEgon() {
        return idEgon;
    }
    public void setIdEgon(Integer idEgon) {
        this.idEgon = idEgon;
    }
    public Integer getIdGailua() {
        return idGailua;
    }
    public void setIdGailua(Integer idGailua) {
        this.idGailua = idGailua;
    }
    public Integer getIdGela() {
        return idGela;
    }
    public void setIdGela(Integer idGela) {
        this.idGela = idGela;
    }
    public Date getHasieraData() {
        return hasieraData;
    }
    public void setHasieraData(Date hasieraData) {
        this.hasieraData = hasieraData;
    }
    public Date getAmaieraData() {
        return amaieraData;
    }
    public void setAmaieraData(Date amaieraData) {
        this.amaieraData = amaieraData;
    }



    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)
}