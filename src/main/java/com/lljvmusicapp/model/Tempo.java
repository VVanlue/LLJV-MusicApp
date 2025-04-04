package com.lljvmusicapp.model;

/**
 * Represents a musical tempo in beats per minute (BPM).
 * Provides methods to modify and retrieve the tempo.
 * 
 * @author Victoria
 */
public class Tempo {

    // Attributes
    private int BPM; // Beats per minute (tempo)

    /**
     * Constructor to create a Tempo object with a specified BPM.
     * 
     * @param BPM The beats per minute for the tempo.
     */
    public Tempo(int BPM) {
        this.BPM = BPM;
    }

    /**
     * Sets the beats per minute (BPM) for the tempo.
     * 
     * @param BPM The new beats per minute for the tempo.
     */
    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    /**
     * Increases the current BPM by a specified amount.
     * 
     * @param amount The number of BPM to increase.
     */
    public void increaseBPM(int amount) {
        this.BPM += amount;
    }

    /**
     * Decreases the current BPM by a specified amount.
     * 
     * @param amount The number of BPM to decrease.
     */
    public void decreaseBPM(int amount) {
        this.BPM -= amount;
    }

    /**
     * Sets the BPM to 0, effectively stopping the tempo.
     */
    public void noBPM() {
        this.BPM = 0;
    }

    /**
     * Gets the current BPM (beats per minute) for this tempo.
     * 
     * @return The current BPM.
     */
    public int getBPM() {
        return BPM;
    }
}