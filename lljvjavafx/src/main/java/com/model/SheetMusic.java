package com.model;
import java.util.List;
import java.util.UUID;

import org.jfugue.theory.Note;

public class SheetMusic {
    private UUID sheetId;
    private UUID songId;
    private int measures;
    private int tempo;
    private UUID instrumentId; //actual instrument
    private List<Note> notes;

    public SheetMusic(UUID sheetId, UUID songId, int measures, int tempo, UUID instrumentId, List<Note> notes) {
        this.sheetId = sheetId;
        this.songId = songId;
        this.measures = measures;
        this.tempo = tempo;
        this.instrumentId = instrumentId;
        this.notes = notes;
    }
    // Get Methods
    public UUID getSheetId() {
        return sheetId;
    }

    public UUID getSongId() {
        return songId;
    }

    public int getMeasures() {
        return measures;
    }

    public int getTempo() {
        return tempo;
    }

    public UUID getInstrumentId() {
        return instrumentId;
    }

    public List<String> getNotes() {
        return notes;
    }

    // Set Methods
    public void setSheetId(UUID sheetId) {
        this.sheetId = sheetId;
    }

    public void setSongId(UUID songId) {
        this.songId = songId;
    }

    public void setMeasures(int measures) {
        this.measures = measures;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setInstrumentId(UUID instrumentId) {
        this.instrumentId = instrumentId;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
