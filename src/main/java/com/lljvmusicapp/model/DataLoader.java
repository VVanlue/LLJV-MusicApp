package com.lljvmusicapp.model;
 
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
      public static void listAvailableResources() {
        try {
            var classLoader = DataLoader.class.getClassLoader();
            var root = classLoader.getResource("com/lljvmusicapp/json");
    
            if (root != null) {
                System.out.println("✔ JSON resource directory found: " + root);
            } else {
                System.out.println("✖ JSON resource directory not found.");
            }
    
            // Try loading each specific file
            String[] files = {"user.json", "lessons.json", "songs.json"};
            for (String file : files) {
                InputStream is = classLoader.getResourceAsStream("com/lljvmusicapp/json/" + file);
                System.out.println(file + ": " + (is != null ? "FOUND ✅" : "NOT FOUND ❌"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      public static ArrayList<User> getUsers() {
         
        ArrayList<User> user = new ArrayList<>(); // Corrected variable name
        
        

         try {
            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream("/json/user.json");
            if (input == null) {
                throw new FileNotFoundException("Could not find com/lljvmusicapp/json/user.json");
            }

            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(new InputStreamReader(input));
            
             for (Object obj : peopleJSON) { // Enhanced loop
                 JSONObject personJSON = (JSONObject) obj;
 
                 UUID uuid = UUID.fromString((String) personJSON.get(USER_ID));
                 String username = (String) personJSON.get(USER_USER_NAME);
                 String password = (String) personJSON.get(USER_PASSWORD);
                 String firstName = (String) personJSON.get(USER_FIRST_NAME);
                 String lastName = (String) personJSON.get(USER_LAST_NAME);
                 String email = (String) personJSON.get(USER_EMAIL);
                 
                 JSONArray favArray = (JSONArray) personJSON.get(USER_FAVORITE_SONGS);
                 ArrayList<String> favSongs = new ArrayList<>();
                 if (favArray != null) {
                     for (Object song : favArray) {
                         favSongs.add((String) song);
                     }
                 }

                 JSONArray pubArray = (JSONArray) personJSON.get(USER_PUBLISHED_SONGS);
                 ArrayList<String> pubSongs = new ArrayList<>();
                 if (pubArray != null) {
                     for (Object song : pubArray) {
                         pubSongs.add((String) song);
                     }
                 }
 
                 user.add(new User(uuid, username, password, firstName, lastName, email, favSongs, pubSongs));
             }
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
         return user;
    }

    /**
    * Loads all songs from the SONG_FILE_NAME JSON file.
    *
    * @return an ArrayList of Song objects
    */
    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<>();

        try {
            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream("/json/songs.json");
            if (input == null) {
                throw new FileNotFoundException("Could not find com/lljvmusicapp/json/songs.json");
            }

        JSONParser parser = new JSONParser();
        JSONArray songsJSON = (JSONArray) parser.parse(new InputStreamReader(input));

            for (Object obj : songsJSON) {
                JSONObject songJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) songJSON.get("uuid"));
                String title = (String) songJSON.get("title");
                String publisher = (String) songJSON.get("publisher");
                String lyrics = (String) songJSON.get("lyrics");
                String genre = (String) songJSON.get("genre");
                String level = (String) songJSON.get("level");

                int tempo = 0;
                Object tempoObj = songJSON.get("tempo");
                if (tempoObj instanceof Long) {
                    tempo = ((Long) tempoObj).intValue();
                } else if (tempoObj instanceof String) {
                    tempo = Integer.parseInt((String) tempoObj);
                }

                // If you want to load sheet music later, leave it empty for now
                Map<String, String> sheetMusic = new HashMap<>();

                Song song = new Song(id, title, tempo, publisher, lyrics, level, genre);
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }


    /**
     * Loads all lessons from the LESSON_FILE_NAME JSON file.
     *
     * @return an ArrayList of Lesson objects
     */
    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        try {
            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream("/json/lessons.json");
            if (input == null) {
                throw new FileNotFoundException("Could not find com/lljvmusicapp/json/lessons.json");
            }

            JSONParser parser = new JSONParser();
            JSONArray lessonJSON = (JSONArray) parser.parse(new InputStreamReader(input));
            
            for (Object obj : lessonJSON) {
                JSONObject lessonObj = (JSONObject) obj;

                UUID lessonId = UUID.fromString((String) lessonObj.get("uuid"));
                String title = (String) lessonObj.get("title");
                String description = (String) lessonObj.get("description");
                String level = (String) lessonObj.get("level");

                Lesson lesson = new Lesson(lessonId, title, description, level);
                lessons.add(lesson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lessons;
    }
 }