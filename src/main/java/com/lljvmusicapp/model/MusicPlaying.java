package com.lljvmusicapp.model;

import java.util.HashSet;
import java.util.Set;

import com.lljvmusicapp.music.Music;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Singleton class that plays music using JFugue.
 * Handles note playback, chord playback, metronome control, and 
 * basic sheet music features. Also handles real-time keyboard input for live note playing.
 * 
 * Author: Victoria
 */
public class MusicPlaying {

    private static MusicPlaying instance;
    private Metronome metronome;
    private Instrument currentInstrument;
    private Set<String> pressedNotes = new HashSet<>();

    /**
     * Returns the singleton instance of MusicPlaying.
     * 
     * @return the MusicPlaying instance
     */
    public static MusicPlaying getInstance() {
        if (instance == null) {
            instance = new MusicPlaying();
        }
        return instance;
    }

    /**
     * Constructs a new MusicPlaying object with default tempo.
     */
    public MusicPlaying() {
        this.metronome = new Metronome(120); // Default tempo
    }

    /**
     * Plays a single musical note.
     * 
     * @param note The note to be played
     */
    public void playNote(String note) {
        Music.playNote(note, 400); // Play note with fixed duration
    }

    /**
     * Plays all currently pressed notes together as a chord.
     */
    private void playChord() {
        StringBuilder chord = new StringBuilder();
        for (String note : pressedNotes) {
            chord.append(note).append(" ");
        }
    
        String chordString = chord.toString().trim();
        System.out.println("Playing chord: " + chordString);
    
        new Thread(() -> {
            Music.playNote(chordString, 400); // Play chord for fixed time
        }).start();
    }

    /**
     * Handles keyboard input events and plays corresponding notes.
     * Supports A-G key mapping, with Shift for sharps.
     * 
     * @param event The KeyEvent from user input
     */
    public void handleKeyInput(KeyEvent event) {
        KeyCode code = event.getCode();
        boolean shiftDown = event.isShiftDown();
        boolean keyPressed = event.getEventType() == KeyEvent.KEY_PRESSED;
        boolean keyReleased = event.getEventType() == KeyEvent.KEY_RELEASED;

        String note = null;

        // Map basic keys to notes
        if (code == KeyCode.A) {
            note = shiftDown ? "A#" : "A";
        } else if (code == KeyCode.B) {
            note = "B";
        } else if (code == KeyCode.C) {
            note = shiftDown ? "C#" : "C";
        } else if (code == KeyCode.D) {
            note = shiftDown ? "D#" : "D";
        } else if (code == KeyCode.E) {
            note = "E";
        } else if (code == KeyCode.F) {
            note = shiftDown ? "F#" : "F";
        } else if (code == KeyCode.G) {
            note = shiftDown ? "G#" : "G";
        }

        if (note != null) {
            if (keyPressed) {
                pressedNotes.add(note);

                if (pressedNotes.size() > 1) {
                    playChord();
                } else {
                    playNote(note);
                }
            } else if (keyReleased) {
                pressedNotes.remove(note);
            }
        }
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
     * Placeholder method for exporting sheet music.
     */
    public void exportSheet() {
        System.out.println("Sheet music exported as PDF (placeholder).");
    }

    /**
     * Placeholder method for tracking music practice progress.
     */
    public void trackProgress() {
        System.out.println("Tracking progress... (placeholder)");
    }

    /**
     * Placeholder method for saving music progress.
     */
    public void saveProgress() {
        System.out.println("Progress saved. (placeholder)");
    }

    /**
     * Placeholder method for creating new sheet music.
     */
    public void createSheetMusic() {
        System.out.println("Sheet music created. (placeholder)");
    }

    /**
     * Placeholder method for editing existing sheet music.
     */
    public void editSheetMusic() {
        System.out.println("Editing sheet music. (placeholder)");
    }

    /**
     * Placeholder method for playing back recorded music.
     */
    public void playBackMusic() {
        System.out.println("Playing back recorded music. (placeholder)");
    }

    /**
     * Chooses an instrument to use for playing notes.
     * 
     * @param instrument The Instrument object to select
     */
    public void chooseInstrument(Instrument instrument) {
        this.currentInstrument = instrument;
        System.out.println("Instrument set to: " + instrument.getName());
    }

    /**
     * Stops music playback and stops the metronome.
     */
    public void stop() {
        if (metronome != null) {
            metronome.stopMetronome();
        }
        System.out.println("Music stopped.");
    }
}