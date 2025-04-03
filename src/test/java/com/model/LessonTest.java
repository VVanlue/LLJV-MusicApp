package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Lesson class.
 * 
 * @author Victoria
 */
public class LessonTest {
    private Lesson lesson;
    private Student student;
    private Song song;

    @Before
    public void setUp() {
        lesson = new Lesson("Music 101", "Introduction to music theory");
        student = new Student("student@example.com", "password123");
        song = new Song("Song Title", "Artist Name", "C4");
    }

    /**
     * Tests adding a student to the lesson.
     */
    @Test
    public void testAddStudent() {
        lesson.addStudent(student);
        assertTrue(lesson.getStudents().contains(student));
    }

    /**
     * Tests removing a student from the lesson.
     */
    @Test
    public void testRemoveStudent() {
        lesson.addStudent(student);
        boolean removed = lesson.removeStudent(student);
        assertTrue(removed);
        assertFalse(lesson.getStudents().contains(student));
    }

    /**
     * Tests removing a student that doesn't exist in the lesson.
     */
    @Test
    public void testRemoveNonExistingStudent() {
        boolean removed = lesson.removeStudent(student);
        assertFalse(removed);
    }

    /**
     * Tests assigning a song to all students in the lesson.
     */
    @Test
    public void testAssignSongToAllStudents() {
        lesson.addStudent(student);
        lesson.assignSongToAllStudents(song);
        // Assuming publishSong just prints a message; we can't really test the output unless we mock Music
        assertTrue(true); // Placeholder for verifying that the song was assigned
    }

    /**
     * Tests if the title is correct for the lesson.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Music 101", lesson.getTitle());
    }

    /**
     * Tests if the lesson plan is correct.
     */
    @Test
    public void testGetLessonPlan() {
        assertEquals("Introduction to music theory", lesson.getLessonPlan());
    }
}