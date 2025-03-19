package com.model;

public class Student extends User {
    
    private ArrayList <Lesson> enrolledLessons;

    public Student (String firstName, String lastName, String username, String email, String password)
    {
        syper(firstName, lastName, username, email, password);
        this.enrolledLessons = new ArrayList <>();
    }

    public void enrolledInLesson (Lesson lesson) 
    {
        enrolledLessons. add(lesson);
    }

    public void completeLesson(Lesson)
    {
        if (enrolledLessons.contain(lesson)) 
        {
            enrolledLessons.remove(lesson);
        }
    }

}
