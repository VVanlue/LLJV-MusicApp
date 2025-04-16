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
    private String description;
    private String level;
    private List<Question> questions;

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
     * A nested class representing a multiple choice question.
     */
    public static class Question {
        private String prompt;
        private List<String> options;
        private String correctAnswer;

        /**
         * Default constructor for JSON parsing.
         */
        public Question() {}

        /**
         * Constructor to manually create a question.
         * @param prompt the question text
         * @param options the answer choices
         * @param correctAnswer the correct answer
         */
        public Question(String prompt, List<String> options, String correctAnswer) {
            this.prompt = prompt;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        /**
         * Gets the question prompt.
         * @return the prompt
         */
        public String getPrompt() {
            return prompt;
        }

        /**
         * Sets the question prompt.
         * @param prompt the prompt to set
         */
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        /**
         * Gets the list of options.
         * @return the options
         */
        public List<String> getOptions() {
            return options;
        }

        /**
         * Sets the options.
         * @param options the options to set
         */
        public void setOptions(List<String> options) {
            this.options = options;
        }

        /**
         * Gets the correct answer.
         * @return the correct answer
         */
        public String getCorrectAnswer() {
            return correctAnswer;
        }

        /**
         * Sets the correct answer.
         * @param correctAnswer the correct answer to set
         */
        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }
    }

}