package com.model;

import java.util.ArrayList;

/**
 * Represents a student who can have a list of published and favorite songs.
 * Provides methods for starting a lesson, publishing songs, and tracking progress.
 * 
 * @author Victoria
 */
public class Student {
    private ArrayList<Song> publishedSongs;
    private ArrayList<Song> favSongs;
    private Lesson currentLesson;

    /**
     * Constructs a new Student with empty lists for published and favorite songs.
     */
    public Student() {
        this.publishedSongs = new ArrayList<>();
        this.favSongs = new ArrayList<>();
        this.currentLesson = null;
    }

    /**
     * Starts a lesson for the student. If a lesson is already in progress, it will be replaced.
     * 
     * @param lesson The Lesson to be started.
     */
    public void startLesson(Lesson lesson) {
        if (lesson == null) {
            System.out.println("Error: Cannot start a null lesson.");
            return;
        }
        this.currentLesson = lesson;
        System.out.println("Lesson started: " + lesson.getTitle());
    }

    /**
     * Publishes a song by the student. The song is added to the publishedSongs list.
     * 
     * @param song The Song to be published.
     */
    public void publishSong(Song song) {
        if (song == null) {
            System.out.println("Error: Cannot publish a null song.");
            return;
        }
        publishedSongs.add(song);
        System.out.println("Song published: " + song.getTitle());
    }

    /**
     * Tracks the progression of the student's learning by checking completed lessons.
     */
    public void trackProgression() {
        if (currentLesson == null) {
            System.out.println("No active lesson to track progression.");
        } else {
            System.out.println("Tracking progress in lesson: " + currentLesson.getTitle());
        }
    }

    /**
     * Adds a song to the student's favorite list.
     * 
     * @param song The Song to be added as a favorite.
     */
    public void addFavoriteSong(Song song) {
        if (song == null) {
            System.out.println("Error: Cannot add a null song to favorites.");
            return;
        }
        favSongs.add(song);
        System.out.println("Added to favorites: " + song.getTitle());
    }

    /**
     * Gets the list of published songs.
     * 
     * @return A list of published songs.
     */
    public ArrayList<Song> getPublishedSongs() {
        return new ArrayList<>(publishedSongs);
    }

    /**
     * Gets the list of favorite songs.
     * 
     * @return A list of favorite songs.
     */
    public ArrayList<Song> getFavoriteSongs() {
        return new ArrayList<>(favSongs);
    }

    /**
     * Gets the current lesson.
     * 
     * @return The active lesson, or null if no lesson is in progress.
     */
    public Lesson getCurrentLesson() {
        return currentLesson;
    }
}