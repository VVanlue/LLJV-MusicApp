package com.lljvmusicapp.model;

import java.util.ArrayList;

/**
 * Manages a list of lessons and provides functionality 
 * to start, quit, and save lessons.
 * @author Victoria
 */
public class LessonList {
    private static LessonList instance;
    private ArrayList<Lesson> lessons;

    /**
     * Private constructor to prevent external instantiation.
     */
    private LessonList() {
        lessons = DataLoader.getLessons();
    }

    public void reload() {
        lessons = DataLoader.getLessons();
    }

    /**
     * Returns the singleton instance of LessonList.
     * @return The singleton instance of LessonList.
     */
    public static LessonList getInstance() {
        if (instance == null) {
            instance = new LessonList();
        }
        return instance;
    }

    /**
     * Starts a lesson.
     */
    public void startLesson() {
        // TODO: Implement lesson start logic
    }

    /**
     * Quits the current lesson.
     */
    public void quitLesson() {
        // TODO: Implement lesson quit logic
    }

    /**
     * Saves lesson data into an ArrayList of Strings.
     * @return An ArrayList containing lesson data.
     */
    public ArrayList<String> saveinto() {
        // TODO: Implement saving logic
        return new ArrayList<>();
    }

    /**
     * Returns the list of all lessons.
     * 
     * @return an ArrayList of Lesson objects
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}

