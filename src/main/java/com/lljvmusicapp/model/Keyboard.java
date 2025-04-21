package com.lljvmusicapp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles the virtual keyboard and triggers note playing based on key press with support
 * for sharps (Shift) and flats (Space).
 * 
 * @author Victoria
 */
public class Keyboard {

    private static final Map<String, String> baseNotes;

    static {
        baseNotes = new HashMap<>();
        baseNotes.put("A", "A");
        baseNotes.put("B", "B");
        baseNotes.put("C", "C");
        baseNotes.put("D", "D");
        baseNotes.put("E", "E");
        baseNotes.put("F", "F");
        baseNotes.put("G", "G");
    }

    /**
     * Handles a key press with modifiers to determine the correct note.
     * 
     * @param key The character key pressed (A–G).
     * @param isShiftDown Whether Shift was held (sharp).
     * @param isSpaceDown Whether Space was held (flat).
     */
    public static void handleKeyPress(String key, boolean isShiftDown, boolean isSpaceDown) {
        if (key == null || key.isEmpty()) {
            System.out.println("No key pressed.");
            return;
        }

        String noteLetter = baseNotes.get(key.toUpperCase());
        if (noteLetter != null) {
            String modifier = isShiftDown ? "#" : isSpaceDown ? "b" : "";
            String finalNote = noteLetter + modifier + "4"; // Using octave 4 for simplicity
            MusicPlaying.getInstance().playNote(finalNote);
        } else {
            System.out.println("Invalid key pressed.");
        }
    }
}