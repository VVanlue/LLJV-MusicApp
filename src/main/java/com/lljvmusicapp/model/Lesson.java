package com.lljvmusicapp.model;

import java.util.List;
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
    private String genre;
    private String level;
    private List<Question> questions;

    /**
     * Constructor to initialize the lesson with a title and lesson plan.
     * 
     * @param title The title of the lesson.
     * @param lessonPlan The lesson plan for the lesson.
     */
    public Lesson(UUID lessonId, String title, String genre, String level) {
        this.lessonId = lessonId;
        this.title = title;
        this.genre = genre;
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
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the title of the lesson.
     * 
     * @return The title of the lesson.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Gets the list of quiz questions.
     * @return list of questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the list of quiz questions.
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    /**
     * Gets the UUID of the lesson.
     * @return the lesson UUID
     */
    public UUID getLessonId() {
        return lessonId;
    }
}