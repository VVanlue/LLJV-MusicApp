package com.lljvmusicapp.model;

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
        if (key == null || key.isEmpty()) {
            System.out.println("No key pressed.");
            return;
        }

        String note = keyNoteMapping.get(key.toUpperCase());
        if (note != null) {
            MusicPlaying.getInstance().playNote(note); // Play the note with 400ms duration
        } else {
            System.out.println("Invalid key pressed. Please press a valid key.");
        }
    }

    /**
     * Starts a simple interactive keyboard that listens for key presses.
     * Users can type letters and press Enter to play corresponding notes.
     */
    public static void startKeyboardListener() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Virtual Keyboard Started. Press keys to play notes (type 'exit' to quit).");

        while (true) {
            System.out.print("Press a key: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Virtual Keyboard.");
                break;
            }

            handleKeyPress(input);
        }

        scanner.close();
    }
}