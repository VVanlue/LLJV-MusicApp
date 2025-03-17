package com.model;

// Variables
public class Measure {

    // Variables
    private int beatsPerMeasure;
    private int beatValue;
    private Tempo tempo;

    // Methods
    public void setTimeSignature(int beatsPerMeasure, int beatValue) {
        this.beatsPerMeasure = beatsPerMeasure;
        this.beatValue = beatValue;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public int getBeatsPerMeasure() {
        return beatsPerMeasure;
    }

    public int getBeatValue() {
        return beatValue;
    }

    public Tempo getTempo() {
        return tempo;
    }
}
