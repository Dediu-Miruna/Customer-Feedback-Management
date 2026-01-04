package org.example.customerfeedback.controllers;

import org.example.customerfeedback.dto.AgentDTO;
import org.example.customerfeedback.services.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenti")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    public AgentDTO adaugaAgent(
            @RequestParam String nume,
            @RequestParam String email,
            @RequestParam boolean activ
    ) {
        return agentService.adaugaAgent(nume, email, activ);
    }

    @GetMapping("/{id}")
    public AgentDTO getAgent(@PathVariable Long id) {
        return agentService.getAgent(id);
    }

    @GetMapping
    public List<AgentDTO> getTotiAgentii() {
        return agentService.getTotiAgentii();
    }

    @PutMapping("/{id}")
    public AgentDTO actualizeazaAgent(
            @PathVariable Long id,
            @RequestParam String nume,
            @RequestParam String email,
            @RequestParam boolean activ
    ) {
        return agentService.actualizeazaAgent(id, nume, email, activ);
    }

    @DeleteMapping("/{id}")
    public void stergeAgent(@PathVariable Long id) {
        agentService.stergeAgent(id);
    }
}
