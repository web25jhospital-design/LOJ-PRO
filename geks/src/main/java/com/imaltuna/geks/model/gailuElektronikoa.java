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
@Table(name = "gailuelektronikoa")
public class Gailuelektronikoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGailua;


    private String marka;
    private String modeloa;
    private String serieZenb;
    private Date altaData;
    private Date bajaData;
    
    public enum gailuEgoera{
        erabilgarri,
        hartua,
        mantenuan,
        bajan
    }

    @Enumerated(EnumType.STRING) // <- hau da garrantzitsua
    @Column(name = "egoera", nullable = false)
    private gailuEgoera egoera;
    private String mota;
    public Integer getIdGailua() {
        return idGailua;
    }
    public void setIdGailua(Integer idGailua) {
        this.idGailua = idGailua;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModeloa() {
        return modeloa;
    }
    public void setModeloa(String modeloa) {
        this.modeloa = modeloa;
    }
    public String getSerieZenb() {
        return serieZenb;
    }
    public void setSerieZenb(String serieZenb) {
        this.serieZenb = serieZenb;
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
    public gailuEgoera getEgoera() {
        return egoera;
    }
    public void setEgoera(gailuEgoera egoera) {
        this.egoera = egoera;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }




    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)
}
