package org.example.feedback;

import java.util.List;

public class Categorie {

    private Long categoryId;
    private String nume;
    private Long parentCategoryId;
    private String prioritateImplicita;
    private Long slaTemplateId;

    private List<Feedback> feedbackuri;

    // Getteri și setteri
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public Long getParentCategoryId() { return parentCategoryId; }
    public void setParentCategoryId(Long parentCategoryId) { this.parentCategoryId = parentCategoryId; }

    public String getPrioritateImplicita() { return prioritateImplicita; }
    public void setPrioritateImplicita(String prioritateImplicita) { this.prioritateImplicita = prioritateImplicita; }

    public Long getSlaTemplateId() { return slaTemplateId; }
    public void setSlaTemplateId(Long slaTemplateId) { this.slaTemplateId = slaTemplateId; }

    public List<Feedback> getFeedbackuri() { return feedbackuri; }
    public void setFeedbackuri(List<Feedback> feedbackuri) { this.feedbackuri = feedbackuri; }
}

