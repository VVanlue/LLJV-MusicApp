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

    public static MusicPlaying getInstance() {
        if (instance == null) {
            instance = new MusicPlaying();
        }
        return instance;
    }

    /**
     * Plays a note based on user input from the keyboard.
     * 
     * @param note The note to be played.
     */
    public void playNote(String note) {
        Music.playNote(note, 400); // Play note with fixed duration
    }

    public void playMetronome() {
        // Method stub
    }

    public void exportSheet() {
        // Method stub
    }

    public void trackProgress() {
        // Method stub
    }

    public void saveProgress() {
        // Method stub
    }

    public void createSheetMusic() {
        // Method stub
    }

    public void editSheetMusic() {
        // Method stub
    }

    public void playBackMusic() {
        // Method stub
    }

    public void chooseInstrument(Instrument instrument) {
        // Method stub
    }

    public void stop() {
        System.out.println("Music stopped.");
    }
}