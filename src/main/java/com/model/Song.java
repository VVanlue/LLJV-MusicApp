package com.model;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a song with notes, tempo, genre, and other attributes.
 * Allows users to modify and play the song.
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

    /**
     * Constructs a Song and initializes attributes.
     */
    public Song(String title, String genre, String instrument, String difficulty, String publisher) {
        this.id = UUID.randomUUID();
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
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

<<<<<<< HEAD
    public void setLyrics(String lyrics) { this.lyrics = lyrics; }
    
    /**
     * Adds a musical note to the song.
     * 
     * @param note the musical note to add
=======
    /**
     * Gets the instrument used in the song.
     * @return the instrument
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
     */
    public String getInstrument() { 
        return instrument; 
    }

    /**
<<<<<<< HEAD
     * Adds sheet music for a specific part of the song.
     * 
     * @param part the part name (e.g., "verse1", "chorus")
     * @param notation the musical notation for this part
=======
     * Gets the publisher of the song.
     * @return the publisher
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
     */
    public String getPublisher() { 
        return publisher; 
    }
}
