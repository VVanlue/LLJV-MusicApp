package com.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeyboardInput {
    private Map<Character, String> keyToNoteMap;
    private Scanner scanner;
    private Instrument activeInstrument;
    
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
    
    //Sets the instrument that will play notes when keys are pressed 
    public void setActiveInstrument(Instrument instrument) {
        this.activeInstrument = instrument;
    }
    
    //gets the note associated with a keyboard key
    public String getNoteForKey(char key) {
        return keyToNoteMap.getOrDefault(key, null);
    }
    
    //sets a custom key mapping for a note
    public void setKeyMapping(char key, String note) {
        keyToNoteMap.put(key, note);
    }
    
    //starts listening for keyboard input and plays notes
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


