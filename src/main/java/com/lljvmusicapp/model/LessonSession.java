package com.lljvmusicapp.model;

public class LessonSession {
    private static Lesson currentLesson;

    public static void start(Lesson lesson) {
        currentLesson = lesson;
    }

    public static Lesson getCurrentLesson() {
        return currentLesson;
    }

    public static void completeCurrentLesson() {
        Lesson lesson = getCurrentLesson();
        if (lesson != null) {
            User user = UserList.getCurrentUser();
            if (user != null) {
                user.addCompletedLesson(lesson.getLessonId().toString());
                DataWriter.saveUsers();
            }
        }
    }
}