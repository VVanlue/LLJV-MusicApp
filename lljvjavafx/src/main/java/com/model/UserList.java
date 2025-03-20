package com.model;
import java.util.HashMap;

public class UserList {
    
    private HashMap<String, String> users;
    private static UserList instance;

    private UserList() {
        users = new HashMap<>();
    }

    // Ensure only one instance of UserList exists
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    // Adds a user with a username and password
    public void addUser(String username, String password) {
        users.put(username, password);
    }

    // Removes a user by username
    public boolean removeUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            return true;
        }
        return false;
    }

    // Finds if a user exists by username
    public boolean findUser(String username) {
        return users.containsKey(username);
    }

    public boolean validUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public void saveUsers() {
    }
}
