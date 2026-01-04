package org.example.customerfeedback.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String nume;
    private String email;
    private String telefon;

    private boolean anonim;
    private String locale;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Feedback> feedbackList = new ArrayList<>();

    public Client() {}

    public Client(String nume, String email, boolean anonim) {
        this.nume = nume;
        this.email = email;
        this.anonim = anonim;
    }

    // GETTERE & SETTERE ---------------------------------------------------

    public Long getClientId() { return clientId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public boolean isAnonim() { return anonim; }
    public void setAnonim(boolean anonim) { this.anonim = anonim; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }

    public List<Feedback> getFeedbackList() { return feedbackList; }
    public void setFeedbackList(List<Feedback> feedbackList) { this.feedbackList = feedbackList; }

    // HELPER METHODS -------------------------------------------------------

    public void addFeedback(Feedback f) {
        feedbackList.add(f);
        f.setClient(this);
    }

    public void removeFeedback(Feedback f) {
        feedbackList.remove(f);
        f.setClient(null);
    }
}

