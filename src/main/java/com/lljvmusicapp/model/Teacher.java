package com.lljvmusicapp.model;

import java.util.ArrayList;

import com.lljvmusicapp.model.Lesson;

/**
 * Represents a teacher with expertise and the ability to manage lesson assignments, student progress, and feedback.
 * 
 * @author Victoria
 */
public class Teacher {
    private String expertise = "Strong"; // Default expertise level
    private ArrayList<Lesson> lessonAssignment;

    /**
     * Constructs a Teacher object with an empty lesson assignment list.
     */
    public Teacher() {
        lessonAssignment = new ArrayList<>();
    }

    /**
     * Creates a lesson for the teacher to assign.
     * 
     * @param lesson The Lesson to be created.
     */
    public void createLesson(Lesson lesson) {
        if (lesson == null) {
            System.out.println("Error: Cannot create a null lesson.");
            return;
        }
        lessonAssignment.add(lesson);
        System.out.println("Lesson created: " + lesson.getTitle());
    }

    /**
     * Views the progress of a student.
     * 
     * @param student The Student whose progress is to be checked.
     */
    public void seeStudentProgress(Student student) {
        if (student == null) {
            System.out.println("Error: No student provided.");
            return;
        }
        System.out.println("Viewing progress for student: " + student.getName());
        student.trackProgression();
    }

    /**
     * Assigns a song to a student.
     * 
     * @param student The student to whom the song will be assigned.
     * @param song The Song to be assigned.
     */
    public void assignSong(Student student, Song song) {
        if (student == null || song == null) {
            System.out.println("Error: Cannot assign a null song or student.");
            return;
        }
        student.publishSong(song);
        System.out.println("Song assigned: " + song.getTitle() + " to student: " + student.getName());
    }

    /**
     * Writes feedback for a student's performance in a lesson.
     * 
     * @param student The Student who will receive feedback.
     * @param lesson The Lesson for which feedback is being written.
     */
    public void writeFeedback(Student student, Lesson lesson) {
        if (student == null || lesson == null) {
            System.out.println("Error: Cannot write feedback without valid student and lesson.");
            return;
        }
        System.out.println("Feedback for " + student.getName() + " on lesson: " + lesson.getTitle());
    }

    /**
     * Gets the teacher's expertise level.
     * 
     * @return The expertise level.
     */
    public String getExpertise() {
        return expertise;
    }

    /**
     * Sets the teacher's expertise level.
     * 
     * @param expertise The new expertise level.
     */
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
