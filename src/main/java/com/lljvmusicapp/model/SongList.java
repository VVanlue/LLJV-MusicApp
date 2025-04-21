package com.lljvmusicapp.model;

import java.util.ArrayList;
import java.util.Comparator;

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
        songs.add(song);
        System.out.println("Song added: " + song.getTitle());
    }

    /**
     * Removes a song from the song list.
     * 
     * @param song The song to remove.
     */
    public void removeSong(Song song) {
        if (songs.remove(song)) {
            System.out.println("Song removed: " + song.getTitle());
        } else {
            System.out.println("Song not found.");
        }
    }

    /**
     * Retrieves all songs in the song list.
     * 
     * @return An ArrayList containing all songs.
     */
    public ArrayList<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }

    /**
     * Retrieves songs that contain a specific keyword in their title or artist name.
     * 
     * @param word The keyword to search for.
     * @return An ArrayList of songs matching the keyword.
     */
    public ArrayList<Song> getSongsByKeyword(String word) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(word.toLowerCase()) ||
                song.getPublisher().toLowerCase().contains(word.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }

    /**
     * Displays details of a specific song.
     * 
     * @param song The song to view.
     */
    public void viewSong(Song song) {
        if (songs.contains(song)) {
            song.viewSong();
        } else {
            System.out.println("Song not found in the list.");
        }
    }

    /**
     * Sorts the songs by instrument.
     */
    public void sortByInstrument() {
        songs.sort(Comparator.comparing(Song::getInstrument));
        System.out.println("Songs sorted by instrument.");
    }

    /**
     * Sorts the songs by difficulty levels.
     */
    public void sortByLevels() {
        songs.sort(Comparator.comparing(Song::getTempo, Comparator.comparingInt(Tempo::getBPM)));
        System.out.println("Songs sorted by difficulty (using tempo as proxy).");
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
