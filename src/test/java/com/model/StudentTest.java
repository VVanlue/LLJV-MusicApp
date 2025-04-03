package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import com.model.*;

/**
 * Unit tests for the Student class.
 * 
 * @author Victoria
 */
public class StudentTest {
    private Student student;
    private Song song1;
    private Song song2;
    private Lesson lesson1;

    @Before
    public void setUp() {
        student = new Student();
        song1 = new Song("Song A", "Artist A");
        song2 = new Song("Song B", "Artist B");
        lesson1 = new Lesson("Piano Basics");
    }

    /**
     * Tests if a student can start a lesson.
     */
    @Test
    public void testStartLesson() {
        student.startLesson(lesson1);
        assertEquals(lesson1, student.getCurrentLesson());
    }

    /**
     * Tests if publishing a song correctly adds it to the published list.
     */
    @Test
    public void testPublishSong() {
        student.publishSong(song1);
        ArrayList<Song> publishedSongs = student.getPublishedSongs();
        assertEquals(1, publishedSongs.size());
        assertEquals(song1, publishedSongs.get(0));
    }

    /**
     * Tests if adding a song to favorites works correctly.
     */
    @Test
    public void testAddFavoriteSong() {
        student.addFavoriteSong(song2);
        ArrayList<Song> favSongs = student.getFavoriteSongs();
        assertEquals(1, favSongs.size());
        assertEquals(song2, favSongs.get(0));
    }

    /**
     * Tests tracking progression when no lesson is active.
     */
    @Test
    public void testTrackProgressionWithoutLesson() {
        student.trackProgression(); // Should print a message indicating no active lesson
        assertNull(student.getCurrentLesson());
    }

    /**
     * Tests starting a null lesson (should not replace the current lesson).
     */
    @Test
    public void testStartNullLesson() {
        student.startLesson(null);
        assertNull(student.getCurrentLesson());
    }

    /**
     * Tests publishing a null song (should not add to the list).
     */
    @Test
    public void testPublishNullSong() {
        student.publishSong(null);
        assertTrue(student.getPublishedSongs().isEmpty());
    }

    /**
     * Tests adding a null song to favorites (should not add to the list).
     */
    @Test
    public void testAddNullFavoriteSong() {
        student.addFavoriteSong(null);
        assertTrue(student.getFavoriteSongs().isEmpty());
    }
}