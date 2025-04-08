package com.lljvmusicapp.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList<>();
    
        try (FileReader reader = new FileReader(USER_FILE_NAME))
        {
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);
    
            for (Object obj : peopleJSON)
            {
                JSONObject personJSON = (JSONObject) obj;
    
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String userName = (String) personJSON.get(USER_USER_NAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
    
                ArrayList<String> favSongs = new ArrayList<>();
                ArrayList<String> pubSongs = new ArrayList<>();
    
                String favSongsStr = (String) personJSON.get(USER_FAVORITE_SONGS);

                if (favSongsStr != null && !favSongsStr.isEmpty()) //Load the arrays, albeit these are pulling from a uuid, so TODO
                {
                    for (String song : favSongsStr.split(","))
                    {
                        favSongs.add(song.trim());
                    }
                }
    
                String pubSongsStr = (String) personJSON.get(USER_PUBLISHED_SONGS);
                if (pubSongsStr != null && !pubSongsStr.isEmpty())
                {
                    for (String song : pubSongsStr.split(","))
                    {
                        pubSongs.add(song.trim());
                    }
                }
    
                User user = new User(id, userName, firstName, lastName, email, favSongs, pubSongs);
                users.add(user);
            }
    
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    
        return users;
    }
    

    public static ArrayList<Song> getSongs()
    {
        ArrayList<Song> songs = new ArrayList<>();

        try (FileReader reader = new FileReader(SONG_FILE_NAME))
        {
            JSONParser parser = new JSONParser();
            JSONArray songsJSON = (JSONArray) parser.parse(reader);

            for (Object obj : songsJSON)
            {
                JSONObject songJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) songJSON.get(SONG_ID));
                String title = (String) songJSON.get(SONG_TITLE);
                String publisher = (String) songJSON.get(SONG_PUBLISHER);
                String level = (String) songJSON.get(SONG_LEVEL);
                String genre = (String) songJSON.get(SONG_GENRE);
                UUID instrumentId = UUID.fromString((String) songJSON.get(SONG_INSTRUMENT));

                Object tempoObj = songJSON.get(SONG_TEMPO);

                int tempo;

                if (tempoObj instanceof Long)
                {
                    tempo = ((Long) tempoObj).intValue();
                }

                else if (tempoObj instanceof String)
                {
                    tempo = Integer.parseInt((String) tempoObj);
                }

                else
                {
                    tempo = 0;
                }

                Map<String, String> sheetMusic = new HashMap<>();

                Song song = new Song(id, title, tempo, publisher, level, genre, instrumentId, sheetMusic);
                songs.add(song);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return songs;
    }


    public static ArrayList<SheetMusic> getSheetMusic() {
        ArrayList<SheetMusic> sheets = new ArrayList<>();
    
        try (FileReader reader = new FileReader(SHEET_MUSIC_FILE_NAME)) {
            JSONParser parser = new JSONParser();
            JSONArray musicJSON = (JSONArray) parser.parse(reader);
    
            for (Object obj : musicJSON) {
                JSONObject music = (JSONObject) obj;
    
                UUID sheetId = UUID.fromString((String) music.get(SHEET_MUSIC_ID));
                UUID songId = UUID.fromString((String) music.get(SHEET_MUSIC_SONG_ID));
                int measures = ((Long) music.get(SHEET_MUSIC_MEASURES)).intValue();
                int tempo = Integer.parseInt((String) music.get(SHEET_MUSIC_TEMPO));
    
                // Convert note string into custom Note objects
                String notesStr = (String) music.get(SHEET_MUSIC_NOTES);
                List<Note> notes = new ArrayList<>();
    
                for (String noteStr : notesStr.split(" ")) {
                    try {
                        Note.NoteName noteName = Note.NoteName.valueOf(noteStr.trim().toUpperCase());
                        Note note = new Note(noteName, 4, 0); // default length = 4 (quarter), startTime = 0
                        notes.add(note);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Skipping invalid note: " + noteStr);
                    }
                }
    
                SheetMusic sheetMusic = new SheetMusic(sheetId, songId, measures, tempo, notes);
                sheets.add(sheetMusic);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return sheets;
    }
    


    public static ArrayList<Lesson> getLessons()
    {
        //TODO
    }
}