package com.lljvmusicapp.model;

import java.util.ArrayList;

public class DashboardScreen {

    private User user;

    /**
     * Constructs the DashboardScreen with the logged-in user.
     * @param user The currently logged-in user
     */
    public DashboardScreen(User user) {
        this.user = user;
    }

    /**
     * Displays the user dashboard using plain text in the console.
     */
    public void show() {
        System.out.println("Welcome, " + user.getFirstName());

        // Favorite Songs
        System.out.println("\nFavorite Songs:");
        ArrayList<String> favSongIds = user.getFavSongs();
        if (favSongIds.isEmpty()) {
            System.out.println("  No favorite songs.");
        } else {
            for (String songId : favSongIds) {
                System.out.println("  - Song ID: " + songId);
            }
        }

        // Current Lessons
        System.out.println("\nCurrent Lessons:");
        ArrayList<Lesson> lessons = LessonList.getInstance().getLessons();
        if (lessons.isEmpty()) {
            System.out.println("  No lessons available.");
        } else {
            for (Lesson lesson : lessons) {
                System.out.println("  - " + lesson.getTitle());
            }
        }

        // Featured Songs
        System.out.println("\nFeatured Songs:");
        ArrayList<Song> songs = SongList.getInstance().getSongs();
        if (songs.isEmpty()) {
            System.out.println("  No songs available.");
        } else {
            for (Song song : songs) {
                System.out.println("  - " + song.getTitle() + " (" + song.getGenre() + ")");
            }
        }

        System.out.println();
    }
}