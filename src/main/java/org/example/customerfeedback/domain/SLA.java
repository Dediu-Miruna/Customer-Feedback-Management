package org.example.customerfeedback.domain;

public class SLA {

    private Long slaId;
    private String nume;
    private int timpRaspunsOre;
    private int timpRezolvareOre;
    private String politicaEscaladare;

    // Getteri și setteri
    public Long getSlaId() { return slaId; }
    public void setSlaId(Long slaId) { this.slaId = slaId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public int getTimpRaspunsOre() { return timpRaspunsOre; }
    public void setTimpRaspunsOre(int timpRaspunsOre) { this.timpRaspunsOre = timpRaspunsOre; }

    public int getTimpRezolvareOre() { return timpRezolvareOre; }
    public void setTimpRezolvareOre(int timpRezolvareOre) { this.timpRezolvareOre = timpRezolvareOre; }

    public String getPoliticaEscaladare() { return politicaEscaladare; }
    public void setPoliticaEscaladare(String politicaEscaladare) { this.politicaEscaladare = politicaEscaladare; }
}

