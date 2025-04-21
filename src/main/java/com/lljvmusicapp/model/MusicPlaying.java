package com.lljvmusicapp.model;

import com.lljvmusicapp.music.Music;

/**
 * Singleton class that plays music using JFugue.
 * Handles note playback and placeholders for additional musical features.
 * 
 * @author Victoria
 */
public class MusicPlaying {

    private static MusicPlaying instance;
    private Metronome metronome;
    private Instrument currentInstrument;

    public static MusicPlaying getInstance() {
        if (instance == null) {
            instance = new MusicPlaying();
        }
        return instance;
    }

    public MusicPlaying() {
        this.metronome = new Metronome(120); // Default tempo
    }

    /**
     * Plays a note based on user input from the keyboard.
     * 
     * @param note The note to be played.
     */
    public void playNote(String note) {
        Music.playNote(note, 400); // Play note with fixed duration
    }

    /**
     * Starts the metronome.
     */
    public void playMetronome() {
        if (metronome != null) {
            metronome.startMetronome();
        }
    }

    /**
     * Stops and simulates exporting sheet music.
     */
    public void exportSheet() {
        System.out.println("Sheet music exported as PDF (placeholder).");
    }

    /**
     * Placeholder method for tracking user's music performance progress.
     */
    public void trackProgress() {
        System.out.println("Tracking progress... (placeholder)");
    }

    /**
     * Placeholder method for saving progress.
     */
    public void saveProgress() {
        System.out.println("Progress saved. (placeholder)");
    }

    /**
     * Placeholder method for creating sheet music.
     */
    public void createSheetMusic() {
        System.out.println("Sheet music created. (placeholder)");
    }

    /**
     * Placeholder method for editing sheet music.
     */
    public void editSheetMusic() {
        System.out.println("Editing sheet music. (placeholder)");
    }

    /**
     * Placeholder method for playing back music.
     */
    public void playBackMusic() {
        System.out.println("Playing back recorded music. (placeholder)");
    }

    /**
     * Sets the current instrument (placeholder).
     * 
     * @param instrument The instrument to be used.
     */
    public void chooseInstrument(Instrument instrument) {
        this.currentInstrument = instrument;
        System.out.println("Instrument set to: " + instrument.getName());
    }

    /**
     * Stops all playback.
     */
    public void stop() {
        if (metronome != null) {
            metronome.stopMetronome();
        }
        System.out.println("Music stopped.");
    }
}