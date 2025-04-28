package com.lljvmusicapp.music;

import org.jfugue.player.Player;

/**
 * Utility class for playing music using JFugue.
 */
public class Music {
    private static final Player player = new Player();

    /**
     * plays a note using JFugue's logic
     * note is determined by letter
     * @param note
     * @param durationMs
    */
    public static void playNote(String note, int durationMs) {
        new Thread(() -> {
            try {
                // JFugue doesn't use milliseconds, so use duration in beats
                // e.g., 0.25 = sixteenth, 0.5 = eighth, 1 = quarter, etc.
                String jfugueNote = note + "q"; // quarter note
                player.play(jfugueNote);
                Thread.sleep(durationMs); // delay between notes if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}