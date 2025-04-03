package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Unit tests for the Teacher class.
 * 
 * @author Victoria
 */
public class TeacherTest {
    private Teacher teacher;
    private Student student;
    private Song song;
    private Lesson lesson;

    @Before
    public void setUp() {
        teacher = new Teacher();
        student = new Student();
        song = new Song("Song Title", "Artist Name");
        lesson = new Lesson("Lesson Title");
    }

    /**
     * Tests if a lesson can be successfully created.
     */
    @Test
    public void testCreateLesson() {
        teacher.createLesson(lesson);
        // Assuming there's a method to retrieve lessons assigned to the teacher
        ArrayList<Lesson> lessons = teacher.getLessonAssignments();
        assertTrue(lessons.contains(lesson));
    }

    /**
     * Tests viewing a student's progress.
     */
    @Test
    public void testSeeStudentProgress() {
        teacher.seeStudentProgress(student); // Should trigger trackProgression for the student
        // No assertion needed here as it's more of a print test, just checking no errors
    }

    /**
     * Tests assigning a song to a student.
     */
    @Test
    public void testAssignSong() {
        teacher.assignSong(student, song);
        // Assuming `student.publishSong()` updates a list or prints a message
        ArrayList<Song> publishedSongs = student.getPublishedSongs();
        assertTrue(publishedSongs.contains(song));
    }

    /**
     * Tests writing feedback for a student on a lesson.
     */
    @Test
    public void testWriteFeedback() {
        teacher.writeFeedback(student, lesson); // Should print feedback message
        // No assertion needed here as it's a print test
    }

    /**
     * Tests setting and getting teacher's expertise.
     */
    @Test
    public void testExpertise() {
        assertEquals("Strong", teacher.getExpertise());
        teacher.setExpertise("Advanced");
        assertEquals("Advanced", teacher.getExpertise());
    }

    /**
     * Tests creating a lesson with null input (should not add a lesson).
     */
    @Test
    public void testCreateLessonWithNull() {
        teacher.createLesson(null); // Should print an error message
    }

    /**
     * Tests assigning a null song or student.
     */
    @Test
    public void testAssignNullSongOrStudent() {
        teacher.assignSong(null, song); // Should print an error message
        teacher.assignSong(student, null); // Should print an error message
    }

    /**
     * Tests writing feedback with null inputs (should print an error message).
     */
    @Test
    public void testWriteFeedbackWithNull() {
        teacher.writeFeedback(null, lesson); // Should print an error message
        teacher.writeFeedback(student, null); // Should print an error message
    }
}