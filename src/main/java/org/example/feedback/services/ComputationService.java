package org.example.feedback.services;

public class ComputationService {

    // Exemplu: calcul Net Promoter Score
    public double calculeazaNPS(int promotori, int detractori, int total) {
        if (total == 0) return 0;
        return ((double) promotori / total * 100) - ((double) detractori / total * 100);
    }

    // Exemplu: procent SLA îndeplinit
    public double calculeazaPerformantaSLA(int ticheteRezolvateLaTimp, int totalTichete) {
        if (totalTichete == 0) return 0;
        return (double) ticheteRezolvateLaTimp / totalTichete * 100;
    }
}
