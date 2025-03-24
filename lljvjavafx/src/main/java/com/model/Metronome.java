package com.model;
import java.util.Scanner;
import java.util.ArrayList;

public class Metronome extends Tempo {
    private int tempo;

    public Metronome(int tempo) {
        super(tempo);
        this.tempo = tempo;
    }
    
    //variables
    private ArrayList<Tempo> Tempo;


    //methods
    public void startMetronome()
    {

    }

    public void stopMetronome()
    {

    }

    public void setBPM (int BPM)
    {
        this.BPM = BPM;
    }

}