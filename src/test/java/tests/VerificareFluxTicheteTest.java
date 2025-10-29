package tests;

import org.example.customerfeedback.domain.Agent;
import org.example.customerfeedback.domain.Ticket;
import org.example.customerfeedback.enums.TicketStatus;
import org.example.customerfeedback.services.WorkflowService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerificareFluxTicheteTest {

    @Test
    void testAtribuireTicket() {
        WorkflowService service = new WorkflowService();
        Ticket t = new Ticket();
        Agent a = new Agent();
        a.setNume("Mihai Ionescu");

        service.atribuieTicket(t, a);

        assertEquals(a, t.getAtribuitLui());
        assertEquals(TicketStatus.IN_LUCRU.name(), t.getStatus());
    }

    @Test
    void testMarcheazaRezolvat() {
        WorkflowService service = new WorkflowService();
        Ticket t = new Ticket();

        service.marcheazaRezolvat(t);
        assertEquals(TicketStatus.REZOLVAT.name(), t.getStatus());
    }

    @Test
    void testInchideTicket() {
        WorkflowService service = new WorkflowService();
        Ticket t = new Ticket();

        service.inchideTicket(t);
        assertEquals(TicketStatus.INCHIS.name(), t.getStatus());
    }
}

