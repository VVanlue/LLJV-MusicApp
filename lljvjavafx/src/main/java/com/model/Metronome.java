package com.model;
import java.util.Scanner;

public class Metronome extends Tempo {

    //variables
    private ArrayList<Tempos> Tempo;


    //methods
    public void startMetronome()
    {

    }

    public void stopMetronome()
    {

    }

    @Override
    public void setBPM (int BPM)
    {
        this.BPM = BPM;
    }

    public ArrayList<Tempos> getTempo() {
        return Tempo;
    }

    public void setTempo(ArrayList<Tempos> tempo) {
        Tempo = tempo;
    }
}
}