package com.lljvmusicapp.model;

import java.util.List;

import org.jfugue.theory.Note;

/**
 * Represents a Piano that can play a sequence of notes.
 * 
 * @author Victoria
 */
public class Piano {
    
    /**
     * Plays the given list of notes.
     * 
     * @param notes List of notes to be played
     */
    public void playNotes(List<Note> notes) {
        System.out.println("Playing notes on the piano: " + notes);
    }
}