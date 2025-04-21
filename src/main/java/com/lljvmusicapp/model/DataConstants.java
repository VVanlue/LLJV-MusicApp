package com.lljvmusicapp.model;

/*
 * Defines constant values used throughout the application for file paths and JSON keys.
 * These constants are related to users, songs, sheet music, lessons, and instruments.
 * 
 */
public abstract class DataConstants {
    // Paths to JSON files
    protected static final String USER_FILE_NAME = "json/user.json";
    protected static final String SONG_FILE_NAME = "json/songs.json";
    protected static final String LESSON_FILE_NAME = "json/lessons.json";
    protected static final String SHEET_MUSIC_FILE_NAME = "json/sheetmusic.json";
    
    // User attribute constants
    protected static final String USER_ID = "uuid";
    protected static final String USER_USER_NAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_FAVORITE_SONGS = "favSongs";
    protected static final String USER_PUBLISHED_SONGS = "publishedSongs";

    
    // Song attribute constants
    protected static final String SONG_ID = "uuid";
    protected static final String SONG_TITLE = "title";
    protected static final String SONG_TEMPO = "tempo";
    protected static final String SONG_PUBLISHER = "Publisher";
    protected static final String SONG_LEVEL = "level";
    protected static final String SONG_GENRE = "genre";
    protected static final String SONG_INSTRUMENT = "Instrument";
    protected static final String SONG_SHEET_MUSIC = "sheetMusic";
    protected static final String SONG_LYRICS = "lyrics";
    protected static final String SONG_NOTES = "notes";
    
    // Sheet Music attribute constants
    protected static final String SHEET_MUSIC_ID = "sheetid";
    protected static final String SHEET_MUSIC_SONG_ID = "song";
    protected static final String SHEET_MUSIC_MEASURES = "measures";
    protected static final String SHEET_MUSIC_TEMPO = "tempo";
    protected static final String SHEET_MUSIC_INSTRUMENT = "instrument";
    protected static final String SHEET_MUSIC_NOTES = "Notes";
    
    // Lesson attribute constants
    protected static final String LESSON_ID = "uuid";
    protected static final String LESSON_TITLE = "title";
    protected static final String LESSON_INSTRUMENT_TYPE = "instrumentType";
    protected static final String LESSON_DIFFICULTY = "difficulty";
    protected static final String LESSON_GENRE = "genre";
    protected static final String LESSON_SONG = "song";
    
    // Instrument attribute constants
    protected static final String INSTRUMENT_TYPE = "type";

    // Note attribute constants
    public static final String NOTE_PITCH = "pitch";
    public static final String NOTE_DURATION = "duration";
    public static final String NOTE_START_TIME = "startTime";

    public static final String UPLOADER_ID = "uploaderId";
    public static final String FILE_PATH = "filePath";
}
