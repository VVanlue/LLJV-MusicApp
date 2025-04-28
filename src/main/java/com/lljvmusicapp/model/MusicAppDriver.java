package com.lljvmusicapp.model;

import java.util.Scanner;
import java.util.UUID;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The driver class for the Music App. It provides a menu-driven interface for users
 * to sign up, log in, create, delete, and manage songs.
 * 
 * @author Victoria
 * 
 */
public class MusicAppDriver extends Application {

    /** The scanner instance for user input. */
    private static Scanner scanner;
    private static Stage primaryStage;


    /**
     * The entry point of the Music App. It initializes the application and presents a menu for user interactions.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
     public void start(Stage primaryStage) {
        MusicAppDriver.primaryStage = primaryStage;
        scanner = new Scanner(System.in);

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

    /**
     * Displays the menu options for the user.
     */
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

    /**
     * Handles user sign-up by collecting user details and creating a new account.
     */
    private static void signUp() {
        UUID id = UUID.randomUUID();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User newUser = Facade.signUp(id, username, password, firstName, lastName, email);
        System.out.println("Signup successful! Welcome, " + newUser.getUsername());
    }

    /**
     * Handles user login by prompting for credentials and verifying them.
     */
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean loginSuccess = Facade.UserLogin(username, password);
        if (loginSuccess) {
            System.out.println("Login successful!");
            
            User loggedInUser = Facade.getCurrentUser();

            DashboardScreen dashboard = new DashboardScreen(loggedInUser); 
            dashboard.show();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    /**
     * Allows the user to create a new song by entering its details.
     */
    private static void createSong() {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        System.out.print("Enter song artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter song genre: ");
        String genre = scanner.nextLine();
        String songFileName = "MyNewSong.mp3";

        Song newSong = Facade.createSong(title, artist, genre, songFileName);
        System.out.println("Song created: " + newSong.getTitle() + " by " + newSong.getPublisher());
    }

    /**
     * Allows the user to delete a song by searching for it by title.
     */
    private static void deleteSong() {
        System.out.print("Enter song title to delete: ");
        String title = scanner.nextLine();
        
        // Find the song by title (for simplicity, just use title to search)
        Song songToDelete = null;
        for (Song song : Facade.SongList()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songToDelete = song;
                break;
            }
        }

    }

    /**
     * Allows the user to choose a song.
     */
    private static void chooseSong() {
        Song song = Facade.chooseSong();
        if (song != null) {
            System.out.println("Chosen song: " + song.getTitle());
        } else {
            System.out.println("No song selected.");
        }
    }

    /**
     * Allows the user to set the privacy setting for a song.
     */
    private static void setSongPrivacy() {
        System.out.print("Enter song title to change privacy: ");
        String title = scanner.nextLine();
        
        // Find the song by title (for simplicity, just use title to search)
        Song songToPrivacy = null;
        for (Song song : Facade.SongList()) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songToPrivacy = song;
                break;
            }
        }

        if (songToPrivacy != null) {
            System.out.print("Set privacy to (true/false): ");
            boolean isPrivate = scanner.nextBoolean();
            boolean success = Facade.setSongPrivacy(songToPrivacy, isPrivate);
            if (success) {
                System.out.println("Privacy set successfully for " + title);
            } else {
                System.out.println("Failed to set privacy.");
            }
        } else {
            System.out.println("Song not found.");
        }
    }

    /**
     * Exits the application.
     */
    private static void exit() {
        System.out.println("Exiting the Music App. Goodbye!");
    }
}