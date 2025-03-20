package com.model;
import java.util.Scanner;

public class Instruments{
    //Attributes 
private String name;
private String type;
private boolean isPlaying;
private AudioPlayer audioPlayer;

    //Constructs an Instrument with the specified details.
    public Instruments(String name, String type) {
        this.name = name;
        this.type = type;
        this.isPlaying = false;
        this.audioPlayer = AudioPlayer.getInstance();
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name == null) return false;
        this.name = name;
        return true;
    }

    public String getType() {
        return type;
    }

    public boolean setType(String type) {
        if (type == null) return false;
        this.type = type;
        return true;
    }

    public boolean isPlaying() {
        return isPlaying;
    }


    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }


    public String play(String songName, int tempo) {
        isPlaying = true;
        return name + " is playing " + songName + " at " + tempo + " BPM.";
    }

    public String stop() {
        isPlaying = false;
        audioPlayer.stop();
        return name + " has stopped playing.";
    }

    public String playNote(String note)  {
        audioPlayer.playNote(note);
        return name + " is playing note: " + note;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
