package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.Agent;
import org.example.customerfeedback.dto.AgentDTO;
import org.example.customerfeedback.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    // MAPPER
    private AgentDTO mapToDTO(Agent agent) {
        return new AgentDTO(
                agent.getAgentId(),
                agent.getNume(),
                agent.getEmail(),
                agent.isActiv()
        );
    }

    // CREATE
    public AgentDTO adaugaAgent(String nume, String email, boolean activ) {
        Agent agent = new Agent(nume, email, activ);
        return mapToDTO(agentRepository.save(agent));
    }

    // READ ONE
    public AgentDTO getAgent(Long id) {
        return agentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Agentul nu a fost găsit!"));
    }

    // READ ALL
    public List<AgentDTO> getTotiAgentii() {
        return agentRepository.findAll()
                .stream().map(this::mapToDTO).toList();
    }

    // UPDATE
    public AgentDTO actualizeazaAgent(Long id, String nume, String email, boolean activ) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agentul nu există!"));

        agent.setNume(nume);
        agent.setEmail(email);
        agent.setActiv(activ);

        return mapToDTO(agentRepository.save(agent));
    }

    // DELETE
    public void stergeAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
