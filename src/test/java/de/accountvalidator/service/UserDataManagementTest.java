package de.accountvalidator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDataManagementTest {
    @Test
    void testCreateUserAccount_CompleteFlow() {
        String expectedUsername = "MaxMustermann";
        String expectedPassword = "SecureP@ss123";
        String expectedEmail = "max.mustermann@example.com";
        String expectedPhone = "+491701234567";

        UserDataManagement.User testUser = new UserDataManagement.User(
                expectedUsername, expectedPassword, expectedEmail, expectedPhone);

        assertNotNull(testUser);
        assertEquals(expectedUsername, testUser.username);
        assertEquals(expectedPassword, testUser.password);
        assertEquals(expectedEmail, testUser.email);
        assertEquals(expectedPhone, testUser.phone);
    }
}