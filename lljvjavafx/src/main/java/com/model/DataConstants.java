package com.model;

public abstract class DataConstants {
    // File paths
    protected static final String USER_FILE_NAME = "lljavafx/src/main/java/com/data/json/user.json";
    protected static final String SONG_FILE_NAME = "lljavafx/src/main/java/com/data/json/song.json";
    protected static final String LESSON_FILE_NAME = "lljavafx/src/main/java/com/data/json/lesson.json";
    protected static final String INSTRUMENT_FILE_NAME = "lljavafx/src/main/java/com/data/json/instrument.json";
    
    // User constants
    protected static final String USER_ID = "uuid";
    protected static final String USER_USER_NAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_FAVORITE_SONGS = "favSongs";
    protected static final String USER_PUBLISHED_SONGS = "publishedSongs";
    protected static final String USER_INSTRUMENT = "instrument";
    protected static final String USER_SKILL_LEVEL = "skillLevel";
    
    // Song constants
    protected static final String SONG_ID = "id";
    protected static final String SONG_TITLE = "title";
    protected static final String SONG_ARTIST = "artist";
    protected static final String SONG_INSTRUMENT_TYPE = "instrumentType";
    protected static final String SONG_DIFFICULTY_LEVEL = "difficultyLevel";
    protected static final String SONG_CREATOR = "creator";
    protected static final String SONG_IS_PUBLIC = "isPublic";
    protected static final String SONG_SHEET_MUSIC = "sheetMusic";
    
    // Sheet Music constants
    protected static final String SHEET_MUSIC_SONG_ID = "songId";
    protected static final String SHEET_MUSIC_NOTATION = "notation";
    
    // Lesson constants
    protected static final String LESSON_ID = "id";
    protected static final String LESSON_TITLE = "title";
    protected static final String LESSON_DESCRIPTION = "description";
    protected static final String LESSON_INSTRUMENT_TYPE = "instrumentType";
    protected static final String LESSON_DIFFICULTY_LEVEL = "difficultyLevel";
    protected static final String LESSON_CONTENT = "content";
    protected static final String LESSON_CREATOR = "creator";
    
    // Instrument constants
    protected static final String INSTRUMENT_ID = "id";
    protected static final String INSTRUMENT_TYPE = "type";
    protected static final String INSTRUMENT_NAME = "name";
    protected static final String INSTRUMENT_DESCRIPTION = "description";
}
