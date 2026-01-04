package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import org.example.customerfeedback.enums.Prioritate;

@Entity
public class RegulaTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regulaId;

    private String numeRegula;

    // O expresie sau text simplu ce descrie condiția
    private String conditie;

    // O descriere a acțiunii ce trebuie aplicată
    private String actiune;

    // Prioritatea stabilită de regulă (opțional)
    @Enumerated(EnumType.STRING)
    private Prioritate prioritateSetata;

    // Escalare automată?
    private boolean necesitaEscalare;

    // Constructori
    public RegulaTicket() {}

    public RegulaTicket(String numeRegula, String conditie, String actiune,
                        Prioritate prioritateSetata, boolean necesitaEscalare) {
        this.numeRegula = numeRegula;
        this.conditie = conditie;
        this.actiune = actiune;
        this.prioritateSetata = prioritateSetata;
        this.necesitaEscalare = necesitaEscalare;
    }

    // GETTERE & SETTERE

    public Long getRegulaId() { return regulaId; }

    public String getNumeRegula() { return numeRegula; }
    public void setNumeRegula(String numeRegula) { this.numeRegula = numeRegula; }

    public String getConditie() { return conditie; }
    public void setConditie(String conditie) { this.conditie = conditie; }

    public String getActiune() { return actiune; }
    public void setActiune(String actiune) { this.actiune = actiune; }

    public Prioritate getPrioritateSetata() { return prioritateSetata; }
    public void setPrioritateSetata(Prioritate prioritateSetata) {
        this.prioritateSetata = prioritateSetata;
    }

    public boolean isNecesitaEscalare() { return necesitaEscalare; }
    public void setNecesitaEscalare(boolean necesitaEscalare) {
        this.necesitaEscalare = necesitaEscalare;
    }
}
