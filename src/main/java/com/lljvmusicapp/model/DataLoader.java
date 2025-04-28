package com.lljvmusicapp.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class responsible for reading user data
 * from a JSON file and converting it into User, Song, and Lesson objects.
 * 
 * @author Victoria
 */
public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try (FileReader reader = new FileReader(USER_FILE_NAME)) {
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);

            for (Object obj : peopleJSON) {
                JSONObject personJSON = (JSONObject) obj;

                UUID uuid = UUID.fromString((String) personJSON.get(USER_ID));
                String username = (String) personJSON.get(USER_USER_NAME);
                String password = (String) personJSON.get(USER_PASSWORD);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);

                JSONArray favArray = (JSONArray) personJSON.get(USER_FAVORITE_SONGS);
                ArrayList<String> favSongs = new ArrayList<>();
                if (favArray != null) {
                    for (Object song : favArray) {
                        favSongs.add((String) song);
                    }
                }

                JSONArray pubArray = (JSONArray) personJSON.get(USER_PUBLISHED_SONGS);
                ArrayList<String> pubSongs = new ArrayList<>();
                if (pubArray != null) {
                    for (Object song : pubArray) {
                        pubSongs.add((String) song);
                    }
                }

                JSONArray lesnArray = (JSONArray) personJSON.get(USER_COMPLETED_LESSONS);
                ArrayList<String> completedLessons = new ArrayList<>();
                if (lesnArray != null) {
                    for (Object lesson : lesnArray) {
                        completedLessons.add((String) lesson);
                    }
                }

                users.add(new User(uuid, username, password, firstName, lastName, email, favSongs, pubSongs, completedLessons));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<>();

        try (FileReader reader = new FileReader(SONG_FILE_NAME)) {
            JSONParser parser = new JSONParser();
            JSONArray songsJSON = (JSONArray) parser.parse(reader);

            for (Object obj : songsJSON) {
                JSONObject songJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) songJSON.get("uuid"));
                String title = (String) songJSON.get("title");
                String publisher = (String) songJSON.get("publisher");
                String lyrics = (String) songJSON.get("lyrics");
                String genre = (String) songJSON.get("genre");
                String level = (String) songJSON.get("level");
                String songFileName = (String) songJSON.get("songFileName");

                int tempo = 0;
                Object tempoObj = songJSON.get("tempo");
                if (tempoObj instanceof Long) {
                    tempo = ((Long) tempoObj).intValue();
                } else if (tempoObj instanceof String) {
                    tempo = Integer.parseInt((String) tempoObj);
                }

                Map<String, String> sheetMusic = new HashMap<>();

                Song song = new Song(id, title, tempo, publisher, lyrics, level, genre, songFileName);
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }

    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        try (FileReader reader = new FileReader(LESSON_FILE_NAME)) {
            JSONParser parser = new JSONParser();
            JSONArray lessonJSON = (JSONArray) parser.parse(reader);

            for (Object obj : lessonJSON) {
                JSONObject lessonObj = (JSONObject) obj;

                UUID lessonId = UUID.fromString((String) lessonObj.get("uuid"));
                String title = (String) lessonObj.get("title");
                String genre = (String) lessonObj.get("genre");
                String level = (String) lessonObj.get("level");

                Lesson lesson = new Lesson(lessonId, title, genre, level);

                // Parse questions
                JSONArray questionsJSON = (JSONArray) lessonObj.get("questions");
                List<Question> questionList = new ArrayList<>();

                for (Object qObj : questionsJSON) {
                    JSONObject qJson = (JSONObject) qObj;

                    String prompt = (String) qJson.get("prompt");
                    JSONArray optionsJSON = (JSONArray) qJson.get("options");
                    List<String> options = new ArrayList<>();
                    for (Object option : optionsJSON) {
                        options.add((String) option);
                    }
                    String correctAnswer = (String) qJson.get("correctAnswer");

                    Question question = new Question(prompt, options, correctAnswer);
                    questionList.add(question);
                }

                lesson.setQuestions(questionList);
                lessons.add(lesson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lessons;
    }
}
