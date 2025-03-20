package com.model;

public class Instrument {
    // Attributes 
    private String name;
    private String type;
    private boolean isPlaying;
    private AudioPlayer audioPlayer;

    /**
     * Constructs an Instrument with the specified details.
     * @param name The name of the instrument
     * @param type The type of the instrument
     */
    public Instrument(String name, String type) {
        this.name = name;
        this.type = type;
        this.isPlaying = false;
        try {
            this.audioPlayer = AudioPlayer.getInstance();
        } catch (Exception e) {
            System.err.println("Warning: AudioPlayer could not be initialized: " + e.getMessage());
            // null if needed
        }
    }

    /**
     * Gets the name of the instrument.
     * @return The instrument name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the instrument.
     * @param name The new instrument name
     * @return true if successful, false if the name was null
     */
    public boolean setName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        this.name = name;
        return true;
    }

    /**
     * Gets the type of the instrument.
     * @return The instrument type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the instrument.
     * @param type The new instrument type
     * @return true if successful, false if the type was null
     */
    public boolean setType(String type) {
        if (type == null || type.trim().isEmpty()) return false;
        this.type = type;
        return true;
    }

    /**
     * Checks if the instrument is currently playing.
     * @return true if playing, false otherwise
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Sets the playing state of the instrument.
     * @param playing The new playing state
     */
    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    /**
     * Plays a song with the specified tempo.
     * @param songName The name of the song to play
     * @param tempo The tempo in beats per minute
     * @return A string describing what's being played
     */
    public String play(String songName, int tempo) {
        isPlaying = true;
        if (audioPlayer != null) {
            try {
                audioPlayer.play(songName, tempo);
            } catch (Exception e) {
                System.err.println("Error playing song: " + e.getMessage());
            }
        }
        return name + " is playing " + songName + " at " + tempo + " BPM.";
    }

    /**
     * Stops the instrument from playing.
     * @return A string indicating the instrument has stopped
     */
    public String stop() {
        isPlaying = false;
        if (audioPlayer != null) {
            try {
                audioPlayer.stop();
            } catch (Exception e) {
                System.err.println("Error stopping playback: " + e.getMessage());
            }
        }
        return name + " has stopped playing.";
    }

    /**
     * Plays a single note.
     * @param note The note to play
     * @return A string describing the note being played
     */
    public String playNote(String note) {
        if (audioPlayer != null) {
            try {
                audioPlayer.playNote(note);
            } catch (Exception e) {
                System.err.println("Error playing note: " + e.getMessage());
            }
        }
        return name + " is playing note: " + note;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
