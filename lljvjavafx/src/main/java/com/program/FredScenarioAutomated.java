package com.program;

import com.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Automated demonstration of Fred's scenario without requiring user input.
 * This is useful for testing or demonstration purposes.
 */
public class FredScenarioAutomated {
    
    public static void main(String[] args) {
        System.out.println("=== Fred's Music Player Scenario (Automated) ===");
        
        try {
            // Create sample songs if they don't exist
            createSampleSongs();
            
            // Step 1: Fred searches for Tom Petty songs
            System.out.println("\nFred searches for all songs by \"Tom Petty\"...");
            
            // Load all songs
            List<Song> allSongs = SongLoader.getAllSongs();
            
            // Filter for Tom Petty songs
            List<Song> tomPettySongs = new ArrayList<>();
            for (Song song : allSongs) {
                if (song.getArtist().equalsIgnoreCase("Tom Petty")) {
                    tomPettySongs.add(song);
                }
            }
            
            // Step 2: Fred sees the list of Tom Petty songs
            System.out.println("\nFred sees the following songs:");
            for (Song song : tomPettySongs) {
                System.out.println("- " + song.getTitle());
            }
            
            // Step 3: Fred selects Free Fallin
            System.out.println("\nFred picks Free Fallin");
            
            // Find Free Fallin in the list
            Song freeFallin = null;
            for (Song song : tomPettySongs) {
                if (song.getTitle().equalsIgnoreCase("Free Fallin")) {
                    freeFallin = song;
                    break;
                }
            }
            
            if (freeFallin == null) {
                System.out.println("Error: Free Fallin not found in the song list.");
                // Create Free Fallin if it doesn't exist
                freeFallin = createFreeFallinSong();
                System.out.println("Created Free Fallin song for demonstration.");
            }
            
            // Step 4: Fred plays the song
            System.out.println("\nFred plays the song...");
            System.out.println("(Simulating song playback - no actual audio in automated mode)");
            
            // Step 5: Fred exports the sheet music
            System.out.println("\nFred exports the sheet music to a text file...");
            String fileName = "free_fallin_sheet.txt";
            SheetMusicExporter.exportSheetMusic(freeFallin, fileName);
            
            System.out.println("Sheet music exported successfully to " + fileName);
            System.out.println("\nScenario completed successfully!");
            
        } catch (IOException e) {
            System.err.println("Error exporting sheet music: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void createSampleSongs() {
        // Create Free Fallin
        Song freeFallin = createFreeFallinSong();
        SongLoader.saveSong(freeFallin);
        
        // Create I Won't Back Down
        Song wontBackDown = new Song("I Won't Back Down", "Tom Petty");
        wontBackDown.setLyrics("Well, I won't back down\nNo, I won't back down\nYou can stand me up at the gates of hell\nBut I won't back down");
        wontBackDown.addSheetMusic("intro", "Em  D  G  G");
        wontBackDown.addSheetMusic("verse1", "Em       D       G       G\nWell, I won't back down");
        wontBackDown.addSheetMusic("chorus", "Em       D       G\nNo, I won't back down");
        SongLoader.saveSong(wontBackDown);
        
        // Create Mary Jane's Last Dance
        Song maryJane = new Song("Mary Jane's Last Dance", "Tom Petty");
        maryJane.setLyrics("She grew up in an Indiana town\nHad a good lookin' mama who never was around\nBut she grew up tall and she grew up right\nWith them Indiana boys on an Indiana night");
        maryJane.addSheetMusic("intro", "Am  G  D  Am");
        maryJane.addSheetMusic("verse1", "Am       G       D       Am\nShe grew up in an Indiana town");
        maryJane.addSheetMusic("chorus", "Am       G       D\nLast dance with Mary Jane");
        SongLoader.saveSong(maryJane);
    }
    
    private static Song createFreeFallinSong() {
        Song freeFallin = new Song("Free Fallin", "Tom Petty");
        freeFallin.setLyrics("She's a good girl, loves her mama\nLoves Jesus and America too\nShe's a good girl, crazy 'bout Elvis\nLoves horses and her boyfriend too\n\nIt's a long day living in Reseda\nThere's a freeway running through the yard\nAnd I'm a bad boy 'cause I don't even miss her\nI'm a bad boy for breaking her heart\n\nAnd I'm free, free fallin'\nYeah I'm free, free fallin'");
        
        freeFallin.addSheetMusic("intro", "D  D  A  G\nD  D  A  G");
        freeFallin.addSheetMusic("verse1", "D       D       A       G\nShe's a good girl, loves her mama");
        freeFallin.addSheetMusic("chorus", "G       D       A\nAnd I'm free, free fallin'");
        
        // Add some notes
        freeFallin.addNote(new MusicalNote("D4", 500, 0));
        freeFallin.addNote(new MusicalNote("A4", 500, 500));
        freeFallin.addNote(new MusicalNote("G4", 500, 1000));
        
        return freeFallin;
    }
}
