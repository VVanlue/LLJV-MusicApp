package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import com.model.*;

/**
 * Unit tests for the Keyboard class.
 * 
 * @author Victoria
 */
public class KeyboardTest {

    @BeforeEach
    void setUp() {
        Music.enableTestMode(); // Enable test mode before each test
    }

    @Test
    void testValidKeyPress() {
        Keyboard.handleKeyPress("A");
        List<String> playedNotes = Music.getPlayedNotes();
        assertEquals(1, playedNotes.size());
        assertEquals("C4", playedNotes.get(0));
    }

    @Test
    void testValidKeyPress_Lowercase() {
        Keyboard.handleKeyPress("a"); // Should work the same as uppercase
        List<String> playedNotes = Music.getPlayedNotes();
        assertEquals(1, playedNotes.size());
        assertEquals("C4", playedNotes.get(0));
    }

    @Test
    void testInvalidKeyPress() {
        Keyboard.handleKeyPress("Z");
        List<String> playedNotes = Music.getPlayedNotes();
        assertTrue(playedNotes.isEmpty()); // No note should be played
    }

    @Test
    void testNullKeyPress() {
        Keyboard.handleKeyPress(null);
        List<String> playedNotes = Music.getPlayedNotes();
        assertTrue(playedNotes.isEmpty());
    }

    @Test
    void testEmptyKeyPress() {
        Keyboard.handleKeyPress("");
        List<String> playedNotes = Music.getPlayedNotes();
        assertTrue(playedNotes.isEmpty());
    }

    @Test
    void testSpecialCharacters() {
        Keyboard.handleKeyPress("@");
        List<String> playedNotes = Music.getPlayedNotes();
        assertTrue(playedNotes.isEmpty());
    }
}