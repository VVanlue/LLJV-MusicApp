package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade {
    private User user;
    private List<User> users;
    private List<Song> songs;
    private List<Lesson> lessons;

    public Facade() {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public List<User> UserList() {
        return users; 
    }

    public List<Lesson> LessonList() {
        return lessons;
    }

    public List<Song> SongList() {
        return songs;
    }

    public void UserLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Login successful!");
                this.user = u;
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        User newUser = new User(firstName, lastName, username, email, password);
        users.add(newUser);
        System.out.println("Signup successful!");
    }

    public void instrumentSelection() {
        System.out.println("Instrument selection feature coming soon.");
    }

    public void lessonSelection() {
        System.out.println("Lesson selection feature coming soon.");
    }

    public void chooseSong() {
        System.out.println("Song selection feature coming soon.");
    }

    public void chooseDifficulty() {
        System.out.println("Difficulty selection feature coming soon.");
    }

    public void createSong() {
        System.out.println("Create song feature coming soon.");
    }

    public void postSong() {
        System.out.println("Post song feature coming soon.");
    }

    public void deleteSong() {
        System.out.println("Delete song feature coming soon.");
    }

    public void setSongPrivacy() {
        System.out.println("Song privacy settings feature coming soon.");
    }

    public void createSheetMusic() {
        System.out.println("Create sheet music feature coming soon.");
    }
}
