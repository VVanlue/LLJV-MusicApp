package com.lljvmusicapp.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Handles writing user data to a JSON file.
 * Extends {@link DataConstants} for constant values used in JSON storage.
 * 
 * @author Victoria
 */
public class DataWriter extends DataConstants {
    
    /**
     * Saves all users to a JSON file.
     * Converts the list of users into a JSON array and writes it to the file.
     */
    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        JSONArray jsonUsers = new JSONArray();
    
        for (User user : userList.getUsers()) {
            jsonUsers.put(getUserJSON(user));
        }
    
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSongs() {
        // Assuming you have a SongList class that manages all the songs
        ArrayList<Song> songs = SongList.getInstance().getSongs();

        JSONArray jsonSongs = new JSONArray();
        for (Song song : songs) {
            jsonSongs.put(getSongJSON(song));
        }

        try (FileWriter file = new FileWriter(SONG_FILE_NAME)) {
            file.write(jsonSongs.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a User object into a JSONObject.
     * 
     * @param user The user to convert.
     * @return A JSONObject representing the user.
     */
    public static JSONObject getUserJSON(User user) {
        Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("uuid", user.getId().toString());
        userMap.put("username", user.getUsername());
        userMap.put("password", user.getPassword());
        userMap.put("firstName", user.getFirstName());
        userMap.put("lastName", user.getLastName());
        userMap.put("email", user.getEmail());

        userMap.put("favSongs", user.getFavSongs());
        userMap.put("publishedSongs", user.getPubSongs());
        userMap.put("completedLessons", user.getCompletedLessons());

        return new JSONObject(userMap);
    }

    private static JSONObject getSongJSON(Song song) {
        JSONObject songDetails = new JSONObject();
        songDetails.put("uuid", song.getId().toString());
        songDetails.put("title", song.getTitle());
        songDetails.put("tempo", song.getTempo());
        songDetails.put("genre", song.getGenre());
        songDetails.put("instrument", song.getInstrument());
        songDetails.put("difficulty", song.getDifficulty());
        return songDetails;
    }

}
