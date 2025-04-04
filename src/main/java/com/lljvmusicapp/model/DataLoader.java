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

    public static ArrayList<Song> getSongs()
    {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader fileReader = new FileReader(SONG_FILE_NAME);
            JSONParser parser = new JSONParser(); // Parse the file as a JSONObject since your file contains multiple keys
            JSONObject root = (JSONObject)parser.parse(fileReader); // Extract the "users" array from the root object
            JSONArray songsJSON = (JSONArray)root.get(SONG_LIST);

            for(int i = 0; i < songsJSON.size(); i++)
            {
                JSONObject songJSON = (JSONObject)songsJSON.get(i);
                UUID id = UUID.fromString((String)songJSON.get(SONG_ID));
                String title = ((String)songJSON.get(SONG_TITLE));
                String difficulty = ((String)songJSON.get(SONG_DIFFICULTY));
                
                Object tempoObj = songJSON.get(SONG_TEMPO);
                int tempo;

                if(tempoObj instanceof Long)
                {
                    tempo = ((Long)tempoObj).intValue();
                }
                
                else if(tempoObj instanceof String) 
                {
                    tempo = Integer.parseInt((String) tempoObj);
                }
                
                else
                {
                    tempo = 0; // or handle error
                }

                JSONArray notesJSON = (JSONArray)songJSON.get(NOTES);
                String[] notes = new String[notesJSON.size()];
                for (int j = 0; j < notesJSON.size(); j++)
                {
                    notes[j] = (String)notesJSON.get(j);
                }

                songs.add(new Song(id, title, difficulty, notes, tempo));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
        //TODO
    }

    public static ArrayList<SheetMusic> getSheetMusic()
    {
        //TODO
    }

    public static ArrayList<Lesson> getLessons()
    {
        //TODO
    }
}