package com.model;
import java.util.Scanner;

public class Tempo {

    //attributes
    private int BPM;

    //constants
    public Tempo (int BPM)
    {
        this.BPM = BPM;
    }

    //methods
    public void setBPM(int BPM)
    {
        this.BPM = BPM
    }

    public void increaseBPM (int amount)
    {
        this.BPM = BPM + amount;
    }

    public void decreaseBPM (int amount)
    {
        this.BPM = BPM - amount;
    }

    public void noBPM ()
    {
        this.BPM = 0;
    }

    



}