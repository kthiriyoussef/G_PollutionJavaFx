package com.example.pollutiondashboard.entities;

public class Emission {
    private int idEmission;
    private String source;
    private String typeSource;
    private float emission;
    private int idSource;



    public Emission(String source, String typeSource, float emission) {
        this.source = source;
        this.typeSource = typeSource;
        this.emission = emission;
    }

    public Emission(int idEmission, String source, String typeSource, float emission) {
        this.idEmission = idEmission;
        this.source = source;
        this.typeSource = typeSource;
        this.emission = emission;
    }

    public int getIdEmission() {
        return idEmission;
    }

    public void setIdEmission(int idEmission) {
        this.idEmission = idEmission;
    }

    public String getSource() {
        return source;
    }
    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTypeSource() {
        return typeSource;
    }

    public void setTypeSource(String typeSource) {
        this.typeSource = typeSource;
    }

    public float getEmission() {
        return emission;
    }

    public void setEmission(float emission) {
        this.emission = emission;
    }
}
