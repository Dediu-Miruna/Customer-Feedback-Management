package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.*;
import org.example.customerfeedback.dto.*;
import org.example.customerfeedback.enums.Prioritate;
import org.example.customerfeedback.enums.TicketStatus;
import org.example.customerfeedback.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired private TicketRepository ticketRepository;
    @Autowired private FeedbackRepository feedbackRepository;
    @Autowired private AgentRepository agentRepository;
    @Autowired private ComentariuRepository comentariuRepository;

    // ===========================================================
    //                    MAPPER ENTITY -> DTO
    // ===========================================================

    private TicketDTO mapToDTO(Ticket ticket) {

        TicketDTO dto = new TicketDTO();

        dto.setTicketId(ticket.getTicketId());
        dto.setStatus(ticket.getStatus());
        dto.setPrioritate(ticket.getPrioritate());
        dto.setCreatedAt(ticket.getCreatedAt());
        dto.setUpdatedAt(ticket.getUpdatedAt());

        if(ticket.getAtribuitLui() != null)
            dto.setAgentId(ticket.getAtribuitLui().getAgentId());

        if(ticket.getFeedback() != null)
            dto.setFeedbackId(ticket.getFeedback().getFeedbackId());

        // Comentarii DTO
        dto.setComentarii(
                ticket.getComentarii()
                        .stream()
                        .map(c -> new ComentariuDTO(
                                c.getComentariuId(),
                                c.getAutor(),
                                c.getText(),
                                c.getCreatedAt()
                        ))
                        .toList()
        );

        // Istoric statusuri DTO
        dto.setIstorice(
                ticket.getIstorice()
                        .stream()
                        .map(s -> new StatusIstoricDTO(
                                s.getIstoricId(),
                                s.getVechiulStatus(),
                                s.getNoulStatus(),
                                s.getModificatDe(),
                                s.getModificatLa()
                        ))
                        .toList()
        );

        return dto;
    }

    // ===========================================================
    //                         CREATE
    // ===========================================================

    public TicketDTO creeazaTicketDTO(Long feedbackId, Prioritate prioritate) {

        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback-ul nu a fost găsit!"));

        Ticket ticket = new Ticket(
                TicketStatus.NOU,                            // ← CORESPUNDE enum-ului tău
                prioritate != null ? prioritate : Prioritate.MEDIE,
                feedback
        );

        return mapToDTO(ticketRepository.save(ticket));
    }

    // ===========================================================
    //                         READ
    // ===========================================================

    public TicketDTO getTicketDTO(Long id) {
        return ticketRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));
    }

    public List<TicketDTO> getToateTicheteleDTO() {
        return ticketRepository.findAll()
                .stream().map(this::mapToDTO).toList();
    }

    // ===========================================================
    //                  WORKFLOW (ATRIBUIRE / REZOLVARE / ÎNCHIDERE)
    // ===========================================================

    public TicketDTO atribuieAgentDTO(Long ticketId, Long agentId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));

        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agentul nu există!"));

        // Adăugăm istoric
        StatusIstoric ist = new StatusIstoric(
                ticket.getStatus(),
                TicketStatus.IN_LUCRU,          // ← când îl atribuim: IN_LUCRU
                agent.getNume()
        );
        ist.setTicket(ticket);
        ticket.adaugaStatus(ist);

        // Actualizăm starea
        ticket.setStatus(TicketStatus.IN_LUCRU);
        ticket.setAtribuitLui(agent);
        ticket.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(ticketRepository.save(ticket));
    }


    public TicketDTO marcheazaRezolvatDTO(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));

        StatusIstoric ist = new StatusIstoric(
                ticket.getStatus(),
                TicketStatus.REZOLVAT,          // ← conform enum-ului tău
                "system"
        );
        ist.setTicket(ticket);
        ticket.adaugaStatus(ist);

        ticket.setStatus(TicketStatus.REZOLVAT);
        ticket.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(ticketRepository.save(ticket));
    }


    public TicketDTO inchideTicketDTO(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));

        StatusIstoric ist = new StatusIstoric(
                ticket.getStatus(),
                TicketStatus.INCHIS,            // ← conform enum-ului tău
                "system"
        );
        ist.setTicket(ticket);
        ticket.adaugaStatus(ist);

        ticket.setStatus(TicketStatus.INCHIS);
        ticket.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(ticketRepository.save(ticket));
    }

    // ===========================================================
    //                        DELETE
    // ===========================================================

    public void stergeTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    // ===========================================================
    //                       COMENTARII
    // ===========================================================

    public ComentariuDTO adaugaComentariuDTO(Long ticketId, String autor, String text) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));

        Comentariu c = new Comentariu(autor, text);
        c.setTicket(ticket);
        ticket.adaugaComentariu(c);

        ticketRepository.save(ticket);

        return new ComentariuDTO(
                c.getComentariuId(),
                c.getAutor(),
                c.getText(),
                c.getCreatedAt()
        );
    }

    public void stergeComentariu(Long ticketId, Long comentariuId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Tichetul nu există!"));

        Comentariu comentariu = comentariuRepository.findById(comentariuId)
                .orElseThrow(() -> new RuntimeException("Comentariul nu există!"));

        ticket.stergeComentariu(comentariu);

        ticketRepository.save(ticket);
    }
}
