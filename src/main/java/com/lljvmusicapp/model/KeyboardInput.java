package com.lljvmusicapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Handles keyboard input for playing musical notes.
 * Maps specific keys to musical notes and allows an instrument to play them.
 * 
 */
public class KeyboardInput {
    private Map<Character, String> keyToNoteMap;
    private Scanner scanner;
    private Instrument activeInstrument;
    
    /**
     * Constructs a KeyboardInput object with predefined key-to-note mappings.
     */
    public KeyboardInput() {
        keyToNoteMap = new HashMap<>();
        keyToNoteMap.put('a', "C");
        keyToNoteMap.put('s', "D");
        keyToNoteMap.put('d', "E");
        keyToNoteMap.put('f', "F");
        keyToNoteMap.put('g', "G");
        keyToNoteMap.put('h', "A");
        keyToNoteMap.put('j', "B");
        // Add more mappings as needed just like the above ones. ex. keyToNoteMap.put('w', "C#")
        
        scanner = new Scanner(System.in);
    }
    
    /**
     * Sets the instrument that will play notes when keys are pressed.
     * 
     * @param instrument The instrument to be set as active
     */ 
    public void setActiveInstrument(Instrument instrument) {
        this.activeInstrument = instrument;
    }
    
    /**
     * Gets the note associated with a specific keyboard key.
     * 
     * @param key The keyboard key pressed
     * @return The corresponding musical note, or null if no mapping exists
     */
    public String getNoteForKey(char key) {
        return keyToNoteMap.getOrDefault(key, null);
    }
    
    /**
     * Sets a custom mapping of a key to a musical note.
     * 
     * @param key The keyboard key to map
     * @param note The musical note assigned to the key
     */
    public void setKeyMapping(char key, String note) {
        keyToNoteMap.put(key, note);
    }
    
    /**
     * Starts listening for keyboard input and plays notes based on key mappings.
     * Press 'q' to stop listening.
     */
    public void startListening() {
        System.out.println("Keyboard input active. Press keys to play notes (q to quit):");
        
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("q")) {
                break;
            }
            
            if (!input.isEmpty()) {
                char key = input.charAt(0);
                String note = getNoteForKey(key);
                
                if (note != null && activeInstrument != null) {
                    System.out.println(activeInstrument.playNote(note));
                } else if (note != null) {
                    System.out.println("Note " + note + " would play, but no instrument is active");
                } else {
                    System.out.println("No note mapped to key: " + key);
                }
            }
        }
        
        System.out.println("Keyboard input stopped");
    }
}


