package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a song with notes, tempo, genre, and other attributes.
 * Allows users to modify and play the song.
 * 
 * @author Victoria
 */
public class Song {
    private ArrayList<Note> notes;
    private int tempo;
    private UUID id;
    private String genre;
    private String instrument;
    private String difficulty;
    private String title;
    private String publisher;
    private String artist;

    /**
     * Constructs a Song and initializes attributes.
     */
    public Song() {
        this.id = UUID.randomUUID();
        this.notes = new ArrayList<>();
    }

    /**
     * Constructs a Song with title, artist, and genre.
     *
     * @param title  the song title
     * @param artist the artist name
     * @param genre  the genre
     */
    public Song(String title, String artist, String genre) {
        this();
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Sets the tempo of the song.
     * 
     * @param speed the new tempo
     */
    public void setSpeed(int speed) {
    }

    /**
     * Jumps forward in the song.
     */
    public void jumpForward() {
    }

    /**
     * Starts playing the song.
     */
    public void startSong() {
    }

    /**
     * Pauses the song.
     */
    public void pauseSong() {
    }

    /**
     * Ends the song.
     */
    public void endSong() {
    }

    /**
     * Plays the metronome.
     */
    public void playMetronome() {
    }

    /**
     * Pauses the metronome.
     */
    public void pauseMetronome() {
    }

    /**
     * Chooses a chord to play.
     * 
     * @param chord the chord to play
     */
    public void chooseChord(Chord chord) {
    }

    /**
     * Plays a scale.
     * 
     * @param scale the scale to play
     */
    public void playScale(Scale scale) {
    }

    /**
     * Adds a note to the song.
     * 
     * @param note the note to add
     */
    public void addNote(Note note) {
    }

    /**
     * Removes the last note from the song.
     */
    public void removeNote() {
    }

    /**
     * Displays song details.
     */
    public void viewSong() {
    }

    /**
     * Gets the title of the song.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the instrument used in the song.
     * 
     * @return the instrument
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Gets the publisher of the song.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /** @return the artist */
    public String getArtist() {
        return artist;
    }

    /** @return the genre */
    public String getGenre() {
        return genre;
    }

}
