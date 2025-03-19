package com.model;
import java.util.List;
    public class SheetMusic {
        private int measures;
        private List<Note> notes;
        private int tempo;
        private List<String> instruments;
    
        public SheetMusic(int measures, List<Note> notes, int tempo, List<String> instruments) {
            this.measures = measures;
            this.notes = notes;
            this.tempo = tempo;
            this.instruments = instruments;
        }
    
        // Get Methods
        public int getMeasures() {
            return measures;
        }
    
        public List<Note> getNotes() {
            return notes;
        }
    
        public int getTempo() {
            return tempo;
        }
    
        public List<String> getInstruments() {
            return instruments;
        }
    
        // Set Methods
        public void setMeasures(int measures) {
            this.measures = measures;
        }
    
        public void setNotes(List<Note> notes) {
            this.notes = notes;
        }
    
        public void setTempo(int tempo) {
            this.tempo = tempo;
        }
    
        public void setInstruments(List<String> instruments) {
            this.instruments = instruments;
        }
    }
    
    // Note Class
    public class Note {
        private String pitch; // ex. "C", "D#", "Bb"
        private double duration; // ex, 0.25 for a quarter note
        private int octave; // ex. 4
    
        public Note(String pitch, double duration, int octave) {
            this.pitch = pitch;
            this.duration = duration;
            this.octave = octave;
        }
}
