package com.driver;

import com.model.*;

import java.util.Scanner;

public class MusicAppDriver {

    private static Facade facade;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        facade = new Facade();  // Using default constructor which creates a LessonList instance

        // Simulating an initial user signup and testing various actions
        System.out.println("Welcome to the Music App!");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    createSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    chooseSong();
                    break;
                case 6:
                    setSongPrivacy();
                    break;
                case 7:
                    exit();
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the menu options
    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Create Song");
        System.out.println("4. Delete Song");
        System.out.println("5. Choose Song");
        System.out.println("6. Set Song Privacy");
        System.out.println("7. Exit");
    }

    // Handle user sign up
    private static void signUp() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser = facade.signUp(firstName, lastName, username, email, password);
        System.out.println("Signup successful! Welcome, " + newUser.getUsername());
    }

    // Handle user login
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean loginSuccess = facade.UserLogin(username, password);
        if (loginSuccess) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // Create a song
    private static void createSong() {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        System.out.print("Enter song artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter song genre: ");
        String genre = scanner.nextLine();

        Song newSong = facade.createSong(title, artist, genre);
        System.out.println("Song created: " + newSong.getTitle() + " by " + newSong.getArtist());
    }

    // Delete a song
    private static void deleteSong() {
        System.out.print("Enter song title to delete: ");
        String title = scanner.nextLine();
        
        // Find the song by title (for simplicity, just use title to search)
        Song songToDelete = null;
        for (Song song : facade.SongList()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songToDelete = song;
                break;
            }
        }

        if (songToDelete != null) {
            boolean deleted = facade.deleteSong(songToDelete);
            if (deleted) {
                System.out.println("Song " + title + " deleted.");
            } else {
                System.out.println("Failed to delete song.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }

    // Choose a song (This will be a placeholder for now)
    private static void chooseSong() {
        Song song = facade.chooseSong();
        if (song != null) {
            System.out.println("Chosen song: " + song.getTitle());
        } else {
            System.out.println("No song selected.");
        }
    }

    // Set privacy for a song
    private static void setSongPrivacy() {
        System.out.print("Enter song title to change privacy: ");
        String title = scanner.nextLine();
        
        // Find the song by title (for simplicity, just use title to search)
        Song songToPrivacy = null;
        for (Song song : facade.SongList()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songToPrivacy = song;
                break;
            }
        }

        if (songToPrivacy != null) {
            System.out.print("Set privacy to (true/false): ");
            boolean isPrivate = scanner.nextBoolean();
            boolean success = facade.setSongPrivacy(songToPrivacy, isPrivate);
            if (success) {
                System.out.println("Privacy set successfully for " + title);
            } else {
                System.out.println("Failed to set privacy.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }

    // Exit the application
    private static void exit() {
        System.out.println("Exiting the Music App. Goodbye!");
    }
}