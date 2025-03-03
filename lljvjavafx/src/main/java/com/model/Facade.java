package com.model;
import java.util.Scanner;

public class Facade {

    private User user;

    public Facade() {
        System.out.println("");
    }

    public List<User> UserList() {
        return null;
    }

    public List<User> LessonList() {
        return null;
    }

    public List<User> SongList() {
        return null;
    }

    public void login(String username, String password) {
        return;
    }
    
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        String username = scanner.nextLine();
    }

    public void instrumentSelection() {
        return;
    }
    
    public void lessonSelection() {
        return;
    }

    public void chooseSong() {
        return;
    }

    public void chooseDifficulty() {
        return;
    }

    public void createSong() {
        return;
    }

    public void postSong() {
        return;
    }

    public void deleteSong() {
        return;
    }

    public void setSongPrivacy() {
        return;
    }

    public void createSheetMusic() {
        return;
    }
}
