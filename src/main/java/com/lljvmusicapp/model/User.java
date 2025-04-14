package com.lljvmusicapp.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a user in the system.
 * @author Victoria
 */

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private ArrayList<String> pubSongs;
    private ArrayList<String> favSongs;

    private static User instance;

    /**
     * Default constructor for User.
     */
    private User() {
        this.id = UUID.randomUUID();
        this.pubSongs = new ArrayList<>();
        this.favSongs = new ArrayList<>();
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    /**
     * Constructor to initialize user with details.
     * @param firstName User's first name
     * @param lastName User's last name
     * @param username User's chosen username
     * @param email User's email
     * @param password User's password
     * @param favSongs User's favorite songs
     * @param pubSongs User's published songs
     */
    public User(UUID id, String userName, String password, String firstName, String lastName, String email, ArrayList<String> favSongs, ArrayList<String> pubSongs)
    {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favSongs = favSongs != null ? favSongs : new ArrayList<>();
        this.pubSongs = pubSongs != null ? pubSongs : new ArrayList<>();
    }

    /**
     * Publishes a song to the user's list.
     * @param song The song to publish
     */
    public void publishSong(String song) {
        pubSongs.add(song);
    }

    /**
     * Tracks user progress (Stub function for expansion).
     */
    public void trackProgress() {
        System.out.println(userName + " is tracking progress.");
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(this); 
        return users;
    }

    /**
     * Starts a lesson.
     * @param lesson The MiniLesson object
     */
    public void startLesson(Lesson lesson) {
        System.out.println(userName + " started lesson: " + lesson.getTitle());
    }

    // Getters and Setters
    public String getUsername() { return userName; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public ArrayList<String> getFavSongs() { return favSongs; }
    public ArrayList<String> getPubSongs() { return pubSongs; }


}
