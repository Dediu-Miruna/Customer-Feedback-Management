package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produsId;

    private String nume;
    private String versiune;
    private LocalDate dataLansare;

    // Constructori
    public Produs() {}

    public Produs(String nume, String versiune, LocalDate dataLansare) {
        this.nume = nume;
        this.versiune = versiune;
        this.dataLansare = dataLansare;
    }

    // GETTERE & SETTERE

    public Long getProdusId() { return produsId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getVersiune() { return versiune; }
    public void setVersiune(String versiune) { this.versiune = versiune; }

    public LocalDate getDataLansare() { return dataLansare; }
    public void setDataLansare(LocalDate dataLansare) { this.dataLansare = dataLansare; }
}
