package com.example.pollutiondashboard.entities;

public class Datapoint {
    Float emission;
    String source;

    public Datapoint(Float emission, String source) {
        this.emission = emission;
        this.source = source;
    }
}
