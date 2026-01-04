package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.Agent;
import org.example.customerfeedback.domain.Ticket;
import org.example.customerfeedback.enums.TicketStatus;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    public void atribuieTicket(Ticket ticket, Agent agent) {
        ticket.setAtribuitLui(agent);
        ticket.setStatus(TicketStatus.IN_LUCRU);
    }

    public void marcheazaRezolvat(Ticket ticket) {
        ticket.setStatus(TicketStatus.REZOLVAT);
    }

    public void inchideTicket(Ticket ticket) {
        ticket.setStatus(TicketStatus.INCHIS);
    }

}
