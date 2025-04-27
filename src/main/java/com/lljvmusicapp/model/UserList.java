package com.lljvmusicapp.model;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Manages a list of users for the music app.
 * Implements singleton pattern to ensure only one instance exists.
 * Loads and saves user data from JSON.
 * 
 * @author Victoria
 */
public class UserList {
    private ArrayList<User> users;
    private static UserList instance;
    private static User currentUser;
    private static final String FILE_PATH = "users.json";

    /**
     * Private constructor to load users from JSON.
     */
    private UserList() {
        users = DataLoader.getUsers();
    }

    /**
     * Returns the singleton instance of UserList.
     * @return Singleton instance of UserList.
     */
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * Adds a new user to the list.
     * @param user The User object to add.
     */
    public void addUser(User user) {
        users.add(user);
        DataWriter.saveUsers();
    }

    /**
     * Removes a user by username.
     * @param username The username to remove.
     * @return true if the user was removed, false otherwise.
     */
    public boolean removeUser(String username) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username)) {
                iterator.remove();
                saveUsers();
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a user by username.
     * @param username The username to search for.
     * @return true if the user exists, false otherwise.
     */
    public boolean findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates a username and password.
     * @param username The username to check.
     * @param password The password to verify.
     * @return true if credentials match, false otherwise.
     */
    public boolean validUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loads user data from a JSON file.
     */
    private void loadUsers() {
        try (InputStream inputStream = new FileInputStream(FILE_PATH)) {
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONArray jsonArray = new JSONArray(tokener);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
    
                UUID id = UUID.fromString(obj.getString("id"));
                String userName = obj.getString("userName");
                String password = obj.getString("password");
                String firstName = obj.optString("firstName", ""); // fallback empty string
                String lastName = obj.optString("lastName", "");
                String email = obj.optString("email", "");
    
                // These might be stored as comma-separated strings
                ArrayList<String> favSongs = new ArrayList<>();
                ArrayList<String> pubSongs = new ArrayList<>();
                ArrayList<String> completedLessons = new ArrayList<>();
    
                String favSongStr = obj.optString("favoriteSongs", "");
                if (!favSongStr.isEmpty()) {
                    for (String song : favSongStr.split(",")) {
                        favSongs.add(song.trim());
                    }
                }
    
                String pubSongStr = obj.optString("publishedSongs", "");
                if (!pubSongStr.isEmpty()) {
                    for (String song : pubSongStr.split(",")) {
                        pubSongs.add(song.trim());
                    }
                }

                String lesnStr = obj.optString("completedLessons", "");
                if (!lesnStr.isEmpty()) {
                    for (String lesson : lesnStr.split(",")) {
                        completedLessons.add(lesson.trim());
                    }
                }
    
                User user = new User(id, userName, password, firstName, lastName, email, favSongs, pubSongs, completedLessons);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    /**
     * Saves users to the JSON file.
     */
    private void saveUsers() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JSONArray jsonArray = new JSONArray();

            for (User user : users) {
                JSONObject obj = new JSONObject();
                obj.put("firstName", user.getFirstName());
                obj.put("lastName", user.getLastName());
                obj.put("userName", user.getUsername());
                obj.put("password", user.getPassword());
                obj.put("email", user.getEmail());
                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(4));
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    /**
     * Returns the list of all registered users.
     * 
     * @return the list of users
     */
    public ArrayList<User> getAllUsers() {
        return users;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
}