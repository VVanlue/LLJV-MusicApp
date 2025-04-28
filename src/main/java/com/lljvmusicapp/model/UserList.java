package com.lljvmusicapp.model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Manages a list of users for the music app.
 * Implements singleton pattern to ensure only one instance exists.
 * Loads and saves user data from JSON.
 * 
 * @author Victoria
 */
public class UserList {
    private static UserList instance;
    private ArrayList<User> users;
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

    public void reload() {
        users = DataLoader.getUsers();
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
                return true;
            }
        }
        return false;
    }

    private void saveUsers() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JSONArray jsonArray = new JSONArray();

            for (User user : users) {
                JSONObject obj = new JSONObject();
                obj.put("firstName", user.getFirstName());
                obj.put("lastName", user.getLastName());
                obj.put("username", user.getUsername());
                obj.put("password", user.getPassword());
                obj.put("email", user.getEmail());
                obj.put("uuid", user.getId().toString());

                obj.put("favSongs", new JSONArray(user.getFavSongs()));
                obj.put("publishedSongs", new JSONArray(user.getPubSongs()));
                obj.put("completedLessons", new JSONArray(user.getCompletedLessons()));

                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(4));
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
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
     * Returns the list of all registered users.
     * 
     * @return the list of users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets current user so that
     * dashboard can recognize who is on the app based
     * on the login
    */
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    
    /**
     * Gets current user
     * finds out who is the person currently using the app based on the login
     * @return
    */
    public static User getCurrentUser() {
        return currentUser;
    }
}