<<<<<<< HEAD
package com.model;

import javax.sound.midi.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Plays songs using the Java MIDI system.
 */
public class MusicPlayer {
    private static final int DEFAULT_VELOCITY = 64; // Default volume
    private Synthesizer synthesizer;
    private MidiChannel channel;
    private Map<String, Integer> noteMap;
    
    /**
     * Creates a new MusicPlayer and initializes the MIDI system.
     */
    public MusicPlayer() {
        initializeSynthesizer();
        initializeNoteMap();
    }
    
    private void initializeSynthesizer() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] channels = synthesizer.getChannels();
            channel = channels[0]; // Use the first channel
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to initialize MIDI synthesizer: " + e.getMessage());
        }
    }
    
    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // Map note names to MIDI note numbers
        noteMap.put("C3", 48);
        noteMap.put("C#3", 49);
        noteMap.put("D3", 50);
        noteMap.put("D#3", 51);
        noteMap.put("E3", 52);
        noteMap.put("F3", 53);
        noteMap.put("F#3", 54);
        noteMap.put("G3", 55);
        noteMap.put("G#3", 56);
        noteMap.put("A3", 57);
        noteMap.put("A#3", 58);
        noteMap.put("B3", 59);
        noteMap.put("C4", 60);
        noteMap.put("C#4", 61);
        noteMap.put("D4", 62);
        noteMap.put("D#4", 63);
        noteMap.put("E4", 64);
        noteMap.put("F4", 65);
        noteMap.put("F#4", 66);
        noteMap.put("G4", 67);
        noteMap.put("G#4", 68);
        noteMap.put("A4", 69);
        noteMap.put("A#4", 70);
        noteMap.put("B4", 71);
    }
    
    /**
     * Plays a song using the MIDI synthesizer.
     * 
     * @param song the song to play
     */
    public void playSong(Song song) {
        if (synthesizer == null || channel == null) {
            System.err.println("MIDI synthesizer not available");
            return;
        }
        
        System.out.println("Now playing: " + song.getTitle() + " by " + song.getArtist());
        
        // Sort notes by start time
        List<MusicalNote> notes = new ArrayList<>(song.getNotes());
        notes.sort(Comparator.comparingInt(MusicalNote::getStartTime));
        
        // Schedule notes to play at their respective times
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        
        for (MusicalNote note : notes) {
            executor.schedule(() -> {
                playNote(note.getPitch(), note.getDuration());
            }, note.getStartTime(), TimeUnit.MILLISECONDS);
        }
        
        // Shutdown executor after the last note
        if (!notes.isEmpty()) {
            MusicalNote lastNote = notes.get(notes.size() - 1);
            executor.schedule(() -> {
                executor.shutdown();
            }, lastNote.getStartTime() + lastNote.getDuration() + 500, TimeUnit.MILLISECONDS);
        } else {
            executor.shutdown();
        }
    }
    
    /**
     * Plays a single note.
     * 
     * @param noteName the name of the note (e.g., "C4", "D#3")
     * @param duration the duration in milliseconds
     */
    public void playNote(String noteName, int duration) {
        if (synthesizer == null || channel == null) {
            System.err.println("MIDI synthesizer not available");
            return;
        }
        
        Integer noteNumber = noteMap.get(noteName);
        if (noteNumber == null) {
            System.err.println("Unknown note: " + noteName);
            return;
        }
        
        try {
            // Start the note
            channel.noteOn(noteNumber, DEFAULT_VELOCITY);
            
            // Schedule note off after duration
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    channel.noteOff(noteNumber);
                }
            }, duration);
        } catch (Exception e) {
            System.err.println("Error playing note: " + e.getMessage());
        }
    }
    
    /**
     * Closes the MIDI synthesizer.
     */
    public void close() {
        if (synthesizer != null) {
            synthesizer.close();
        }
=======
package com.program;

import com.music.*;
import java.lang.Thread;

public class MusicPlayer {
    
    public void playSong() {
        try {
            playLine1();
            Thread.sleep(100);
            playLine2();
            Thread.sleep(100);
            playLine3();
            Thread.sleep(100);
            playLine4();
            Thread.sleep(100);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /*
     * Megolovania - Undertale - Toby Fox
     * @author Victoria
     */
    private void playLine1() {
        Music.playNote("D5i");
        Music.playNote("D5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine2() {
        Music.playNote("C5i");
        Music.playNote("C5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine3() {
        Music.playNote("B5i");
        Music.playNote("B5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    private void playLine4() {
        Music.playNote("A#5i");
        Music.playNote("A#5i");
        Music.playNote("D6");
        Music.playNote("A6");
        Music.playNote("Ri");
        Music.playNote("G#6i");
        Music.playNote("Ri");
        Music.playNote("G6i");
        Music.playNote("F6i-");
        Music.playNote("F6i");
        Music.playNote("Ri");
        Music.playNote("D6i");
        Music.playNote("F6i");
        Music.playNote("G6i");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.playSong();
>>>>>>> 477eec2dcf422def5ba26c910d625f0ff7299a5b
    }
}
