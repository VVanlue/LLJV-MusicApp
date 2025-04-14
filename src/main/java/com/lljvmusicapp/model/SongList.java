package com.lljvmusicapp.model;

import java.util.ArrayList;

/**
 * The SongList class manages a collection of songs and provides various methods
 * for adding, removing, retrieving, and sorting songs.
 */
public class SongList {
    private static SongList instance;
    private ArrayList<Song> songs;

    /**
     * Enum representing different difficulty levels for songs.
     */
    public enum Difficulties {
        EASY, MEDIUM, HARD
    }
    /**
     * Private constructor to enforce singleton pattern.
     */
    private SongList() {
        songs = DataLoader.getSongs();
    }

    /**
     * Retrieves the singleton instance of SongList.
     * 
     * @return The singleton instance of SongList.
     */
    public static SongList getInstance() {
        if (instance == null) {
            instance = new SongList();
        }
        return instance;
    }

    /**
     * Adds a song to the song list.
     * 
     * @param song The song to add.
     */
    public void addSong(Song song) {
        System.out.println("");
    }

    /**
     * Removes a song from the song list.
     * 
     * @param song The song to remove.
     */
    public void removeSong(Song song) {
        System.out.println();
    }

    /**
     * Retrieves all songs in the song list.
     * 
     * @return An ArrayList containing all songs.
     */
    public ArrayList<Song> getAllSongs() {
        System.out.println("");
        return null;
    }

    /**
     * Retrieves songs that contain a specific keyword in their title or artist name.
     * 
     * @param word The keyword to search for.
     * @return An ArrayList of songs matching the keyword.
     */
    public ArrayList<Song> getSongsByKeyword(String word) {
        System.out.println("");
        return null;
    }

    /**
     * Displays details of a specific song.
     * 
     * @param song The song to view.
     */
    public void viewSong(Song song) {
        System.out.println("");
    }

    /**
     * Sorts the songs by instrument.
     */
    public void sortByInstrument() {
        System.out.println("");
    }

    /**
     * Sorts the songs by difficulty levels.
     */
    public void sortByLevels() {
        System.out.println("");
    }

    /**
     * Returns the list of all songs.
     * 
     * @return an ArrayList of Song objects
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

}
