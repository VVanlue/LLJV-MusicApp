package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        User users = User.getInstance();
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
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_FAVORITE_SONGS, user.getFavSong());
        userDetails.put(USER_PUBLISHED_SONGS, user.getPubSong());
        
        return userDetails;
    }
    
    
}
