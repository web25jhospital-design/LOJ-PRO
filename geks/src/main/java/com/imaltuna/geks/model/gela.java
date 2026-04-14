package com.imaltuna.geks.model;


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
@Table(name = "gela")
public class gela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gela;

    private String id_eraikina;
    private String izena;
    private String deskribapena;

    public Integer getId_gela() {
        return id_gela;
    }

    public void setId_gela(Integer id_gela) {
        this.id_gela = id_gela;
    }

    public String getId_eraikina() {
        return id_eraikina;
    }

    public void setId_eraikina(String id_eraikina) {
        this.id_eraikina = id_eraikina;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    // Getter-ak eta Setter-ak (Lombok baduzu @Data jarri dezakezu gainean)

}