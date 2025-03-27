package com.model;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class responsible for reading and writing song data
 * from/to JSON files and converting between JSON and Song objects.
 * 
 * This class extends DataConstants to access constant values
 * for JSON keys and file paths.
 */
public class SongLoader extends DataConstants {

    /**
     * Loads songs from the JSON file specified by SONG_FILE_NAME.
     * Each JSON object is parsed into a Song instance.
     *
     * @return an ArrayList<Song> containing all songs parsed from the file;
     *         if an error occurs, an empty list is returned
     */
    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            File file = new File(SONG_FILE_NAME);
            if (!file.exists()) {
                // Create directory if it doesn't exist
                File dir = file.getParentFile();
                if (dir != null && !dir.exists()) {
                    dir.mkdirs();
                }
                // Create empty songs file
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("[]");
                }
                return songs;
            }

            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray songsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < songsJSON.size(); i++) {
                JSONObject songJSON = (JSONObject) songsJSON.get(i);
                UUID id = UUID.fromString((String) songJSON.get(SONG_ID));
                String title = (String) songJSON.get(SONG_TITLE);
                String artist = (String) songJSON.get(SONG_ARTIST);
                String lyrics = (String) songJSON.get(SONG_LYRICS);
                
                // Create a new Song object
                Song song = new Song(id, title, artist);
                song.setLyrics(lyrics);
                
                // Load sheet music if available
                if (songJSON.containsKey(SONG_SHEET_MUSIC)) {
                    JSONObject sheetMusicJSON = (JSONObject) songJSON.get(SONG_SHEET_MUSIC);
                    for (Object key : sheetMusicJSON.keySet()) {
                        String partName = (String) key;
                        String notation = (String) sheetMusicJSON.get(partName);
                        song.addSheetMusic(partName, notation);
                    }
                }
                
                // Load notes if available
                if (songJSON.containsKey(SONG_NOTES)) {
                    JSONArray notesJSON = (JSONArray) songJSON.get(SONG_NOTES);
                    for (int j = 0; j < notesJSON.size(); j++) {
                        JSONObject noteJSON = (JSONObject) notesJSON.get(j);
                        String pitch = (String) noteJSON.get(NOTE_PITCH);
                        int duration = ((Long) noteJSON.get(NOTE_DURATION)).intValue();
                        int startTime = ((Long) noteJSON.get(NOTE_START_TIME)).intValue();
                        
                        MusicalNote note = new MusicalNote(pitch, duration, startTime);
                        song.addNote(note);
                    }
                }
                
                songs.add(song);
            }

            return songs;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
    
    /**
     * Gets all songs from the JSON file.
     * This is an alias for getSongs() to match the method name used in FredScenarioAutomated.
     *
     * @return a List<Song> containing all songs
     */
    public static List<Song> getAllSongs() {
        return getSongs();
    }
    
    /**
     * Loads a specific song by title from the JSON file.
     *
     * @param songTitle the title of the song to load
     * @return the Song object if found, null otherwise
     */
    public static Song loadSong(String songTitle) {
        ArrayList<Song> songs = getSongs();
        
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(songTitle)) {
                return song;
            }
        }
        
        // Try to load from individual file if not found in main file
        return loadSongFromIndividualFile(songTitle);
    }
    
    /**
     * Loads a song from an individual JSON file.
     *
     * @param songTitle the title of the song to load
     * @return the Song object if found, null otherwise
     */
    private static Song loadSongFromIndividualFile(String songTitle) {
        String filename = songTitle.replaceAll("\\s+", "_").toLowerCase() + ".json";
        String filePath = SONGS_DIRECTORY + filename;
        
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return null;
            }
            
            FileReader reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            JSONObject songJSON = (JSONObject) parser.parse(reader);
            
            UUID id;
            if (songJSON.containsKey(SONG_ID)) {
                id = UUID.fromString((String) songJSON.get(SONG_ID));
            } else {
                id = UUID.randomUUID();
            }
            
            String title = (String) songJSON.get(SONG_TITLE);
            String artist = (String) songJSON.get(SONG_ARTIST);
            
            Song song = new Song(id, title, artist);
            
            if (songJSON.containsKey(SONG_LYRICS)) {
                song.setLyrics((String) songJSON.get(SONG_LYRICS));
            }
            
            // Load sheet music if available
            if (songJSON.containsKey(SONG_SHEET_MUSIC)) {
                JSONObject sheetMusicJSON = (JSONObject) songJSON.get(SONG_SHEET_MUSIC);
                for (Object key : sheetMusicJSON.keySet()) {
                    String partName = (String) key;
                    String notation = (String) sheetMusicJSON.get(partName);
                    song.addSheetMusic(partName, notation);
                }
            }
            
            // Load notes if available
            if (songJSON.containsKey(SONG_NOTES)) {
                JSONArray notesJSON = (JSONArray) songJSON.get(SONG_NOTES);
                for (int j = 0; j < notesJSON.size(); j++) {
                    JSONObject noteJSON = (JSONObject) notesJSON.get(j);
                    String pitch = (String) noteJSON.get(NOTE_PITCH);
                    int duration = ((Long) noteJSON.get(NOTE_DURATION)).intValue();
                    int startTime = ((Long) noteJSON.get(NOTE_START_TIME)).intValue();
                    
                    MusicalNote note = new MusicalNote(pitch, duration, startTime);
                    song.addNote(note);
                }
            }
            
            return song;
            
        } catch (IOException | ParseException e) {
            System.err.println("Error loading song from file: " + filePath);
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Saves a song to the songs collection and updates the JSON file.
     * If the song already exists (by title and artist), it will be updated.
     * Otherwise, it will be added as a new song.
     *
     * @param song the Song object to save
     * @return true if the save was successful, false otherwise
     */
    public static boolean saveSong(Song song) {
        if (song == null) {
            return false;
        }
        
        try {
            // First, save to individual file
            saveToIndividualFile(song);
            
            // Then update the main songs collection
            ArrayList<Song> songs = getSongs();
            boolean found = false;
            
            // Check if song already exists (by ID or title/artist)
            for (int i = 0; i < songs.size(); i++) {
                Song existingSong = songs.get(i);
                if (existingSong.getId().equals(song.getId()) || 
                    (existingSong.getTitle().equalsIgnoreCase(song.getTitle()) && 
                     existingSong.getArtist().equalsIgnoreCase(song.getArtist()))) {
                    // Replace existing song
                    songs.set(i, song);
                    found = true;
                    break;
                }
            }
            
            // Add as new song if not found
            if (!found) {
                songs.add(song);
            }
            
            // Save updated collection to file
            saveAllSongs(songs);
            
            return true;
        } catch (Exception e) {
            System.err.println("Error saving song: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Saves a song to its individual JSON file.
     *
     * @param song the Song object to save
     * @throws IOException if there's an error writing to the file
     */
    private static void saveToIndividualFile(Song song) throws IOException {
        // Create directory if it doesn't exist
        File dir = new File(SONGS_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        // Create JSON representation of the song
        JSONObject songJSON = createJSONFromSong(song);
        
        // Generate filename
        String filename = song.getTitle().replaceAll("\\s+", "_").toLowerCase() + ".json";
        String filePath = SONGS_DIRECTORY + filename;
        
        // Write to file with pretty formatting
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(prettyPrintJSON(songJSON));
            file.flush();
        }
    }
    
    /**
     * Saves all songs to the main JSON file.
     *
     * @param songs the list of Song objects to save
     * @throws IOException if there's an error writing to the file
     */
    private static void saveAllSongs(List<Song> songs) throws IOException {
        // Create directory if it doesn't exist
        File file = new File(SONG_FILE_NAME);
        File dir = file.getParentFile();
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        
        // Create JSON array of songs
        JSONArray songsArray = new JSONArray();
        for (Song song : songs) {
            JSONObject songJSON = createJSONFromSong(song);
            songsArray.add(songJSON);
        }
        
        // Write to file
        try (FileWriter writer = new FileWriter(SONG_FILE_NAME)) {
            writer.write(prettyPrintJSON(songsArray));
            writer.flush();
        }
    }
    
    /**
     * Creates a JSONObject representation of a Song.
     *
     * @param song the Song to convert
     * @return a JSONObject representing the song
     */
    private static JSONObject createJSONFromSong(Song song) {
        JSONObject songJSON = new JSONObject();
        
        // Add basic properties
        songJSON.put(SONG_ID, song.getId().toString());
        songJSON.put(SONG_TITLE, song.getTitle());
        songJSON.put(SONG_ARTIST, song.getArtist());
        
        // Add lyrics if available
        if (song.getLyrics() != null && !song.getLyrics().isEmpty()) {
            songJSON.put(SONG_LYRICS, song.getLyrics());
        }
        
        // Add notes if available
        if (!song.getNotes().isEmpty()) {
            JSONArray notesArray = new JSONArray();
            for (MusicalNote note : song.getNotes()) {
                JSONObject noteJSON = new JSONObject();
                noteJSON.put(NOTE_PITCH, note.getPitch());
                noteJSON.put(NOTE_DURATION, note.getDuration());
                noteJSON.put(NOTE_START_TIME, note.getStartTime());
                notesArray.add(noteJSON);
            }
            songJSON.put(SONG_NOTES, notesArray);
        }
        
        // Add sheet music if available
        if (!song.getSheetMusic().isEmpty()) {
            JSONObject sheetMusicJSON = new JSONObject();
            for (Map.Entry<String, String> entry : song.getSheetMusic().entrySet()) {
                sheetMusicJSON.put(entry.getKey(), entry.getValue());
            }
            songJSON.put(SONG_SHEET_MUSIC, sheetMusicJSON);
        }
        
        return songJSON;
    }
    
    /**
     * Pretty prints a JSON object with indentation.
     * 
     * @param json the JSON object to format
     * @return a formatted JSON string
     */
    private static String prettyPrintJSON(Object json) {
        if (json instanceof JSONObject) {
            return ((JSONObject) json).toJSONString();
        } else if (json instanceof JSONArray) {
            return ((JSONArray) json).toJSONString();
        }
        return json.toString();
    }
}
