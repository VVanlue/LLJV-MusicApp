package com.model;

/**
 * Class for playing audio
 */
public class AudioPlayer {
    private static AudioPlayer instance;
    
    private AudioPlayer() {
        // Initialize audio system
    }
    
    /**
     * @return The AudioPlayer instance
     */
    public static synchronized AudioPlayer getInstance() {
        if (instance == null) {
            instance = new AudioPlayer();
        }
        return instance;
    }
    
    /**
     * Plays a song with the specified tempo.
     * @param songName The name of the song to play
     * @param tempo The tempo in beats per minute
     */
    public void play(String songName, int tempo) {
        // Implementation for playing a song
        System.out.println("AudioPlayer: Playing " + songName + " at " + tempo + " BPM");
    }
    
    /**
     * Stops the current playback.
     */
    public void stop() {
        System.out.println("AudioPlayer: Playback stopped");
    }
    
    /**
     * Plays a single note.
     * @param note The note to play
     */
    public void playNote(String note) {
        System.out.println("AudioPlayer: Playing note " + note);
    }
}

