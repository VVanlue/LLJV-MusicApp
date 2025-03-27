package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        User users = User.getInstance();
<<<<<<< HEAD
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // creating all the json objects
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
=======
    ArrayList<User> userList = users.getUsers();
    JSONArray jsonUsers = new JSONArray();

    //creating all the json objects
    for(int i=0; i< userList.size(); i++) {
        jsonUsers.add(getUserJSON(userList.get(i)));
    }
    
    //Write JSON file
    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
        file.write(jsonUsers.toJSONString());
        file.flush();
    } catch (IOException e) {
        e.printStackTrace();
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
    }

    /**
     * Converts a User object into a JSONObject.
     * 
     * @param user The user to convert.
     * @return A JSONObject representing the user.
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_FAVORITE_SONGS, user.getFavSong());
        userDetails.put(USER_PUBLISHED_SONGS, user.getPubSong());
<<<<<<< HEAD

        return userDetails;
    }

=======
        
        return userDetails;
    }
    
    
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
}
