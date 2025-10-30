package org.example.customerfeedback.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String nume;
    private String email;
    private boolean activ;

    @OneToMany(mappedBy = "atribuitLui")
    private List<Ticket> tichete;

    // Getteri și setteri 
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
}
