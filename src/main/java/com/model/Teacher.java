package com.model;

import java.util.ArrayList;

/**
 * Represents a teacher with expertise and the ability to manage lesson assignments, student progress, and feedback.
 * 
 * @author Victoria
 */
public class Teacher {
    private String expertise = "Strong"; // Default expertise level
    private ArrayList<Lesson> lessonAssignment;

    /**
     * Creates a lesson for the teacher to assign.
     * 
     * @param lesson The Lesson to be created.
     */
    public void createLesson(Lesson lesson) {
        // Method stub
    }

    /**
     * Views the progress of a student.
     * 
     * @param student The Student whose progress is to be checked.
     */
    public void seeStudentProgress(Student student) {
        // Method stub
    }

    /**
     * Assigns a song to a student.
     * 
     * @param student The student to whom the song will be assigned.
     * @param song The Song to be assigned.
     */
    public void assignSong(Student student, Song song) {
        // Method stub
    }

    /**
     * Writes feedback for a student's performance in a lesson.
     * 
     * @param student The Student who will receive feedback.
     * @param lesson The Lesson for which feedback is being written.
     */
    public void writeFeedback(Student student, Lesson lesson) {
        // Method stub
    }
}