package org.example.feedback.services;

import org.example.feedback.Agent;
import org.example.feedback.Ticket;
import org.example.feedback.enums.TicketStatus;

public class WorkflowService {

    public void atribuieTicket(Ticket ticket, Agent agent) {
        ticket.setAtribuitLui(agent);
        ticket.setStatus(TicketStatus.IN_LUCRU.name());
    }

    public void marcheazaRezolvat(Ticket ticket) {
        ticket.setStatus(TicketStatus.REZOLVAT.name());
    }

    public void inchideTicket(Ticket ticket) {
        ticket.setStatus(TicketStatus.INCHIS.name());
    }
}

