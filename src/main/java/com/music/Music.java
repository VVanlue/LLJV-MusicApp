package com.music;

import org.jfugue.player.Player; 

/**
 * Handles music functionalities such as playing a note using Jfugue.
 * 
 * @author Victoria
 */
public class Music {

    private static Player player = new Player();

    /**
     * Plays the provided note for the given duration.
     * 
     * @param note The musical note to be played (e.g., "C4", "D#5").
     * @param durationInMilliseconds The duration for which the note will be played.
     */
    public static void playNote(String note, int durationInMilliseconds) {
        player.play(note);
        try {
            Thread.sleep(durationInMilliseconds); // Sleep to hold the note for the specified duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
