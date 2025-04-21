package com.lljvmusicapp.model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a metronome that maintains a specific tempo.
 * It extends the {@code Tempo} class and allows starting, stopping, and adjusting the beats per minute (BPM).
 * 
 * @author Victoria
 */
public class Metronome extends Tempo {
    private int tempo;
    private Timer timer;
    private boolean isRunning;

    /** 
     * A list of {@code Tempo} objects, though its purpose is currently undefined.
     */
    private ArrayList<Tempo> tempos = new ArrayList<>();

    /**
     * Constructs a Metronome object with a specified tempo.
     * 
     * @param tempo The initial tempo in beats per minute (BPM)
     */
    public Metronome(int tempo) {
        super(tempo);
        this.tempo = tempo;
        this.isRunning = false;
    }

    /**
     * Starts the metronome.
     * It uses a Timer to print ticks at intervals based on the BPM.
     */
    public void startMetronome() {
        if (isRunning) return;

        timer = new Timer();
        long delay = 0;
        long period = 60000 / tempo; // milliseconds per beat

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tick");
            }
        }, delay, period);

        isRunning = true;
    }

    /**
     * Stops the metronome.
     * Cancels the internal timer.
     */
    public void stopMetronome() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            isRunning = false;
        }
    }

    /**
     * Sets the beats per minute (BPM) of the metronome.
     * If the metronome is running, it will restart with the new tempo.
     * 
     * @param BPM The new beats per minute value
     */
    public void setBPM(int BPM) {
        super.setBPM(BPM);
        this.tempo = BPM;

        if (isRunning) {
            stopMetronome();
            startMetronome();
        }
    }
}
