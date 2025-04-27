package com.lljvmusicapp.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.jfugue.theory.Note;

/**
 * Class responsible for reading song data
 * from a JSON file and converting it into Song objects.
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
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray songsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < songsJSON.size(); i++) {
                JSONObject songJSON = (JSONObject) songsJSON.get(i);
                UUID id = UUID.fromString((String) songJSON.get(SONG_ID));
                String title = (String) songJSON.get(SONG_TITLE);
                String publisher = (String) songJSON.get(SONG_PUBLISHER);
                String lyrics = (String) songJSON.get(SONG_LYRICS);
                String level = (String) songJSON.get(SONG_LEVEL);
                String genre = (String) songJSON.get(SONG_GENRE);
                
                int tempo = 0;
                Object tempoObj = songJSON.get(SONG_TEMPO);
                if (tempoObj instanceof Long) {
                    tempo = ((Long) tempoObj).intValue();
                } else if (tempoObj instanceof String) {
                    tempo = Integer.parseInt((String) tempoObj);
                }

                // Create a new Song object
                Song song = new Song(id, title, tempo, publisher, lyrics, level, genre);
                
                
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
                if (songJSON.containsKey(SONG_NOTES))
                {
                    JSONArray notesJSON = (JSONArray) songJSON.get(SONG_NOTES);
                    for (int j = 0; j < notesJSON.size(); j++)
                    {
                        JSONObject noteJSON = (JSONObject) notesJSON.get(j);
                        String pitch = (String) noteJSON.get(NOTE_PITCH);
                        int duration = ((Long) noteJSON.get(NOTE_DURATION)).intValue();
                        int startTime = ((Long) noteJSON.get(NOTE_START_TIME)).intValue();

                        Note note = new Note(pitch);
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
        
        return null; // Song not found
    }
}