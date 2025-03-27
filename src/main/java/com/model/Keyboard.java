package com.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Handles the virtual keyboard and triggers note playing based on key press.
 * 
 * @author Victoria
 */
public class Keyboard {

    // Mapping of keyboard keys to musical notes
    private static final Map<String, String> keyNoteMapping;

    static {
        keyNoteMapping = new HashMap<>();
        keyNoteMapping.put("A", "C4");
        keyNoteMapping.put("W", "C#4");
        keyNoteMapping.put("S", "D4");
        keyNoteMapping.put("E", "D#4");
        keyNoteMapping.put("D", "E4");
        keyNoteMapping.put("F", "F4");
        keyNoteMapping.put("T", "F#4");
        keyNoteMapping.put("G", "G4");
        keyNoteMapping.put("Y", "G#4");
        keyNoteMapping.put("H", "A4");
        keyNoteMapping.put("U", "A#4");
        keyNoteMapping.put("J", "B4");
        keyNoteMapping.put("K", "C5");
        keyNoteMapping.put("O", "C#5");
        keyNoteMapping.put("L", "D5");
        keyNoteMapping.put("P", "D#5");
    }

    /**
     * Simulates key press input and plays the corresponding note.
     * 
     * @param key The key pressed by the user.
     */
    public static void handleKeyPress(String key) {
        String note = keyNoteMapping.get(key.toUpperCase());
        if (note != null) {
            Music.playNote(note, 400); // Play the note with 400ms duration
        } else {
            System.out.println("Invalid key pressed. Please press a valid key.");
        }
    }
}