package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import org.example.customerfeedback.enums.Prioritate;
import org.example.customerfeedback.enums.TicketStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private Prioritate prioritate;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    // ---------------- RELAȚII --------------------

    // Relatie cu Agent
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent atribuitLui;

    // Relatie cu Feedback
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    // Comentarii
    @OneToMany(
            mappedBy = "ticket",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comentariu> comentarii = new ArrayList<>();

    // Istoric statusuri
    @OneToMany(
            mappedBy = "ticket",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StatusIstoric> istorice = new ArrayList<>();

    // ---------------- CONSTRUCTORI --------------------

    public Ticket() {}

    public Ticket(TicketStatus status, Prioritate prioritate) {
        this.status = status;
        this.prioritate = prioritate;
    }

    // ✔ Constructorul necesar pentru TicketService
    public Ticket(TicketStatus status, Prioritate prioritate, Feedback feedback) {
        this.status = status;
        this.prioritate = prioritate;
        this.feedback = feedback;
        this.createdAt = LocalDateTime.now();
    }

    // ---------------- GETTERE + SETTERE ----------------

    public Long getTicketId() { return ticketId; }

    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }

    public Prioritate getPrioritate() { return prioritate; }
    public void setPrioritate(Prioritate prioritate) { this.prioritate = prioritate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Agent getAtribuitLui() { return atribuitLui; }
    public void setAtribuitLui(Agent atribuitLui) { this.atribuitLui = atribuitLui; }

    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }

    public List<Comentariu> getComentarii() { return comentarii; }
    public void setComentarii(List<Comentariu> comentarii) { this.comentarii = comentarii; }

    public List<StatusIstoric> getIstorice() { return istorice; }
    public void setIstorice(List<StatusIstoric> istorice) { this.istorice = istorice; }

    // ---------------- HELPER METHODS ----------------

    public void adaugaComentariu(Comentariu c) {
        comentarii.add(c);
        c.setTicket(this);
    }

    public void stergeComentariu(Comentariu c) {
        comentarii.remove(c);
        c.setTicket(null);
    }

    public void adaugaStatus(StatusIstoric s) {
        istorice.add(s);
        s.setTicket(this);
    }

    public void stergeStatus(StatusIstoric s) {
        istorice.remove(s);
        s.setTicket(null);
    }
}
