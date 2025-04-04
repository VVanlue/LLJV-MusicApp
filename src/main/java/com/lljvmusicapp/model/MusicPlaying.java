package com.lljvmusicapp.model;

import java.util.Scanner;

import com.lljvmusicapp.music.Music;

/**
 * Handles music playing functionalities, including metronome, sheet music, instrument selection,
 * and now allows the user to play notes with a keyboard.
 * 
 * @author Victoria
 */
public class MusicPlaying extends Keyboard {

    private static MusicPlaying instance;

    public static MusicPlaying getInstance() {
        if (instance == null) {
            instance = new MusicPlaying();
        }
        return instance;
    }

    /**
     * Starts the interactive process where the user can play notes using the keyboard.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the virtual keyboard! Press keys to play notes.");
        System.out.println("Valid keys: A, W, S, E, D, F, T, G, Y, H, U, J, K, O, L, P");
        System.out.println("Type 'exit' to stop playing.");
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                handleKeyPress(input); // Map key press to musical note
            }
        }
        
        scanner.close();
    }

    /**
     * Plays a note based on user input from the keyboard.
     * 
     * @param note The note to be played.
     */
    public void playNote(String note) {
        Music.playNote(note, 400); // Play the note using Jfugue with 400ms duration
    }

    /**
     * Plays the metronome.
     */
    public void playMetronome() {
        // Method stub
    }

    /**
     * Exports the sheet music.
     */
    public void exportSheet() {
        // Method stub
    }

    /**
     * Tracks the user's progress in playing music.
     */
    public void trackProgress() {
        // Method stub
    }

    /**
     * Saves the user's progress.
     */
    public void saveProgress() {
        // Method stub
    }

    /**
     * Creates sheet music.
     */
    public void createSheetMusic() {
        // Method stub
    }

    /**
     * Edits existing sheet music.
     */
    public void editSheetMusic() {
        // Method stub
    }

    /**
     * Plays back the recorded music.
     */
    public void playBackMusic() {
        // Method stub
    }

    /**
     * Chooses an instrument for playing music.
     * 
     * @param instrument The instrument to be selected.
     */
    public void chooseInstrument(Instrument instrument) {
        // Method stub
    }

    /**
    * Stops playing music.
    */
    public void stop() {
        System.out.println("Music stopped.");
    }

    public static void main(String[] args) {
        MusicPlaying musicPlaying = new MusicPlaying();
        musicPlaying.play(); // Start the music-playing interaction
    }
}