package com.lljvmusicapp.model;

/**
 * Manages the current active lesson session for a user.
 * Handles starting, retrieving, and completing lessons.
 * 
 * Author: Victoria
 */
public class LessonSession {
    private static Lesson currentLesson;

    /**
     * Starts a new lesson session by setting the current lesson.
     * 
     * @param lesson the Lesson to start
     */
    public static void start(Lesson lesson) {
        currentLesson = lesson;
    }

    /**
     * Gets the currently active lesson.
     * 
     * @return the current Lesson
     */
    public static Lesson getCurrentLesson() {
        return currentLesson;
    }

    /**
     * Marks the current lesson as completed for the current user.
     * Adds the lesson to the user's completed lessons and saves user data.
     */
    public static void completeCurrentLesson() {
        Lesson lesson = getCurrentLesson();
        if (lesson != null) {
            User currentUser = UserList.getCurrentUser();
            if (currentUser != null) { 
                currentUser.addCompletedLesson(lesson.getLessonId().toString());
                DataWriter.saveUsers();
            }
        }
    }
}