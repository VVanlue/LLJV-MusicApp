package com.model;
import java.util.ArrayList;

/**
 * Represents a musical note with attributes such as length, name, and type.
 * Provides methods for playing, moving, and modifying the note.
 * 
 * @author Victoria
 */
public class Note {
    public int noteLength;
    public String noteName;
    public String noteType;

    public enum NoteType {
        SHARP, FLAT, NATURAL
    }

    public enum NoteName {
        A, B, C, D, E, F, G
    }

    /**
     * Constructs a Note with a given name, length, and type.
     * @param noteName The name of the note (e.g., A, B, C, etc.)
     * @param noteLength The length of the note (e.g., 4 for a quarter note)
     * @param noteType The type of the note (sharp, flat, or natural)
     */
    public Note(NoteName noteName, int noteLength, NoteType noteType) {
        this.noteName = noteName;
        this.noteLength = noteLength;
        this.noteType = noteType;
    }


    /**
     * Plays the note.
     */
    public void playNote() {
    }

    /**
     * Moves the note to a different position.
     */
    public void moveNote(NoteName newNoteName) {
        this.noteName = newNoteName;
    }

    /**
     * Sets the length of the note.
     */
    public void setNoteLength(int noteLength) {
        this.noteLength = noteLength;
    }

    /**
     * Sets the note to be quiet (muted).
     */
    public void setNoteQuiet() {
    }

    /**
     * Retrieves a list of chords that include this note.
     * 
     * @return An ArrayList of chord names.
     */
    public ArrayList<String> getChords() {
        ArrayList<String> chords = new ArrayList<>();
        if (noteName == NoteName.C) {
            chords.add("C Major");
            chords.add("C Minor");
        } else if (noteName == NoteName.G) {
            chords.add("G Major");
            chords.add("G Minor");
        }
        return chords;
    }

    /**
     * Retrieves a list of scales that include this note.
     * 
     * @return An ArrayList of scale names.
     */
    public ArrayList<String> getScales() {
        ArrayList<String> scales = new ArrayList<>();
        if (noteName == NoteName.C) {
            scales.add("C Major Scale");
            scales.add("C Minor Scale");
        } else if (noteName == NoteName.G) {
            scales.add("G Major Scale");
        }

        public void getNoteName() {
            return noteName;
        }
    
        public void setNoteName(NoteName noteName) {
            this.noteName = noteName;
        }
    
        public int getNoteLength() {
            return noteLength;
        }
    
        public void setNoteLength(int noteLength) {
            this.noteLength = noteLength;
        }
    
        public NoteType getNoteType() {
            return noteType;
        }
    
        public void setNoteType(NoteType noteType) {
            this.noteType = noteType;
        }
    
        @Override
        public String toString() {
            return "Note{" + "noteName=" + noteName + ", noteLength=" + noteLength + ", noteType=" + noteType + '}';
        }
    }
}