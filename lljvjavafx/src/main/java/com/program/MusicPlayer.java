package com.program;

import com.music.*;
import java.lang.Thread;

public class MusicPlayer {
    
    public void playSong() {
        try {
            playLine1();
            Thread.sleep(300);
            playLine2();
            Thread.sleep(300);
            playLine3();
            Thread.sleep(300);
            playLine1();
            Thread.sleep(300);
            playLine2();
            Thread.sleep(300);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void playLine1() {
        Music.playNote("C");
        Music.playNote("D");
    }

    private void playLine2() {
        Music.playNote("C");
        Music.playNote("D");
    }

    private void playLine3() {
        Music.playNote("C");
        Music.playNote("D");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.playSong();
    }
}
