package com.lljvmusicapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a song with notes, tempo, genre, and other attributes.
 * Allows users to modify and play the song.
 * @author Victoria
 */
public class Song {
    private ArrayList<Note> notes;
    private Tempo tempo;
    private UUID id;
    private String genre;
    private String instrument;
    private String difficulty;
    private String title;
    private String publisher;
    private String lyrics;
    private Map<String, String> sheetMusic;
    private UUID uploaderId;
    private String filePath;
    private boolean isPrivate;
    private boolean isPlaying = false;
    private Metronome metronome;

    /**
     * Constructs a Song and initializes attributes.
     */
    public Song(UUID id, String title, int tempo, String publisher, String lyrics, String level, String genre) {
        this.id = UUID.randomUUID();
        this.notes = new ArrayList<>();
        this.sheetMusic = new HashMap<>();
        this.title = title;
        this.genre = genre;
        this.instrument = "";
        this.lyrics = lyrics;
        this.difficulty = level;
        this.publisher = publisher;
        this.filePath = filePath;
        this.tempo = new Tempo(tempo);
        this.metronome = new Metronome(tempo);
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
     * Jumps forward in the song by skipping 1 note (simulated).
     */
    public void jumpForward() {
        if (!notes.isEmpty()) {
            notes.remove(0);
            System.out.println("Jumped forward one note.");
        }
    }

    /**
     * Starts playing the song note-by-note.
     */
    public void startSong() {
        isPlaying = true;
        System.out.println("Starting song: " + title);
        for (Note note : notes) {
            if (!isPlaying) break;
            note.playNote();
            try {
                Thread.sleep(60000 / tempo.getBPM());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Song finished.");
    }

    /**
     * Pauses the song.
     */
    public void pauseSong() {
        isPlaying = false;
        System.out.println("Song paused.");
    }

    /**
     * Ends the song.
     */
    public void endSong() {
        isPlaying = false;
        System.out.println("Song ended.");
    }

    /**
     * Plays the metronome.
     */
    public void playMetronome() {
        if (metronome != null) {
            metronome.startMetronome();
        }
    }

    /**
     * Pauses the metronome.
     */
    public void pauseMetronome() {
        if (metronome != null) {
            metronome.stopMetronome();
        }
    }

    /**
     * Chooses a chord to play.
     * @param chord the chord to play
     */
    public void chooseChord(String chord) {
        System.out.println("Selected chord: " + chord);
    }

    public UUID getId() {
        return id;
    }

    /**
     * Adds a note to the song.
     * 
     * @param note the note to add
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void addSheetMusic(String part, String notation) {
        sheetMusic.put(part, notation); 
    }

    /**
     * Removes the last note from the song.
     */
    public void removeNote() {
        if (!notes.isEmpty()) {
            Note removedNote = notes.remove(notes.size() - 1);
            System.out.println("Removed note: " + removedNote);
        }
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

    /**
     * Gets the instrument used in the song.
     * @return the instrument
     */
    public String getInstrument() { 
        return instrument; 
    }

    /**
     * Returns the genre of the song.
     * 
     * @return a String representing the song's genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the publisher of the song.
     * @return the publisher
     */
    public String getPublisher() { 
        return publisher; 
    }

    /**
    * Gets the lyrics of the song.
    * 
    * @return The lyrics of the song.
    */
    public String getLyrics() {
        return lyrics;
    }

    /**
     * Gets the sheet music parts of the song.
     * 
     * @return A map of sheet music sections.
     */
    public Map<String, String> getSheetMusic() {
        return sheetMusic;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = new ArrayList<>(notes);
    }
}