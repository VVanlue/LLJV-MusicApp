package com.model;

import java.io.*;
import java.util.*;

/**
 * This class provides functionality for formatting and exporting sheet music for a given song.
 * The sheet music includes the song's title, artist, lyrics, and various music parts (e.g., intro, verse, chorus).
 * The formatted sheet music is written to a file at the specified file path.
 */
public class SheetMusicFormatter {
    
    /**
     * Exports the sheet music of a given song to a specified file path.
     * The sheet music includes the title, artist, lyrics, and formatted music parts in the correct order.
     *
     * @param song The song to export the sheet music for.
     * @param filePath The path to the file where the sheet music will be saved.
     * @throws IOException If an I/O error occurs during the file writing process.
     */
    public static void exportSheetMusic(Song song, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Write header
            writer.println("=".repeat(60));
            writer.println("SHEET MUSIC: " + song.getTitle());
            writer.println("ARTIST: " + song.getArtist());
            writer.println("=".repeat(60));
            writer.println();
            
            // Write lyrics if available
            if (song.getLyrics() != null && !song.getLyrics().isEmpty()) {
                writer.println("LYRICS:");
                writer.println("-".repeat(60));
                writer.println(song.getLyrics());
                writer.println();
            }
            
            // Write sheet music parts
            Map<String, String> sheetMusic = song.getSheetMusic();
            if (sheetMusic != null && !sheetMusic.isEmpty()) {
                // Define the order of parts
                List<String> orderedParts = Arrays.asList("intro", "verse1", "chorus", "verse2", "bridge", "outro");
                
                // Write parts in order if they exist
                for (String part : orderedParts) {
                    if (sheetMusic.containsKey(part)) {
                        writer.println(formatPartName(part) + ":");
                        writer.println("-".repeat(60));
                        writer.println(formatSheetMusic(sheetMusic.get(part)));
                        writer.println();
                    }
                }
                
                // Write any remaining parts not in the ordered list
                for (Map.Entry<String, String> entry : sheetMusic.entrySet()) {
                    if (!orderedParts.contains(entry.getKey())) {
                        writer.println(formatPartName(entry.getKey()) + ":");
                        writer.println("-".repeat(60));
                        writer.println(formatSheetMusic(entry.getValue()));
                        writer.println();
                    }
                }
            }
            
            // Add footer
            writer.println("=".repeat(60));
            writer.println("Generated on: " + new Date());
        }
    }
    
    /**
     * Formats the name of a song part (e.g., "verse1" to "VERSE 1").
     * 
     * @param part The part name to format.
     * @return The formatted part name, where digits are separated by spaces and the first letter of each word is capitalized.
     */
    private static String formatPartName(String part) {
        // Convert "verse1" to "VERSE 1"
        StringBuilder result = new StringBuilder();
        boolean nextUpper = true;
        
        for (char c : part.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(" ").append(c);
            } else if (nextUpper) {
                result.append(Character.toUpperCase(c));
                nextUpper = false;
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Formats the sheet music notation by adding proper spacing and distinguishing between chords and lyrics.
     * 
     * @param notation The raw sheet music notation (e.g., chords or lyrics).
     * @return The formatted sheet music notation with proper labels ("Chords" or "Lyrics").
     */
    private static String formatSheetMusic(String notation) {
        // Add proper spacing and formatting to the sheet music notation
        String[] lines = notation.split("\n");
        StringBuilder formatted = new StringBuilder();
        
        for (String line : lines) {
            // Format chord lines (lines with mostly capital letters and spaces)
            if (line.matches(".*[A-G][#m]?.*")) {
                formatted.append("Chords: ").append(line).append("\n");
            } else {
                formatted.append("Lyrics: ").append(line).append("\n");
            }
        }
        
        return formatted.toString();
    }
}
