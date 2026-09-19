package de.accountvalidator.policy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsernamePolicyTest {
    @Test
    void testValidUsername() { assertTrue(UsernamePolicy.usernameValidityCheck("bigB1984")); }

    @Test
    void testNoLetterFirst() { assertFalse(UsernamePolicy.usernameValidityCheck("9username")); }

    @Test
    void testTooShort() { assertFalse(UsernamePolicy.usernameValidityCheck("short")); }

    @Test
    void testUsernameAllreadyUsed() {
        assertTrue(UsernamePolicy.UsernameOnList("Testuser0815"));
        assertFalse(UsernamePolicy.UsernameOnList("NewUser3423"));
    }
}