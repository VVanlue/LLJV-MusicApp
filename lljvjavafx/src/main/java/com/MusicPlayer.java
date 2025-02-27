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
}
