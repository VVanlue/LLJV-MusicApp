package com.model;

public class SongList {
    private ArrayList<Song> songs;
    private static SongList instance;

    private SongList() {
        System.out.println("");
    }

    public static SongList getInstance() {
        System.out.println("");
        return null;
    }

    public void addSong(Song song) {
        System.out.println("");
    }

    public void removeSong(Song song) {
        System.out.println();
    }

    public ArrayList<Song> getAllSongs() {
        System.out.println("");
        return null;
    }

    public ArrayList<Song> getSngsByKeyword(String word) {
        System.out.println("");
        return null;
    }

    public void viewSong(Song song) {
        System.out.println("");
    }

    public void sortByInstrument() {
        System.out.println("");
    }

    public void sortByLevels() {
        System.out.println("");
    }

}
