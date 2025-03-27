package com.model;

/**
 * Represents a musical note with pitch, duration, and timing information.
 */
public class MusicalNote {
    private String pitch; // e.g., "C4", "D#3"
    private int duration; // in milliseconds
    private int startTime; // relative to song start, in milliseconds
    
    /**
     * Creates a new musical note.
     * 
     * @param pitch the pitch of the note (e.g., "C4", "D#3")
     * @param duration the duration in milliseconds
     * @param startTime the start time relative to song start in milliseconds
     */
    public MusicalNote(String pitch, int duration, int startTime) {
        this.pitch = pitch;
        this.duration = duration;
        this.startTime = startTime;
    }
    
    // Getters
    public String getPitch() { return pitch; }
    public int getDuration() { return duration; }
    public int getStartTime() { return startTime; }
}
