package com.model;

public class Difficulty {

    private String level;
    private int complexScore;

    public static final String EASY = new Difficulties ("Easy", 1);
    public static final String MEDIUM = new Difficulties ("Medium", 2);
    public static final String HARD = new Difficulties("Hard", 3);

    public Difficulty (String level, int complexScore)
    {
        this.level = level;
        this.complexScore = complexScore;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public void setcomplexScore(int complexScore)
    {
        this.complexScore = complexScore;
    }

    //public void getLevel() 
   // {

   // }

   /// public void getComplexLevel()
   // {

    //}

    
}