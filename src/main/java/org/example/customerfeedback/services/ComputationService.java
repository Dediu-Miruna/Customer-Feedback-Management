package org.example.customerfeedback.services;

import org.springframework.stereotype.Service;

@Service
public class ComputationService {

    // ---------------------------------------------------------------
    // CALCUL NPS (Net Promoter Score)
    // ---------------------------------------------------------------
    public double calculeazaNPS(int promotori, int detractori, int total) {

        if (total == 0) return 0;

        double procentPromotori = (double) promotori / total * 100;
        double procentDetractori = (double) detractori / total * 100;

        return procentPromotori - procentDetractori;
    }

    // ---------------------------------------------------------------
    // CALCUL SLA (tichete rezolvate la timp)
    // ---------------------------------------------------------------
    public double calculeazaPerformantaSLA(int ticheteRezolvateLaTimp, int totalTichete) {

        if (totalTichete == 0) return 0;

        return (double) ticheteRezolvateLaTimp / totalTichete * 100;
    }

    // ---------------------------------------------------------------
    // PROCENT FEEDBACK POZITIV (optional)
    // ---------------------------------------------------------------
    public double procentPozitiv(int pozitive, int total) {
        if (total == 0) return 0;
        return (double) pozitive / total * 100;
    }

    // ---------------------------------------------------------------
    // PROCENT FEEDBACK NEGATIV (optional)
    // ---------------------------------------------------------------
    public double procentNegativ(int negative, int total) {
        if (total == 0) return 0;
        return (double) negative / total * 100;
    }

    // ---------------------------------------------------------------
    // MEDIA SCOR FEEDBACK (optional)
    // ---------------------------------------------------------------
    public double medieScor(int sumaScoruri, int totalFeedbackuri) {
        if (totalFeedbackuri == 0) return 0;
        return (double) sumaScoruri / totalFeedbackuri;
    }
}

