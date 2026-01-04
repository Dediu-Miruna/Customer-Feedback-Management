package org.example.customerfeedback.controllers;

import org.example.customerfeedback.dto.TicketDTO;
import org.example.customerfeedback.dto.ComentariuDTO;
import org.example.customerfeedback.enums.Prioritate;
import org.example.customerfeedback.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // ------------------ CREATE ----------------------
    @PostMapping("/{feedbackId}")
    public TicketDTO creeazaTicket(
            @PathVariable Long feedbackId,
            @RequestParam(required = false) Prioritate prioritate
    ) {
        return ticketService.creeazaTicketDTO(feedbackId, prioritate);
    }

    // ------------------ READ ------------------------
    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable Long id) {
        return ticketService.getTicketDTO(id);
    }

    @GetMapping
    public List<TicketDTO> getToateTichetele() {
        return ticketService.getToateTicheteleDTO();
    }

    // ------------------ WORKFLOW ---------------------
    @PutMapping("/{ticketId}/atribuie/{agentId}")
    public TicketDTO atribuieAgent(@PathVariable Long ticketId, @PathVariable Long agentId) {
        return ticketService.atribuieAgentDTO(ticketId, agentId);
    }

    @PutMapping("/{ticketId}/rezolvat")
    public TicketDTO marcheazaRezolvat(@PathVariable Long ticketId) {
        return ticketService.marcheazaRezolvatDTO(ticketId);
    }

    @PutMapping("/{ticketId}/inchis")
    public TicketDTO inchideTicket(@PathVariable Long ticketId) {
        return ticketService.inchideTicketDTO(ticketId);
    }

    // ------------------ DELETE -----------------------
    @DeleteMapping("/{id}")
    public void stergeTicket(@PathVariable Long id) {
        ticketService.stergeTicket(id);
    }

    // ------------------ COMMENTARII -------------------
    @PostMapping("/{ticketId}/comentarii")
    public ComentariuDTO adaugaComentariu(
            @PathVariable Long ticketId,
            @RequestParam String autor,
            @RequestParam String text
    ) {
        return ticketService.adaugaComentariuDTO(ticketId, autor, text);
    }

    @DeleteMapping("/{ticketId}/comentarii/{comentariuId}")
    public void stergeComentariu(
            @PathVariable Long ticketId,
            @PathVariable Long comentariuId
    ) {
        ticketService.stergeComentariu(ticketId, comentariuId);
    }
}
