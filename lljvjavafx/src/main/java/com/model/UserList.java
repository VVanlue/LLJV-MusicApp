package com.model;
import java.util.ArrayList;

public class UserList {
    
    private ArrayList<String, String> user;
    private static SongList instance;

    private UserList(){
        System.out.println("");
    }

    public static SongList getInstance() {
        System.out.println("");
        return null;
    }

    public void addUser(userLogin user) {
        System.out.println("");
    }

    public boolean removeUser(String username) {
        System.out.println("");
        return false;
    }

    public UserLogin findUser(String username) {
        System.out.println("");
        return null;
    }

    public boolean validUser(String username, String password) {
        System.out.println("");
        return false;
    }

    public void saveUser() {
        System.out.println("");
    }
}
