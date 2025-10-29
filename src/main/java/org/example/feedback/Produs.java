package org.example.feedback;

import java.time.LocalDate;

public class Produs {

    private Long productId;
    private String nume;
    private String versiune;
    private LocalDate dataLansare;

    // Getteri și setteri
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getVersiune() { return versiune; }
    public void setVersiune(String versiune) { this.versiune = versiune; }

    public LocalDate getDataLansare() { return dataLansare; }
    public void setDataLansare(LocalDate dataLansare) { this.dataLansare = dataLansare; }
}

