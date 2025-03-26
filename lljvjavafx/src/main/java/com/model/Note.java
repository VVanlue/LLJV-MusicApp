package com.model;
import java.util.ArrayList;

/**
 * Represents a musical note with attributes such as length, name, and type.
 * Provides methods for playing, moving, and modifying the note.
 * 
 * @author Victoria
 */
public class Note {
    public int NoteLength;
    public String NoteName;
    public String NoteType;

    public enum NoteType {
        SHARP, FLAT, NATURAL
    }

    public enum NoteName {
        A, B, C, D, E, F, G
    }

    /**
     * Plays the note.
     */
    public void playNote() {
        // Method stub
    }

    /**
     * Moves the note to a different position.
     */
    public void moveNote() {
        // Method stub
    }

    /**
     * Sets the length of the note.
     */
    public void setNoteLength() {
        // Method stub
    }

    /**
     * Sets the note to be quiet (muted).
     */
    public void setNoteQuiet() {
        // Method stub
    }

    /**
     * Retrieves a list of chords that include this note.
     * 
     * @return An ArrayList of chord names.
     */
    public ArrayList<String> getChords() {
        return new ArrayList<>(); // Method stub
    }

    /**
     * Retrieves a list of scales that include this note.
     * 
     * @return An ArrayList of scale names.
     */
    public ArrayList<String> getScales() {
        return new ArrayList<>(); // Method stub
    }
}