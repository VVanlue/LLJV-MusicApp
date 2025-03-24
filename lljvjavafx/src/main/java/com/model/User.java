package com.model;


import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a user in the system.
 * @author Victoria
 */
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private ArrayList<Song> publishedSongs;
    private ArrayList<Song> favSongs;

    /**
     * Default constructor for User.
     */
    public User() {
        this.id = UUID.randomUUID().toString();
        this.publishedSongs = new ArrayList<>();
        this.favSongs = new ArrayList<>();
    }

    /**
     * Constructor to initialize user with details.
     * @param firstName User's first name
     * @param lastName User's last name
     * @param username User's chosen username
     * @param email User's email
     * @param password User's password
     */
    public User(String firstName, String lastName, String username, String email, String password) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Publishes a song to the user's list.
     * @param song The song to publish
     */
    public void publishSong(Song song) {
        publishedSongs.add(song);
    }

    /**
     * Tracks user progress (Stub function for expansion).
     */
    public void trackProgress() {
        System.out.println(username + " is tracking progress.");
    }

    /**
     * Starts a lesson.
     * @param lesson The MiniLesson object
     */
    public void startLesson(MiniLesson lesson) {
        System.out.println(username + " started lesson: " + lesson.getTitle());
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public ArrayList<Song> getFavSongs() { return favSongs; }
    public ArrayList<Song> getPublishedSongs() { return publishedSongs; }
}
