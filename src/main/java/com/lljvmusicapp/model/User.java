package com.lljvmusicapp.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a user in the system with personal details, favorite songs,
 * published songs, and completed lessons.
 * Provides methods for managing user activities.
 * 
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
    private ArrayList<String> completedLessons;

    private static User instance;

    /**
     * Default constructor for User.
     * Initializes ID and empty lists for published and favorite songs.
     */
    private User() {
        this.id = UUID.randomUUID();
        this.pubSongs = new ArrayList<>();
        this.favSongs = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of User.
     * 
     * @return the singleton User instance
     */
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    /**
     * Constructor to initialize a user with full details.
     * 
     * @param id User's unique identifier
     * @param userName User's chosen username
     * @param password User's password
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email User's email address
     * @param favSongs List of user's favorite songs
     * @param pubSongs List of user's published songs
     * @param completedLessons List of completed lesson IDs
     */
    public User(UUID id, String userName, String password, String firstName, String lastName, String email,
                ArrayList<String> favSongs, ArrayList<String> pubSongs, ArrayList<String> completedLessons) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favSongs = favSongs != null ? favSongs : new ArrayList<>();
        this.pubSongs = pubSongs != null ? pubSongs : new ArrayList<>();
        this.completedLessons = completedLessons != null ? completedLessons : new ArrayList<>();
    }

    /**
     * Publishes a song by adding it to the user's list of published songs.
     * 
     * @param song The ID of the song to publish
     */
    public void publishSong(String song) {
        pubSongs.add(song);
    }

    /**
     * Placeholder for tracking user progress.
     * Currently outputs a message to the console.
     */
    public void trackProgress() {
        System.out.println(userName + " is tracking progress.");
    }

    /**
     * Gets the user's unique identifier.
     * 
     * @return the user's UUID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Returns a list containing only this user.
     * 
     * @return a list of users with only this user included
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(this); 
        return users;
    }

    /**
     * Adds a song to the user's list of published songs.
     * 
     * @param songId the ID of the song to add
     */
    public void addPublishedSong(String songId) {
        if (this.pubSongs == null) {
            this.pubSongs = new ArrayList<>();
        }
        this.pubSongs.add(songId);
    }

    /**
     * Simulates starting a lesson by printing a message.
     * 
     * @param lesson The lesson being started
     */
    public void startLesson(Lesson lesson) {
        System.out.println(userName + " started lesson: " + lesson.getTitle());
    }

    /**
     * Adds a completed lesson ID to the user's list of completed lessons.
     * 
     * @param lessonId the ID of the completed lesson
     */
    public void addCompletedLesson(String lessonId) {
        if (completedLessons == null) {
            completedLessons = new ArrayList<>();
        }
        completedLessons.add(lessonId);
    }

    /**
     * Gets the user's username.
     * 
     * @return the username
     */
    public String getUsername() { 
        return userName; 
    }

    /**
     * Gets the user's password.
     * 
     * @return the password
     */
    public String getPassword() { 
        return password; 
    }

    /**
     * Gets the user's first name.
     * 
     * @return the first name
     */
    public String getFirstName() { 
        return firstName; 
    }

    /**
     * Gets the user's last name.
     * 
     * @return the last name
     */
    public String getLastName() { 
        return lastName; 
    }

    /**
     * Gets the user's email address.
     * 
     * @return the email
     */
    public String getEmail() { 
        return email; 
    }

    /**
     * Gets the list of the user's favorite song IDs.
     * 
     * @return the list of favorite songs
     */
    public ArrayList<String> getFavSongs() { 
        return favSongs; 
    }

    /**
     * Gets the list of the user's published song IDs.
     * 
     * @return the list of published songs
     */
    public ArrayList<String> getPubSongs() { 
        return pubSongs; 
    }

    /**
     * Gets the list of completed lesson IDs.
     * 
     * @return the list of completed lessons
     */
    public ArrayList<String> getCompletedLessons() {
        return completedLessons;
    }
}