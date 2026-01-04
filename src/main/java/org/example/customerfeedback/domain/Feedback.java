package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import org.example.customerfeedback.enums.FeedbackType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String titlu;
    private String descriere;
    private String source;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private FeedbackType tip;

    private Integer sentimentScore;

    // ---------------- RELAȚII ---------------------

    // CLIENT
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // CATEGORIE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // PRODUS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produs_id")
    private Produs produs;

    // ATASAMENTE (OneToMany)
    @OneToMany(
            mappedBy = "feedback",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Atasament> atasamente = new ArrayList<>();

    // TICHETE (OneToMany)
    @OneToMany(
            mappedBy = "feedback",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Ticket> tickets = new ArrayList<>();

    // ANALIZA SENTIMENT (OneToOne)
    @OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL)
    private RezultatAnalizaSentiment rezultatAnaliza;

    // ---------------- CONSTRUCTORI ---------------------

    public Feedback() {}

    public Feedback(String titlu, String descriere, FeedbackType tip) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.tip = tip;
    }

    // ---------------- GETTERE & SETTERE -----------------

    public Long getFeedbackId() { return feedbackId; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public FeedbackType getTip() { return tip; }
    public void setTip(FeedbackType tip) { this.tip = tip; }

    public Integer getSentimentScore() { return sentimentScore; }
    public void setSentimentScore(Integer sentimentScore) { this.sentimentScore = sentimentScore; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public Produs getProdus() { return produs; }
    public void setProdus(Produs produs) { this.produs = produs; }

    public List<Atasament> getAtasamente() { return atasamente; }
    public void setAtasamente(List<Atasament> atasamente) { this.atasamente = atasamente; }

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    public RezultatAnalizaSentiment getRezultatAnaliza() { return rezultatAnaliza; }
    public void setRezultatAnaliza(RezultatAnalizaSentiment rezultatAnaliza) {
        this.rezultatAnaliza = rezultatAnaliza;
        if (rezultatAnaliza != null) {
            rezultatAnaliza.setFeedback(this);
        }
    }

    // ---------------- HELPER METHODS -------------------

    public void addAtasament(Atasament a) {
        atasamente.add(a);
        a.setFeedback(this);
    }

    public void removeAtasament(Atasament a) {
        atasamente.remove(a);
        a.setFeedback(null);
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
        t.setFeedback(this);
    }

    public void removeTicket(Ticket t) {
        tickets.remove(t);
        t.setFeedback(null);
    }
}

