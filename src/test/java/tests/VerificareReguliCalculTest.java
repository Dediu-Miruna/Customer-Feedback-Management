package tests;

import org.example.customerfeedback.services.ComputationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerificareReguliCalculTest {

    @Test
    void testCalculeazaNPS() {
        ComputationService service = new ComputationService();
        double rezultat = service.calculeazaNPS(60, 10, 100);
        assertEquals(50.0, rezultat);
    }

    @Test
    void testCalculeazaPerformantaSLA() {
        ComputationService service = new ComputationService();
        double rezultat = service.calculeazaPerformantaSLA(8, 10);
        assertEquals(80.0, rezultat);
    }

    @Test
    void testNPSCuTotalZero() {
        ComputationService service = new ComputationService();
        assertEquals(0.0, service.calculeazaNPS(5, 3, 0));
    }
}
