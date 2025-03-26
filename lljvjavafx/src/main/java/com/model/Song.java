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
    public Song(String title, String genre, String instrument, String difficulty, String publisher) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.notes = new ArrayList<>();
        this.title = title;
        this.genre = genre;
        this.instrument = instrument;
        this.difficulty = difficulty;
        this.publisher = publisher;
        this.tempo = new Tempo(120); // Default tempo to 120 BPM
    }

    /**
     * Sets the tempo of the song.
     * 
     * @param tempo the new Tempo object to set
     */
    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    /**
     * Gets the current tempo of the song.
     * 
     * @return the Tempo object of the song
     */
    public Tempo getTempo() {
        return tempo;
    }

    /**
     * Jumps forward in the song.
     */
    public void jumpForward() {}

    /**
     * Starts playing the song.
     */
    public void startSong() {}

    /**
     * Pauses the song.
     */
    public void pauseSong() {}

    /**
     * Ends the song.
     */
    public void endSong() {}

    /**
     * Plays the metronome.
     */
    public void playMetronome() {}

    /**
     * Pauses the metronome.
     */
    public void pauseMetronome() {}

    /**
     * Chooses a chord to play.
     * @param chord the chord to play
     */
    public void chooseChord(Chord chord) {}

    /**
     * Plays a scale.
     * @param scale the scale to play
     */
    public void playScale(Scale scale) {}

    /**
     * Adds a note to the song.
     * 
     * @param note the note to add
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * Removes the last note from the song.
     */
    public void removeNote() {
        Note removedNote = notes.remove(notes.size() - 1);
    }

    /**
     * Displays song details.
     */
    public void viewSong() {
        System.out.println("Song Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Instrument: " + instrument);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Publisher: " + publisher);
        System.out.println("Tempo: " + tempo.getBPM() + " BPM");
        System.out.println("Number of notes: " + notes.size());
    }

    /**
     * Gets the title of the song.
     * @return the title
     */
    public String getTitle() { 
        return title; 
    }

    public void setLyrics(String lyrics) { this.lyrics = lyrics; }
    
    /**
     * Adds a musical note to the song.
     * 
     * @param note the musical note to add
     */
    public String getInstrument() { 
        return instrument; 
    }

    /**
     * Adds sheet music for a specific part of the song.
     * 
     * @param part the part name (e.g., "verse1", "chorus")
     * @param notation the musical notation for this part
     */
    public String getPublisher() { 
        return publisher; 
    }
}
