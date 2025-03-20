/**
 * Represents a musical instrument used for playing songs.
 */
package com.model;
import java.util.Scanner;

public class Instruments{

//attributes 
private String name;
private String stringName;
private String keyName;
private boolean isPlaying;

    /**
     * Constructs an Instrument with the specified details.
     */
    public Instruments(String name, String type) {
        this.name = name;
        this.type = type;
        this.isPlaying = false;
    }

    /**
     * Gets the instrument's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the instrument's name.
     * @return true if successful, false if the name is null
     */
    public boolean setName(String name) {
        if (name == null) return false;
        this.name = name;
        return true;
    }

    /**
     * Gets the instrument's type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the instrument's type.
     * @return true if successful, false if the type is null
     */
    public boolean setType(String type) {
        if (type == null) return false;
        this.type = type;
        return true;
    }

    /**
     * Checks if the instrument is currently playing.
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Sets the playing state of the instrument.
     */
    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    /**
     * Simulates playing the instrument with a specific song and tempo.
     */
    public String play(String songName, int tempo) {
        isPlaying = true;
        return name + " is playing " + songName + " at " + tempo + " BPM.";
    }

    /**
     * Stops playing the instrument.
     */
    public String stop() {
        isPlaying = false;
        return name + " has stopped playing.";
    }

    /**
     * Plays a specific note on the instrument.
     */
    public String playNote(String note) {
        return name + " is playing note: " + note;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
