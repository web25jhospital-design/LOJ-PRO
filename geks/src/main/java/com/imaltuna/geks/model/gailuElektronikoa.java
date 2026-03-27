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
public class gailuElektronikoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gailua;


    private String marka;
    private String modeloa;
    private String serie_zenb;
    private Date alta_data;
    private Date baja_data;
    
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


    

    public gailuElektronikoa(String marka, String modeloa, String serie_zenb, Date alta_data,
            Date baja_data, gailuEgoera egoera, String mota) {
        this.marka = marka;
        this.modeloa = modeloa;
        this.serie_zenb = serie_zenb;
        this.alta_data = alta_data;
        this.baja_data = baja_data;
        this.egoera = egoera;
        this.mota = mota;
    }

    public int getId_gailua() {
        return id_gailua;
    }

    public void setId_gailua(int id_gailua) {
        this.id_gailua = id_gailua;
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

    public String getSerie_zenb() {
        return serie_zenb;
    }

    public void setSerie_zenb(String serie_zenb) {
        this.serie_zenb = serie_zenb;
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
