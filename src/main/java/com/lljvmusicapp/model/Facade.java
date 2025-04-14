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
    private final LessonList lessonList;

    /**
     * Default constructor initializes lesson list.
     */
    public Facade() {
        this.lessonList = LessonList.getInstance();
    }

    /**
     * Returns the currently logged-in user.
     * 
     * @return the logged-in user, or null if not logged in
     */
    public User getCurrentUser() {
        return this.user;
    }

    /**
     * Retrieves all users.
     * 
     * @return a list of all registered users
     */
    public List<User> UserList() {
        return UserList.getInstance().getAllUsers(); // ✅ FIXED: use UserList singleton
    }

    /**
     * Retrieves all songs.
     * 
     * @return a list of all songs
     */
    public List<Song> SongList() {
        return SongList.getInstance().getSongs(); // ✅ FIXED: use SongList singleton
    }

    /**
     * Retrieves the lesson list.
     * 
     * @return the lesson list instance
     */
    public LessonList getLessonList() {
        return lessonList;
    }

    /**
     * Attempts to log in a user with the given username and password.
     * 
     * @param username the username
     * @param password the password
     * @return true if valid login, false otherwise
     */
    public boolean UserLogin(String username, String password) {
        boolean isValid = UserList.getInstance().validUser(username, password);
        if (isValid) {
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
     * Registers and returns a new user.
     * 
     * @param id UUID of the new user
     * @param username Username
     * @param password Password
     * @param firstName First name
     * @param lastName Last name
     * @param email Email address
     * @return the newly created User object
     */
    public User signUp(UUID id, String username, String password, String firstName, String lastName, String email) {
        User newUser = new User(id, username, password, firstName, lastName, email,
                                new ArrayList<>(), new ArrayList<>());
        UserList.getInstance().addUser(newUser);
        return newUser;
    }

    /**
     * Creates and adds a new song to the song list.
     * 
     * @param title Title of the song
     * @param publisher Artist or creator
     * @param genre Genre of the song
     * @return the new Song object
     */
    public Song createSong(String title, String publisher, String genre) {
        UUID id = UUID.randomUUID();
        int tempo = 120;
        String lyrics = "";
        String level = "Beginner";
        Song newSong = new Song(id, title, tempo, publisher, lyrics, level, genre);

        SongList.getInstance().addSong(newSong); // ✅ FIXED: delegate to SongList
        return newSong;
    }

    /**
     * Updates a song’s privacy status.
     * 
     * @param song the song to modify
     * @param isPrivate true if private, false if public
     * @return true if updated successfully
     */
    public boolean setSongPrivacy(Song song, boolean isPrivate) {
        if (SongList.getInstance().getSongs().contains(song)) {
            song.setPrivate(isPrivate); // Ensure this method exists in your Song class
            return true;
        }
        return false;
    }

    /**
     * Creates sheet music for the given song.
     * 
     * @param song the song to generate sheet music for
     * @return the SheetMusic object or null
     */
    public SheetMusic createSheetMusic(Song song) {
        if (song != null) {
            UUID songId = song.getId();
            UUID userId = (user != null) ? user.getId() : UUID.randomUUID();
            return new SheetMusic(songId, userId, 0, 120, new ArrayList<Note>());
        }
        return null;
    }

    // Stub methods for future development
    public boolean instrumentSelection() { return false; }
    public boolean lessonSelection() { return false; }
    public Song chooseSong() { return null; }
    public String chooseDifficulty() { return "Medium"; }
    public boolean postSong(Song song) { return song != null; }
}