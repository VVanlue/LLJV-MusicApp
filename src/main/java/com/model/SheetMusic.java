package com.model;
import java.util.List;
import java.util.UUID;

import org.jfugue.theory.Note;

/**
 * Represents a sheet of music, which includes a set of notes, tempo, measures, and a piano.
 * 
 * @author Victoria
 */
public class SheetMusic {
    private UUID sheetId;
    private UUID songId;
    private int measures;
    private int tempo;
    private Piano piano; 
    private List<Note> notes;

    /**
     * Constructs a new SheetMusic object.
     * 
     * @param sheetId Unique identifier for the sheet
     * @param songId Unique identifier for the song
     * @param measures The number of measures in the sheet
     * @param tempo The tempo (beats per minute)
     * @param piano The piano object that plays the sheet
     * @param notes The list of notes in the sheet
     */
    public SheetMusic(UUID sheetId, UUID songId, int measures, int tempo, Piano piano, List<Note> notes) {
        this.sheetId = sheetId;
        this.songId = songId;
        this.measures = measures;
        this.tempo = tempo;
        this.piano = piano;
        this.notes = notes;
    }
    
    // Get Methods
    public UUID getSheetId() {
        return sheetId;
    }

    public UUID getSongId() {
        return songId;
    }

    public int getMeasures() {
        return measures;
    }

    public int getTempo() {
        return tempo;
    }

    public Piano getPiano() {
        return piano;
    }

    public List<Note> getNotes() {
        return notes;
    }

    // Set Methods - Either use void or return this, not both
    // Option 1: Return this for method chaining
    public SheetMusic setSheetId(UUID sheetId) {
        this.sheetId = sheetId;
        return this;
    }

    public SheetMusic setSongId(UUID songId) {
        this.songId = songId;
        return this;
    }

    public SheetMusic setMeasures(int measures) {
        this.measures = measures;
        return this;
    }

    public SheetMusic setTempo(int tempo) {
        this.tempo = tempo;
        return this;
    }

    public SheetMusic setPiano(Piano piano) {
        this.piano = piano;
        return this;
    }

    public SheetMusic setNotes(List<Note> notes) {
        this.notes = notes;
        return this;
    }
    /**
     * Adds a note to the sheet music.
     * 
     * @param note The note to be added.
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Removes a note from the sheet music.
     * 
     * @param note The note to be removed.
     */
    public void removeNote(Note note) {
        notes.remove(note);
    }

    /**
     * Plays the sheet music
     */
    public void play() {
        System.out.println("Playing sheet music...");
        piano.playNotes(notes);
    }
}

