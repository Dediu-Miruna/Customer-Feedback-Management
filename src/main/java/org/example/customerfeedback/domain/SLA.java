package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import org.example.customerfeedback.enums.Prioritate;

@Entity
public class SLA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slaId;

    private String nume;

    private Integer timpRaspunsOre;       // ex: 24h
    private Integer timpRezolvareOre;     // ex: 72h

    @Enumerated(EnumType.STRING)
    private Prioritate prioritateAplicabila;

    // Constructori
    public SLA() {}

    public SLA(String nume, Integer timpRaspunsOre, Integer timpRezolvareOre, Prioritate prioritateAplicabila) {
        this.nume = nume;
        this.timpRaspunsOre = timpRaspunsOre;
        this.timpRezolvareOre = timpRezolvareOre;
        this.prioritateAplicabila = prioritateAplicabila;
    }

    // GETTERE & SETTERE

    public Long getSlaId() { return slaId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public Integer getTimpRaspunsOre() { return timpRaspunsOre; }
    public void setTimpRaspunsOre(Integer timpRaspunsOre) { this.timpRaspunsOre = timpRaspunsOre; }

    public Integer getTimpRezolvareOre() { return timpRezolvareOre; }
    public void setTimpRezolvareOre(Integer timpRezolvareOre) { this.timpRezolvareOre = timpRezolvareOre; }

    public Prioritate getPrioritateAplicabila() { return prioritateAplicabila; }
    public void setPrioritateAplicabila(Prioritate prioritateAplicabila) {
        this.prioritateAplicabila = prioritateAplicabila;
    }
}


