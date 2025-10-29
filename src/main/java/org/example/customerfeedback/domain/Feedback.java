package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @NotBlank
    private String titlu;

    private String descriere;

    private String categorie;

    private LocalDateTime creatLa = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client trimisDe;

    @OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL)
    private Ticket ticket;

    // Getteri și setteri
    public Long getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public LocalDateTime getCreatLa() { return creatLa; }
    public void setCreatLa(LocalDateTime creatLa) { this.creatLa = creatLa; }

    public Client getTrimisDe() { return trimisDe; }
    public void setTrimisDe(Client trimisDe) { this.trimisDe = trimisDe; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
