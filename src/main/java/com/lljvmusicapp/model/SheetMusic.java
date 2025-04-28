package com.lljvmusicapp.model;

import java.util.List;
import java.util.UUID;

import org.jfugue.theory.Note;

/**
 * Represents a sheet of music, which includes a set of notes, tempo, measures, and a piano.
 * Provides functionality for adding, removing, and playing notes on a piano.
 * 
 * Author: Victoria
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
     * @param songId Unique identifier for the associated song
     * @param measures Number of measures in the sheet
     * @param tempo Tempo (beats per minute)
     * @param notes List of notes in the sheet
     */
    public SheetMusic(UUID sheetId, UUID songId, int measures, int tempo, List<Note> notes) {
        this.sheetId = sheetId;
        this.songId = songId;
        this.measures = measures;
        this.tempo = tempo;
        this.notes = notes;
    }
    
    /**
     * Gets the sheet's unique identifier.
     * 
     * @return the sheetId
     */
    public UUID getSheetId() {
        return sheetId;
    }

    /**
     * Gets the song's unique identifier associated with this sheet.
     * 
     * @return the songId
     */
    public UUID getSongId() {
        return songId;
    }

    /**
     * Gets the number of measures in the sheet.
     * 
     * @return the number of measures
     */
    public int getMeasures() {
        return measures;
    }

    /**
     * Gets the tempo of the sheet.
     * 
     * @return the tempo in BPM
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Gets the piano assigned to play the sheet music.
     * 
     * @return the piano
     */
    public Piano getPiano() {
        return piano;
    }

    /**
     * Gets the list of notes in the sheet.
     * 
     * @return the list of notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * Sets the sheet's unique identifier.
     * 
     * @param sheetId the sheetId to set
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setSheetId(UUID sheetId) {
        this.sheetId = sheetId;
        return this;
    }

    /**
     * Sets the song's unique identifier associated with this sheet.
     * 
     * @param songId the songId to set
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setSongId(UUID songId) {
        this.songId = songId;
        return this;
    }

    /**
     * Sets the number of measures.
     * 
     * @param measures the measures to set
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setMeasures(int measures) {
        this.measures = measures;
        return this;
    }

    /**
     * Sets the tempo of the sheet music.
     * 
     * @param tempo the tempo to set
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setTempo(int tempo) {
        this.tempo = tempo;
        return this;
    }

    /**
     * Assigns a piano to the sheet music.
     * 
     * @param piano the piano to assign
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setPiano(Piano piano) {
        this.piano = piano;
        return this;
    }

    /**
     * Sets the list of notes.
     * 
     * @param notes the list of notes to set
     * @return the updated SheetMusic object (for chaining)
     */
    public SheetMusic setNotes(List<Note> notes) {
        this.notes = notes;
        return this;
    }

    /**
     * Adds a note to the sheet music.
     * 
     * @param note The note to add
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Removes a note from the sheet music.
     * 
     * @param note The note to remove
     */
    public void removeNote(Note note) {
        notes.remove(note);
    }

    /**
     * Plays the sheet music using the assigned piano.
     * If no piano is assigned, displays a warning message.
     */
    public void play() {
        System.out.println("Playing sheet music...");
        if (piano != null) {
            piano.playNotes(notes);
        } else {
            System.out.println("No piano assigned to play the notes.");
        }
    }
}