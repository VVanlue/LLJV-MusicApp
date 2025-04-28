package com.lljvmusicapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jfugue.theory.Note;

/**
 * Represents a song with notes, tempo, genre, and other attributes.
 * Allows users to modify, play, and view the song details.
 * 
 * Author: Victoria
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
    private String songFileName;

    /**
     * Constructs a Song and initializes attributes.
     * 
     * @param id the unique identifier for the song
     * @param title the title of the song
     * @param tempo the tempo in beats per minute
     * @param publisher the publisher of the song
     * @param lyrics the lyrics of the song
     * @param level the difficulty level
     * @param genre the genre of the song
     * @param songFileName the filename of the song file
     */
    public Song(UUID id, String title, int tempo, String publisher, String lyrics, String level, String genre, String songFileName) {
        this.id = UUID.randomUUID();
        this.notes = new ArrayList<>();
        this.sheetMusic = new HashMap<>();
        this.title = title;
        this.genre = genre;
        this.instrument = "";
        this.lyrics = lyrics;
        this.difficulty = level;
        this.publisher = publisher;
        this.tempo = new Tempo(tempo);
        this.metronome = new Metronome(tempo);
        this.songFileName = songFileName;
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
     * Gets the filename associated with the song.
     * 
     * @return the song file name
     */
    public String getSongFileName() {
        return songFileName;
    }

    /**
     * Jumps forward in the song by removing the first note.
     */
    public void jumpForward() {
        if (!notes.isEmpty()) {
            notes.remove(0);
            System.out.println("Jumped forward one note.");
        }
    }

    /**
     * Starts playing the song by iterating through notes.
     */
    public void startSong() {
        isPlaying = true;
        System.out.println("Starting song: " + title);

        for (Note note : notes) {
            if (!isPlaying) break;

            System.out.println("Playing note: " + note.getToneString());

            try {
                Thread.sleep(60000 / tempo.getBPM());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Song finished.");
    }

    /**
     * Pauses the currently playing song.
     */
    public void pauseSong() {
        isPlaying = false;
        System.out.println("Song paused.");
    }

    /**
     * Ends the song playback.
     */
    public void endSong() {
        isPlaying = false;
        System.out.println("Song ended.");
    }

    /**
     * Starts playing the metronome.
     */
    public void playMetronome() {
        if (metronome != null) {
            metronome.startMetronome();
        }
    }

    /**
     * Stops the metronome.
     */
    public void pauseMetronome() {
        if (metronome != null) {
            metronome.stopMetronome();
        }
    }

    /**
     * Chooses a chord to play (for future features).
     * 
     * @param chord the name of the chord to select
     */
    public void chooseChord(String chord) {
        System.out.println("Selected chord: " + chord);
    }

    /**
     * Gets the song's unique identifier.
     * 
     * @return the UUID of the song
     */
    public UUID getId() {
        return id;
    }

    /**
     * Adds a note to the song's list of notes.
     * 
     * @param note the Note object to add
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * Adds a sheet music part with its corresponding notation.
     * 
     * @param part the part name (e.g., "Chorus", "Verse")
     * @param notation the musical notation
     */
    public void addSheetMusic(String part, String notation) {
        sheetMusic.put(part, notation);
    }

    /**
     * Removes the last note from the song's note list.
     */
    public void removeNote() {
        if (!notes.isEmpty()) {
            Note removedNote = notes.remove(notes.size() - 1);
            System.out.println("Removed note: " + removedNote);
        }
    }

    /**
     * Displays the song's basic details in the console.
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
     * 
     * @return the song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the instrument assigned to the song.
     * 
     * @return the instrument
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Gets the genre of the song.
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the publisher of the song.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Gets the difficulty level of the song.
     * 
     * @return the difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the lyrics of the song.
     * 
     * @return the lyrics
     */
    public String getLyrics() {
        return lyrics;
    }

    /**
     * Gets the sheet music associated with the song.
     * 
     * @return a map of sheet music parts and their notations
     */
    public Map<String, String> getSheetMusic() {
        return sheetMusic;
    }

    /**
     * Sets the song's privacy status.
     * 
     * @param isPrivate true if the song should be private
     */
    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    /**
     * Gets the list of notes in the song.
     * 
     * @return a list of notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * Sets the song's list of notes.
     * 
     * @param notes the new list of notes
     */
    public void setNotes(List<Note> notes) {
        this.notes = new ArrayList<>(notes);
    }
}