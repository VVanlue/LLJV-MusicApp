package com.model;

import java.util.UUID;

/**
 * Represents a music lesson with details such as song, difficulty, title, genre, and instrument.
 * Provides methods to learn notes, timing, scales, and chords.
 * 
 * @author Victoria
 */
public class Lesson {
    private String song;
    private String difficulty;
    private final UUID id;
    private String title;
    private String genre;
    private String instrument;

    /**
     * Constructs a Lesson object with a unique ID.
     */
    public Lesson() {
        this.id = UUID.randomUUID();
    }

    /**
     * Starts learning musical notes.
     */
    public void learnNotes() {
        // Method stub
    }

    /**
     * Starts learning musical timing.
     */
    public void learnTiming() {
        // Method stub
    }

    /**
     * Starts learning musical scales.
     */
    public void learnScales() {
        // Method stub
    }

    /**
     * Starts learning musical chords.
     */
    public void learnChords() {
        // Method stub
    }

    /**
     * Saves the lesson progress.
     */
    public void save() {
        // Method stub
    }

    /**
    * Retrieves the title of the lesson.
    * 
    * @return The title of the lesson as a String.
    */
    public String getTitle() {
    // TODO: Implement method to return the title of the lesson
    return title;  // Replace 'title' with the actual field that holds the title value
    }
}