package org.example.feedback;

public class RegulaTicket {

    private Long ruleId;
    private String conditieDeclansare;
    private String actiune;
    private int prag;  // de exemplu, timp în ore

    // Getteri și setteri
    public Long getRuleId() { return ruleId; }
    public void setRuleId(Long ruleId) { this.ruleId = ruleId; }

    public String getConditieDeclansare() { return conditieDeclansare; }
    public void setConditieDeclansare(String conditieDeclansare) { this.conditieDeclansare = conditieDeclansare; }

    public String getActiune() { return actiune; }
    public void setActiune(String actiune) { this.actiune = actiune; }

    public int getPrag() { return prag; }
    public void setPrag(int prag) { this.prag = prag; }
}
