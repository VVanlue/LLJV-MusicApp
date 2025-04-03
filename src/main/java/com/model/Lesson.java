package com.model;

import java.util.ArrayList;

/**
 * Represents a lesson with a list of students, assignments, and a lesson plan.
 * Provides methods for managing and tracking the lesson.
 * 
 * @author Victoria
 */
public class Lesson {
    private String title;
    private String lessonPlan;
    private ArrayList<Student> students;

    /**
     * Constructor to initialize the lesson with a title and lesson plan.
     * 
     * @param title The title of the lesson.
     * @param lessonPlan The lesson plan for the lesson.
     */
    public Lesson(String title, String lessonPlan) {
        this.title = title;
        this.lessonPlan = lessonPlan;
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the lesson.
     * 
     * @param student The student to be added to the lesson.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Removes a student from the lesson.
     * 
     * @param student The student to be removed.
     * @return True if the student was removed, false if the student was not found.
     */
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    /**
     * Assigns a song to all students in the lesson.
     * 
     * @param song The song to be assigned to students.
     */
    public void assignSongToAllStudents(Song song) {
        for (Student student : students) {
            student.publishSong();
        }
    }

    /**
     * Gets the list of students in the lesson.
     * 
     * @return The list of students in the lesson.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets the title of the lesson.
     * 
     * @return The title of the lesson.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the lesson plan of the lesson.
     * 
     * @return The lesson plan of the lesson.
     */
    public String getLessonPlan() {
        return lessonPlan;
    }
}