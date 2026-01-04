package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Raport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long raportId;

    private String tip;              // ex: "KPI", "SLA", "Sentiment"
    private String parametri;        // ex: "interval: 2024-01-01 -> 2024-01-31"
    private String generatDe;        // numele utilizatorului
    private String locatieFisier;    // ex: "/rapoarte/kpi123.pdf"

    private LocalDateTime generatLa = LocalDateTime.now();

    public Raport() {}

    public Raport(String tip, String parametri, String generatDe, String locatieFisier) {
        this.tip = tip;
        this.parametri = parametri;
        this.generatDe = generatDe;
        this.locatieFisier = locatieFisier;
    }

    // GETTERE & SETTERE

    public Long getRaportId() { return raportId; }

    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }

    public String getParametri() { return parametri; }
    public void setParametri(String parametri) { this.parametri = parametri; }

    public String getGeneratDe() { return generatDe; }
    public void setGeneratDe(String generatDe) { this.generatDe = generatDe; }

    public String getLocatieFisier() { return locatieFisier; }
    public void setLocatieFisier(String locatieFisier) { this.locatieFisier = locatieFisier; }

    public LocalDateTime getGeneratLa() { return generatLa; }
}
