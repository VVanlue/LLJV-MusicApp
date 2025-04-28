package com.lljvmusicapp.model;

import java.util.HashSet;
import java.util.Set;

import com.lljvmusicapp.music.Music;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Singleton class that plays music using JFugue.
 * Handles note playback and placeholders for additional musical features.
 * Also handles user keyboard input for real-time note playing.
 * 
 * @author Victoria
 */
public class MusicPlaying {

    private static MusicPlaying instance;
    private Metronome metronome;
    private Instrument currentInstrument;
    private Set<String> pressedNotes = new HashSet<>();

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
     * Plays a note string directly.
     * 
     * @param note The note to be played.
     */
    public void playNote(String note) {
        Music.playNote(note, 400); // Play note with fixed duration
    }

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
     * Handles user keyboard input and plays the corresponding note.
     * Supports basic A-G keys.
     * 
     * @param keyCode The KeyCode from a KeyEvent
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
            note = "B"; // No B# normally
        } else if (code == KeyCode.C) {
            note = shiftDown ? "C#" : "C";
        } else if (code == KeyCode.D) {
            note = shiftDown ? "D#" : "D";
        } else if (code == KeyCode.E) {
            note = "E"; // No E# normally
        } else if (code == KeyCode.F) {
            note = shiftDown ? "F#" : "F";
        } else if (code == KeyCode.G) {
            note = shiftDown ? "G#" : "G";
        }

        if (note != null) {
            if (keyPressed) {
                pressedNotes.add(note);
    
                if (pressedNotes.size() > 1) {
                    // Play as chord
                    playChord();
                } else {
                    // Play single note
                    playNote(note);
                }
            } else if (keyReleased) {
                pressedNotes.remove(note);
            }
        }
    }

    // Existing Metronome and Music Management methods

    public void playMetronome() {
        if (metronome != null) {
            metronome.startMetronome();
        }
    }

    public void exportSheet() {
        System.out.println("Sheet music exported as PDF (placeholder).");
    }

    public void trackProgress() {
        System.out.println("Tracking progress... (placeholder)");
    }

    public void saveProgress() {
        System.out.println("Progress saved. (placeholder)");
    }

    public void createSheetMusic() {
        System.out.println("Sheet music created. (placeholder)");
    }

    public void editSheetMusic() {
        System.out.println("Editing sheet music. (placeholder)");
    }

    public void playBackMusic() {
        System.out.println("Playing back recorded music. (placeholder)");
    }

    public void chooseInstrument(Instrument instrument) {
        this.currentInstrument = instrument;
        System.out.println("Instrument set to: " + instrument.getName());
    }

    public void stop() {
        if (metronome != null) {
            metronome.stopMetronome();
        }
        System.out.println("Music stopped.");
    }
}