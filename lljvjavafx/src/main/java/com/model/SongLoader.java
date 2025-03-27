package com.model;

import java.io.*;
import java.nio.file.*;
import org.json.*;

public class SongLoader {
    private static final String SONGS_DIRECTORY = "resources/songs/";
    
    public static Song loadSong(String songTitle) throws IOException {
        String filename = songTitle.replaceAll("\\s+", "_").toLowerCase() + ".json";
        String filePath = SONGS_DIRECTORY + filename;
        
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject songJson = new JSONObject(content);
            
            Song song = new Song(songJson.getString("title"), songJson.getString("artist"));
            song.setLyrics(songJson.getString("lyrics"));
            
            // Load notes
            JSONArray notesArray = songJson.getJSONArray("notes");
            for (int i = 0; i < notesArray.length(); i++) {
                JSONObject noteJson = notesArray.getJSONObject(i);
                MusicalNote note = new MusicalNote(
                    noteJson.getString("pitch"),
                    noteJson.getInt("duration"),
                    noteJson.getInt("startTime")
                );
                song.addNote(note);
            }
            
            // Load sheet music
            JSONObject sheetMusicJson = songJson.getJSONObject("sheetMusic");
            for (String key : sheetMusicJson.keySet()) {
                song.addSheetMusic(key, sheetMusicJson.getString(key));
            }
            
            return song;
        } catch (IOException e) {
            throw new IOException("Failed to load song: " + songTitle, e);
        } catch (JSONException e) {
            throw new IOException("Invalid song data format for: " + songTitle, e);
        }
    }
}
