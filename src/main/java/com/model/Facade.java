package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Facade class provides a simplified interface for managing users, songs, and lessons.
 * It acts as a central point of interaction for various operations related to the application.
 * 
 * @author Victoria
 */
public class Facade {
    private User user;
    private List<User> users;
    private List<Song> songs;
    private LessonList lessonList; // Store the lesson list

    /**
     * Constructs a Facade instance with a given LessonList.
     * 
     * @param lessonList the lesson list to use
     */
    public Facade(LessonList lessonList) {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessonList = lessonList; // Assign the passed LessonList
    }

    /**
     * Constructs a Facade instance with a new LessonList instance.
     */
    public Facade() {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessonList = LessonList.getInstance(); // Use singleton instance of LessonList
    }
    /**
     * Retrieves the list of users.
     * 
     * @return a list of users
     */
    public List<User> UserList() {
        return users;
    }
    /**
     * Retrieves the list of songs.
     * 
     * @return a list of songs
     */
    public List<Song> SongList() {
        return songs;
    }
    /**
     * Retrieves the lesson list.
     * 
     * @return the lesson list
     */
    public LessonList getLessonList() {
        return lessonList;
    }
    /**
     * Attempts to log in a user with the provided username and password.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return true if login is successful, false otherwise
     */
    public boolean UserLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                this.user = u;
                return true; // Successful login
            }
        }
        return false; // Login failed
    }
    /**
     * Registers a new user and adds them to the user list.
     * 
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @return the newly created user
     */
    public User signUp(String firstName, String lastName, String username, String email, String password) {
        User newUser = new User(firstName, lastName, username, email, password);
        users.add(newUser);
        return newUser; // Return the newly created User
    }
    /**
     * Handles instrument selection (not yet implemented).
     * 
     * @return false (default implementation)
     */
    public boolean instrumentSelection() {
        return false;
    }
    /**
     * Handles lesson selection (not yet implemented).
     * 
     * @return false (default implementation)
     */
    public boolean lessonSelection() {
        return false;
    }
    /**
     * Allows a user to choose a song (not yet implemented).
     * 
     * @return null (default implementation)
     */
    public Song chooseSong() {
        return null;
    }
    /**
     * Allows a user to choose a difficulty level.
     * 
     * @return "Medium" as the default difficulty level
     */
    public String chooseDifficulty() {
        return "Medium";
    }
    /**
     * Creates a new song and adds it to the song list.
     * 
     * @param title the title of the song
     * @param artist the artist of the song
     * @param genre the genre of the song
     * @return the newly created song
     */
    public Song createSong(String title, String artist, String genre) {
        Song newSong = new Song(title, artist, genre);
        songs.add(newSong);
        return newSong;
    }
    /**
     * Posts a song.
     * 
     * @param song the song to post
     * @return true if the song is not null, false otherwise
     */
    public boolean postSong(Song song) {
        return song != null;
    }
    /**
     * Deletes a song from the song list.
     * 
     * @param song the song to delete
     * @return true if the song was removed, false otherwise
     */
    public boolean deleteSong(Song song) {
        return songs.remove(song);
    }
    /**
     * Sets the privacy status of a song.
     * 
     * @param song the song to update
     * @param isPrivate true to make the song private, false to make it public
     * @return true if the song is found and updated, false otherwise
     */
    public boolean setSongPrivacy(Song song, boolean isPrivate) {
        if (songs.contains(song)) {
            song.setPrivate(isPrivate);
            return true;
        }
        return false;
    }
    /**
     * Creates sheet music for a given song.
     * 
     * @param song the song to create sheet music for
     * @return the created SheetMusic object, or null if the song is null
     */
    public SheetMusic createSheetMusic(Song song) {
        if (song != null) {
            return new SheetMusic(song);
        }
        return null;
    }
}
