package org.example.feedback;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String status;
    private String prioritate;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent atribuitLui;

    @OneToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    private LocalDateTime creatLa = LocalDateTime.now();

    // Getteri și setteri
    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPrioritate() { return prioritate; }
    public void setPrioritate(String prioritate) { this.prioritate = prioritate; }

    public Agent getAtribuitLui() { return atribuitLui; }
    public void setAtribuitLui(Agent atribuitLui) { this.atribuitLui = atribuitLui; }

    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }

    public LocalDateTime getCreatLa() { return creatLa; }
    public void setCreatLa(LocalDateTime creatLa) { this.creatLa = creatLa; }
}
