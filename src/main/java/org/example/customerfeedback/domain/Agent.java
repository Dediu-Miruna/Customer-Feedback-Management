package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String nume;
    private String email;
    private boolean activ;

    @OneToMany(
            mappedBy = "atribuitLui",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Ticket> tichete = new ArrayList<>();

    public Agent() {}

    public Agent(String nume, String email, boolean activ) {
        this.nume = nume;
        this.email = email;
        this.activ = activ;
    }

    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActiv() { return activ; }
    public void setActiv(boolean activ) { this.activ = activ; }

    public List<Ticket> getTichete() { return tichete; }
    public void setTichete(List<Ticket> tichete) { this.tichete = tichete; }

    public void adaugaTicket(Ticket t) {
        tichete.add(t);
        t.setAtribuitLui(this);
    }

    public void stergeTicket(Ticket t) {
        tichete.remove(t);
        t.setAtribuitLui(null);
    }
}

