package com.lljvmusicapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jfugue.theory.Note;

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
        this.lessonList = lessonList;
    }

    /**
     * Constructs a Facade instance with a new LessonList instance.
     */
    public Facade() {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessonList = LessonList.getInstance();
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
        boolean isValid = UserList.getInstance().validUser(username, password);
        if (isValid) {
            // Optionally store the matched user
            for (User u : UserList.getInstance().getAllUsers()) {
                if (u.getUsername().equals(username)) {
                    this.user = u;
                    break;
                }
            }
        }
        return isValid;
    }

    /**
     * Registers a new user and adds them to the user list.
     * 
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @return the newly created user
     */
    public User signUp(UUID id, String userName, String password, String firstName, String lastName, String email) {
        ArrayList<String> favSongs = new ArrayList<>();
        ArrayList<String> pubSongs = new ArrayList<>();
        
        User newUser = new User(id, userName, password, firstName, lastName, email, favSongs, pubSongs);
        UserList.getInstance().addUser(newUser);
        return newUser;
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
     * @param publisher the artist of the song
     * @param genre the genre of the song
     * @return the newly created song
     */
    public Song createSong(String title, String publisher, String genre) {
        UUID id = UUID.randomUUID();
    int tempo = 120; 
    String lyrics = ""; 
    String level = "Beginner";
    Song newSong = new Song(id, title, tempo, publisher, lyrics, level, genre);

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
            // Make sure your Song class has this method
            song.setPrivate(isPrivate); // TODO: Ensure this method exists in Song.java
            return true;
        }
        return false;
    }

    /**
     * Returns the currently logged-in user.
     *
     * @return the active User object, or null if not logged in
     */
    public User getCurrentUser() {
        return this.user;
    }

    /**
     * Creates sheet music for a given song.
     * 
     * @param song the song to create sheet music for
     * @return the created SheetMusic object, or null if the song is null
     */
    public SheetMusic createSheetMusic(Song song) {
        if (song != null) {
            UUID songId = song.getId();
            UUID userId = user != null ? user.getId() : UUID.randomUUID();
            int startTime = 0;
            int duration = 120;
            Piano piano = new Piano();
            List<Note> notes = new ArrayList<>();
            

            return new SheetMusic(songId, userId, startTime, duration, notes);
        }
        return null;
    }
}