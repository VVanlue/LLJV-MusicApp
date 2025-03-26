package com.model;

/**
 * Represents a musical measure, which includes information such as the time signature 
 * and tempo of the measure.
 * 
 * @author Victoria
 */
public class Measure {

    // Variables
    private int beatsPerMeasure;
    private int beatValue;
    private Tempo tempo;

    /**
     * Sets the time signature for the measure.
     * 
     * @param beatsPerMeasure The number of beats in the measure.
     * @param beatValue The note value that represents one beat (e.g., 4 for quarter note).
     */
    public void setTimeSignature(int beatsPerMeasure, int beatValue) {
        this.beatsPerMeasure = beatsPerMeasure;
        this.beatValue = beatValue;
    }

    /**
     * Sets the tempo for the measure.
     * 
     * @param tempo The tempo (beats per minute) for the measure.
     */
    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    /**
     * Gets the number of beats per measure.
     * 
     * @return The number of beats in the measure.
     */
    public int getBeatsPerMeasure() {
        return beatsPerMeasure;
    }

    /**
     * Gets the beat value (e.g., quarter note = 4, eighth note = 8).
     * 
     * @return The value of one beat in the measure.
     */
    public int getBeatValue() {
        return beatValue;
    }

    /**
     * Gets the tempo of the measure.
     * 
     * @return The tempo (beats per minute) for the measure.
     */
    public Tempo getTempo() {
        return tempo;
    }
}
