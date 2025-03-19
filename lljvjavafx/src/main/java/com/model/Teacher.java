package com.model;

import java.util.ArrayList;

public class Teacher extends User {
    
private ArrayList<Lesson> createdLessons;

    public Teacher(String firstName, String lastName, String username, String email, String password) {
        super(firstName, lastName, username, email, password);
        this.createdLessons = new ArrayList<>();
    }

    public void createLesson(Lesson lesson) {
        createdLessons.add(lesson);
        System.out.println(username + " created a new lesson: " + lesson.getTitle());
    }

    public void reviewStudentProgress(Student student) {
        System.out.println(username + " is reviewing progress for student: " + student.username);
    }

}
