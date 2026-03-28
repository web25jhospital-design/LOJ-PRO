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
    private Integer id_kudeatu;

    private Integer id_gailua;
    private Integer id_erabiltzailea;
    private Date kudeatze_data;

    public enum kudeaketa_mota{
        gehitu,
        editatu,
        ezabatu
    }

    @Enumerated(EnumType.STRING) // <- hau da garrantzitsua
    @Column(name = "kudeatze_mota", nullable = false)
    private kudeaketa_mota kudeatze_mota;

    public Integer getId_kudeatu() {
        return id_kudeatu;
    }

    public void setId_kudeatu(Integer id_kudeatu) {
        this.id_kudeatu = id_kudeatu;
    }

    public Integer getId_gailua() {
        return id_gailua;
    }

    public void setId_gailua(Integer id_gailua) {
        this.id_gailua = id_gailua;
    }

    public Integer getId_erabiltzailea() {
        return id_erabiltzailea;
    }

    public void setId_erabiltzailea(Integer id_erabiltzailea) {
        this.id_erabiltzailea = id_erabiltzailea;
    }

    public Date getKudeatze_data() {
        return kudeatze_data;
    }

    public void setKudeatze_data(Date kudeatze_data) {
        this.kudeatze_data = kudeatze_data;
    }

    public kudeaketa_mota getKudeatze_mota() {
        return kudeatze_mota;
    }

    public void setKudeatze_mota(kudeaketa_mota kudeatze_mota) {
        this.kudeatze_mota = kudeatze_mota;
    }
    
    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)

}
