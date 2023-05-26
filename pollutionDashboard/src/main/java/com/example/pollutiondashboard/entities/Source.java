package com.example.pollutiondashboard.entities;

public class Source {
    private int idSource;
    private String sourceEmission;
    private String typeSource;
    private String limiteReglementaire;

private String emplacement;

    private String activite;
    private  String responsable;

    public Source(int idSource, String sourceEmission, String typeSource, String Res,String limiteReglementaire, String activité) {
        this.idSource = idSource;
        this.sourceEmission = sourceEmission;
        this.typeSource = typeSource;
        this.responsable=Res;
        this.limiteReglementaire = limiteReglementaire;
        this.activite = activité;
    }

    public Source(String sourceEmission, String typeSource, String Res,String limiteReglementaire, String activité) {
        this.sourceEmission = sourceEmission;
        this.typeSource = typeSource;

        this.responsable=Res;
        this.limiteReglementaire = limiteReglementaire;
        this.activite = activité;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public String getSourceEmission() {
        return sourceEmission;
    }

    public void setSourceEmission(String sourceEmission) {
        this.sourceEmission = sourceEmission;
    }

    public String getTypeSource() {
        return typeSource;
    }

    public void setTypeSource(String typeSource) {
        this.typeSource = typeSource;
    }

    public String getLimiteReglementaire() {
        return limiteReglementaire;
    }

    public String setLimiteReglementaire(String limiteReglementaire) {
        return  this.limiteReglementaire = limiteReglementaire;
    }



    @Override
    public String toString() {
        return "Source{" +
                "sourceEmission='" + sourceEmission + '\'' +
                ", typeSource='" + typeSource + '\'' +
                ", limiteReglementaire=" + limiteReglementaire +
                ", Activité='" + activite + '\'' +
                '}';
    }
}
