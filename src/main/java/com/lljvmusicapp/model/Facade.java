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
    private static User user;
    private static final LessonList lessonList = LessonList.getInstance();
    private static Facade instance = null;

    /**
     * gets the singleton instance of Facade, should be a singleton to avoid object creation errors
     * @return singleton instance of Facade
     */
    public static Facade getInstance()
    {
        if (instance == null)
        {
            instance = new Facade();
        }
        
        return instance;
    }

    /**
     * Returns the currently logged-in user.
     * 
     * @return the logged-in user, or null if not logged in
     */
    public static User getCurrentUser() {
        return user;
    }

    /**
     * Retrieves all users.
     * 
     * @return a list of all registered users
     */
    public List<User> UserList() {
        return UserList.getInstance().getUsers(); // ✅ FIXED: use UserList singleton
    }

    /**
     * Retrieves all songs.
     * 
     * @return a list of all songs
     */
    public static List<Song> SongList() {
        return SongList.getInstance().getSongs(); // ✅ FIXED: use SongList singleton
    }

    /**
     * Retrieves the lesson list.
     * 
     * @return the lesson list instance
     */
    public static LessonList getLessonList() {
        return lessonList;
    }

    /**
     * Attempts to log in a user with the given username and password.
     * 
     * @param username the username
     * @param password the password
     * @return true if valid login, false otherwise
     */
    public static boolean UserLogin(String username, String password) {
        boolean isValid = UserList.getInstance().validUser(username, password);
        if (isValid) {
            for (User u : UserList.getInstance().getUsers()) {
                if (u.getUsername().equals(username)) {
                    user = u;
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
    public static User signUp(UUID id, String username, String password, String firstName, String lastName, String email) {
        User newUser = new User(id, username, password, firstName, lastName, email,
                                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
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
    public static Song createSong(String title, String publisher, String genre, String songFileName) {
        UUID id = UUID.randomUUID();
        int tempo = 120;
        String lyrics = "";
        String level = "Beginner";
        Song newSong = new Song(id, title, tempo, publisher, lyrics, level, genre, songFileName);

        SongList.getInstance().addSong(newSong); 
        return newSong;
    }

    /**
     * Updates a song’s privacy status.
     * 
     * @param song the song to modify
     * @param isPrivate true if private, false if public
     * @return true if updated successfully
     */
    public static boolean setSongPrivacy(Song song, boolean isPrivate) {
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
    public static SheetMusic createSheetMusic(Song song) {
        if (song != null) {
            UUID songId = song.getId();
            UUID userId = (user != null) ? user.getId() : UUID.randomUUID();
            return new SheetMusic(songId, userId, 0, 120, new ArrayList<Note>());
        }
        return null;
    }

    // Stub methods for future development
    public static boolean instrumentSelection() { 
        return false; 
    }
    public static boolean lessonSelection() { 
        return false; 
    }
    public static Song chooseSong() { 
        return null; 
    }
    public static String chooseDifficulty() { 
        return "Medium"; 
    }
    public static boolean postSong(Song song) { 
        return song != null; 
    }
}