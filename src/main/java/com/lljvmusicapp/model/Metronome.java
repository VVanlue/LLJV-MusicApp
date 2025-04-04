package com.lljvmusicapp.model;
import java.util.ArrayList;

/**
 * Represents a metronome that maintains a specific tempo.
 * It extends the {@code Tempo} class and allows starting, stopping, and adjusting the beats per minute (BPM).
 * 
 */

public class Metronome extends Tempo {
    private int tempo;
    
    /** 
     * A list of {@code Tempo} objects, though its purpose is currently undefined.
     */
    private ArrayList<Tempo> Tempo;


    /**
     * Constructs a Metronome object with a specified tempo.
     * 
     * @param tempo The initial tempo in beats per minute (BPM)
     */
    public Metronome(int tempo) {
        super(tempo);
        this.tempo = tempo;
    }

    /**
     * Starts the metronome.
     * Functionality to be implemented.
     */
    public void startMetronome()
    {

    }
    /**
     * Stops the metronome.
     * Functionality to be implemented.
     */
    public void stopMetronome()
    {

    }

    /**
     * Sets the beats per minute (BPM) of the metronome.
     * 
     * @param BPM The new beats per minute value
     */
    public void setBPM (int BPM)
    {
        super.setBPM(BPM);
    }

}