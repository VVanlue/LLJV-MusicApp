package com.lljvmusicapp.model;

import java.util.UUID;
/**
 * Represents a lesson with a list of students, assignments, and a lesson plan.
 * Provides methods for managing and tracking the lesson.
 * 
 * @author Victoria
 */
public class Lesson {
    private UUID lessonId;
    private String title;
    private String description;
    private String level;

    /**
     * Constructor to initialize the lesson with a title and lesson plan.
     * 
     * @param title The title of the lesson.
     * @param lessonPlan The lesson plan for the lesson.
     */
    public Lesson(UUID lessonId, String title, String description, String level) {
        this.lessonId = lessonId;
        this.title = title;
        this.description = description;
        this.level= level;
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
     * Gets the title of the lesson.
     * 
     * @return The title of the lesson.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the title of the lesson.
     * 
     * @return The title of the lesson.
     */
    public String getLevel() {
        return level;
    }

}