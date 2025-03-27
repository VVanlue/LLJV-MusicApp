package com.program;

import com.model.*;
import java.util.*;
import java.io.IOException;

public class MusicPlayerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer player = null;
        
        try {
            // Load all songs
            ArrayList<Song> allSongs = SongLoader.getSongs();
            
            // Filter for Tom Petty songs
            ArrayList<Song> tomPettySongs = new ArrayList<>();
            for (Song song : allSongs) {
                if (song.getArtist().equalsIgnoreCase("Tom Petty")) {
                    tomPettySongs.add(song);
                }
            }
            
            // Display Tom Petty songs
            System.out.println("Tom Petty songs:");
            for (int i = 0; i < tomPettySongs.size(); i++) {
                System.out.println((i + 1) + ". " + tomPettySongs.get(i).getTitle());
            }
            
            // Fred selects Free Fallin
            Song selectedSong = null;
            for (Song song : tomPettySongs) {
                if (song.getTitle().equalsIgnoreCase("Free Fallin")) {
                    selectedSong = song;
                    break;
                }
            }
            
            if (selectedSong == null) {
                System.out.println("Free Fallin not found in the song library.");
                return;
            }
            
            System.out.println("\nSelected song: " + selectedSong.getTitle());
            
            // Play the song
            player = new MusicPlayer();
            System.out.println("Playing " + selectedSong.getTitle() + "...");
            player.playSong(selectedSong);
            
            // Wait for song to finish (simplified)
            System.out.println("Press Enter to continue to sheet music export...");
            scanner.nextLine();
            
            // Export sheet music
            String exportPath = selectedSong.getTitle().replaceAll("\\s+", "_").toLowerCase() + "_sheet.txt";
            System.out.println("\nExporting sheet music to " + exportPath);
            SheetMusicExporter.exportSheetMusic(selectedSong, exportPath);
            
            System.out.println("Sheet music exported successfully!");
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (player != null) {
                player.close();
            }
            scanner.close();
        }
    }
}
