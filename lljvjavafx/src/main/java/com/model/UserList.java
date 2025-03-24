package com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
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
    private static final String FILE_PATH = "users.json";

    /**
     * Private constructor to load users from JSON.
     */
    private UserList() {
        users = new ArrayList<>();
        loadUsers();
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
        saveUsers();
    }

    /**
     * Removes a user by username.
     * @param username The username to remove.
     * @return true if user was removed, false otherwise.
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
     * @return The found User object, or null if not found.
     */
    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
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
     * Loads user data from JSON file.
     */
    private void loadUsers() {
        try (InputStream inputStream = new FileInputStream(FILE_PATH)) {
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONArray jsonArray = new JSONArray(tokener);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                User user = new User(
                    obj.getString("firstName"),
                    obj.getString("lastName"),
                    obj.getString("username"),
                    obj.getString("email"),
                    "" // No password stored for now
                );
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
                obj.put("username", user.getUsername());
                obj.put("email", user.getEmail());
                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(4));
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}