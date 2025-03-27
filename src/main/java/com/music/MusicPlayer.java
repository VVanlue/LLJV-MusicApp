package com.program;

import com.music.*;
import java.lang.Thread;

/*
 * Tested, working music player with jfugue connection
 */
public class MusicPlayer {
    
    public void playSong() {
        try {
            playLine1();
            Thread.sleep(100);
            playLine2();
            Thread.sleep(100);
            playLine3();
            Thread.sleep(100);
            playLine4();
            Thread.sleep(100);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /*
     * Megolovania - Undertale - Toby Fox
     * @author Victoria
     */
    private void playLine1() {
        Music.playNote("D5i");
        Music.playNote("D5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine2() {
        Music.playNote("C5i");
        Music.playNote("C5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine3() {
        Music.playNote("B5i");
        Music.playNote("B5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine4() {
        Music.playNote("A#5i");
        Music.playNote("A#5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.playSong();
    }
}
