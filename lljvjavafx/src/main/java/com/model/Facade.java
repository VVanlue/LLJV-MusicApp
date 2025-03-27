package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade {
    private User user;
    private List<User> users;
    private List<Song> songs;
    private LessonList lessonList; // Store the lesson list

    // Constructor to initialize Facade with a new or existing LessonList
    public Facade(LessonList lessonList) {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessonList = lessonList; // Assign the passed LessonList
    }

    // Default constructor, creates a new LessonList instance
    public Facade() {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessonList = LessonList.getInstance(); // Use singleton instance of LessonList
    }

    public List<User> UserList() {
        return users;
    }

    public List<Song> SongList() {
        return songs;
    }

    public LessonList getLessonList() {
        return lessonList;
    }

    public boolean UserLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                this.user = u;
                return true; // Successful login
            }
        }
        return false; // Login failed
    }

    public User signUp(String firstName, String lastName, String username, String email, String password) {
        User newUser = new User(firstName, lastName, username, email, password);
        users.add(newUser);
        return newUser; // Return the newly created User
    }

    public boolean instrumentSelection() {
        return false;
    }

    public boolean lessonSelection() {
        return false;
    }

    public Song chooseSong() {
        return null;
    }

    public String chooseDifficulty() {
        return "Medium";
    }

    public Song createSong(String title, String artist, String genre) {
        Song newSong = new Song(title, artist, genre);
        songs.add(newSong);
        return newSong;
    }

    public boolean postSong(Song song) {
        return song != null;
    }

    public boolean deleteSong(Song song) {
        return songs.remove(song);
    }

    public boolean setSongPrivacy(Song song, boolean isPrivate) {
        if (songs.contains(song)) {
            song.setPrivate(isPrivate);
            return true;
        }
        return false;
    }

    public SheetMusic createSheetMusic(Song song) {
        if (song != null) {
            return new SheetMusic(song);
        }
        return null;
    }
}
