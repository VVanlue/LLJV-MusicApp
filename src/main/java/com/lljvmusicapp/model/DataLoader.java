package com.lljvmusicapp.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class responsible for reading user data
 * from a JSON file and converting it into User objects.
 * 
 * This class extends DataConstants to access constant values
 * for JSON keys and file paths.
 * 
 * @author Victoria
 */
public class DataLoader extends DataConstants {

    /**
     * Loads users from the JSON file specified by USER_FILE_NAME.
     * Each JSON object is parsed into a User instance.
     *
     * @return an ArrayList<User> containing all users parsed from the file;
     *         if an error occurs, an empty list is returned
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> user = new ArrayList<>(); // Corrected variable name

        try (FileReader reader = new FileReader(USER_FILE_NAME)) { // Proper resource handling
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);

            for (Object obj : peopleJSON) { // Enhanced loop
                JSONObject personJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String userName = (String) personJSON.get(USER_USER_NAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String favSongs = (String) personJSON.get(USER_FAVORITE_SONGS);
                String pubSongs = (String) personJSON.get(USER_PUBLISHED_SONGS);

                user.add(new User(id, userName, firstName, lastName, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}