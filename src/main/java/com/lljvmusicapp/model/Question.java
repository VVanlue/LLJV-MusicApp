package com.lljvmusicapp.model;

import java.util.List;

/**
 * Represents a multiple-choice question with a prompt, options, and the correct answer.
 * This class works independently and integrates with Lesson objects.
 * 
 * @author Victoria
 */
public class Question {

    private String prompt;
    private List<String> options;
    private String correctAnswer;

    /**
     * Default constructor for JSON parsing.
     */
    public Question() {}

    /**
     * Constructs a Question with the specified prompt, options, and correct answer.
     * 
     * @param prompt the question text
     * @param options list of answer choices
     * @param correctAnswer the correct choice from the provided options
     */
    public Question(String prompt, List<String> options, String correctAnswer) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Gets the question prompt.
     * 
     * @return the question prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Sets the question prompt.
     * 
     * @param prompt the prompt to set
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Gets the available options for the question.
     * 
     * @return list of answer options
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Sets the available options for the question.
     * 
     * @param options the options to set
     */
    public void setOptions(List<String> options) {
        this.options = options;
    }

    /**
     * Gets the correct answer for the question.
     * 
     * @return the correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the correct answer for the question.
     * 
     * @param correctAnswer the correct answer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Checks if a given answer matches the correct answer.
     * 
     * @param answer the answer to check
     * @return true if correct, false otherwise
     */
    public boolean isCorrect(String answer) {
        return correctAnswer != null && correctAnswer.equals(answer);
    }

    /**
     * Converts questions to a string for printing
     * @return the question, propmt, options, and right answer
     **/
    @Override
    public String toString() {
        return "Question{" +
                "prompt='" + prompt + '\'' +
                ", options=" + options +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
