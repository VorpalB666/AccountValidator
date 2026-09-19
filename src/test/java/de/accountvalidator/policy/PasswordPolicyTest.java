package de.accountvalidator.policy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordPolicyTest {
    @Test
    void testValidPassword() {
        assertTrue(PasswordPolicy.passwordValidityCheck("1Geheim1234&"));
    }

    @Test
    void testCharNotAllowed() {
        assertFalse(PasswordPolicy.passwordValidityCheck("Geheim{[!232"));
    }

    @Test
    void testTooShort() {
        assertFalse(PasswordPolicy.passwordValidityCheck("abc1234"));
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordPolicy.passwordValidityCheck("Mein!Passwort"));
    }

    @Test
    void testNoUpperCase() {
        assertFalse(PasswordPolicy.passwordValidityCheck("!noupper83$%§"));
    }

    @Test
    void testNoLowerCase() {
        assertFalse(PasswordPolicy.passwordValidityCheck("!NOLOWER83$%§"));
    }

    @Test
    void testNoSpecialCharr() {
        assertFalse(PasswordPolicy.passwordValidityCheck("Geheim12345"));
    }

    @Test
    void testPasswordOnList() {
        assertTrue(PasswordPolicy.PasswordOnList("sabarsaja2007+"));
        assertFalse(PasswordPolicy.PasswordOnList("HHkdkfjsd$%$355334"));
    }
}


