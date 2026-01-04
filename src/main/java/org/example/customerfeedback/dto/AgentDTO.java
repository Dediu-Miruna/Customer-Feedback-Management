package org.example.customerfeedback.dto;

public class AgentDTO {

    private Long agentId;
    private String nume;
    private String email;
    private boolean activ;

    public AgentDTO() {}

    public AgentDTO(Long agentId, String nume, String email, boolean activ) {
        this.agentId = agentId;
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
}

