package com.model;

import java.util.*;

/**
 * Represents a song with title, artist, lyrics, musical notes, and sheet music.
 */
public class Song {
    private UUID id;
    private String title;
    private String artist;
    private String lyrics;
    private List<MusicalNote> notes;
    private Map<String, String> sheetMusic;

    /**
     * Creates a new Song with the specified title and artist.
     * 
     * @param title the song title
     * @param artist the song artist
     */
    public Song(String title, String artist) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.notes = new ArrayList<>();
        this.sheetMusic = new HashMap<>();
    }
    
    /**
     * Creates a new Song with the specified ID, title, and artist.
     * 
     * @param id the song's unique identifier
     * @param title the song title
     * @param artist the song artist
     */
    public Song(UUID id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.notes = new ArrayList<>();
        this.sheetMusic = new HashMap<>();
    }

    // Getters and setters
    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public List<MusicalNote> getNotes() { return notes; }
    public String getLyrics() { return lyrics; }
    public Map<String, String> getSheetMusic() { return sheetMusic; }

    public void setLyrics(String lyrics) { this.lyrics = lyrics; }
    
    /**
     * Adds a musical note to the song.
     * 
     * @param note the musical note to add
     */
    public void addNote(MusicalNote note) {
        notes.add(note);
    }
    
    /**
     * Adds sheet music for a specific part of the song.
     * 
     * @param part the part name (e.g., "verse1", "chorus")
     * @param notation the musical notation for this part
     */
    public void addSheetMusic(String part, String notation) {
        sheetMusic.put(part, notation);
    }
    
    @Override
    public String toString() {
        return title + " by " + artist;
    }
}
