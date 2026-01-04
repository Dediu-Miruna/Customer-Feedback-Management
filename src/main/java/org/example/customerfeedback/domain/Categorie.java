package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import org.example.customerfeedback.enums.Prioritate;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorieId;

    private String nume;
    private String descriere;

    // Prioritate implicită (ENUM)
    @Enumerated(EnumType.STRING)
    private Prioritate prioritateImplicita;

    // Constructori
    public Categorie() {}

    public Categorie(String nume, Prioritate prioritateImplicita) {
        this.nume = nume;
        this.prioritateImplicita = prioritateImplicita;
    }

    // GETTERE & SETTERE

    public Long getCategorieId() { return categorieId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public Prioritate getPrioritateImplicita() { return prioritateImplicita; }
    public void setPrioritateImplicita(Prioritate prioritateImplicita) {
        this.prioritateImplicita = prioritateImplicita;
    }
}


