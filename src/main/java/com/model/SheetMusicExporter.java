package com.model;

import java.io.*;

/**
 * Exports song sheet music: notes, title, artist, and lyrics to a text file.
 */
public class SheetMusicExporter {
    
    /**
     * Exports a song's sheet music to a text file.
     * 
     * @param song the song containing sheet music
     * @param filePath the path to save the sheet music file
     * @throws IOException if an error occurs while writing the file
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
     * The part name is converted to uppercase, and any digits are separated by spaces.
     *
     * @param part The part name to format (e.g., "verse1").
     * @return The formatted part name (e.g., "VERSE 1").
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
     * Chords are prefixed with "Chords: " and lyrics are prefixed with "Lyrics: ".
     *
     * @param notation The raw sheet music notation (e.g., chords or lyrics).
     * @return The formatted sheet music notation with proper labels for chords and lyrics.
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
