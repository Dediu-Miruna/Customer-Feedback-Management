
package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comentariu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentariuId;

    private String autor;         // Autorul comentariului (agent sau client)
    private String text;          // Conținutul comentariului
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relatia cu Ticket
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    // Constructori
    public Comentariu() {}

    public Comentariu(String autor, String text) {
        this.autor = autor;
        this.text = text;
    }

    // GETTERE ȘI SETTERE

    public Long getComentariuId() { return comentariuId; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
