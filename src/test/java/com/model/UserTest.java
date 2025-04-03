package com.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the User class.
 * 
 * @author Victoria
 */
public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("test@example.com", "password123");
    }

    /**
     * Tests if the email is valid.
     */
    @Test
    public void testValidEmail() {
        assertTrue(user.isValidEmail());
    }

    /**
     * Tests if the email is invalid (missing '@').
     */
    @Test
    public void testInvalidEmailMissingAt() {
        user.setEmail("testexample.com");
        assertFalse(user.isValidEmail());
    }

    /**
     * Tests if the email is invalid (missing domain).
     */
    @Test
    public void testInvalidEmailMissingDomain() {
        user.setEmail("test@.com");
        assertFalse(user.isValidEmail());
    }

    /**
     * Tests if the email is invalid (contains invalid characters).
     */
    @Test
    public void testInvalidEmailInvalidChars() {
        user.setEmail("test@ex!ample.com");
        assertFalse(user.isValidEmail());
    }

    /**
     * Tests if the password is valid (at least 6 characters).
     */
    @Test
    public void testValidPassword() {
        assertTrue(user.isValidPassword());
    }

    /**
     * Tests if the password is too short (less than 6 characters).
     */
    @Test
    public void testInvalidPasswordTooShort() {
        user.setPassword("short");
        assertFalse(user.isValidPassword());
    }

    /**
     * Tests if the password is exactly 6 characters long.
     */
    @Test
    public void testValidPasswordExactLength() {
        user.setPassword("123456");
        assertTrue(user.isValidPassword());
    }

    /**
     * Tests if the password is invalid (less than 6 characters).
     */
    @Test
    public void testInvalidPasswordTooShort2() {
        user.setPassword("a");
        assertFalse(user.isValidPassword());
    }

    /**
     * Tests if the email is valid (contains upper case characters).
     */
    @Test
    public void testValidEmailWithUpperCase() {
        user.setEmail("Test@Example.com");
        assertTrue(user.isValidEmail());
    }

    /**
     * Tests if the email is invalid (empty string).
     */
    @Test
    public void testInvalidEmailEmpty() {
        user.setEmail("");
        assertFalse(user.isValidEmail());
    }

    /**
     * Tests if the email is invalid (null value).
     */
    @Test
    public void testInvalidEmailNull() {
        user.setEmail(null);
        assertFalse(user.isValidEmail());
    }

    /**
     * Tests if the password is valid (contains special characters).
     */
    @Test
    public void testValidPasswordWithSpecialChars() {
        user.setPassword("P@ssw0rd!");
        assertTrue(user.isValidPassword());
    }
}