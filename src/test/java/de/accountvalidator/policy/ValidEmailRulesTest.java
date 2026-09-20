package de.accountvalidator.policy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidEmailRulesTest {
    @Test
    void testValidEmailDE() { assertTrue(ValidEmailRules.emailValidityCheck("example@test.de")); }

    @Test
    void testValidEmailCOM() { assertTrue(ValidEmailRules.emailValidityCheck("example@test.com"));}

    @Test
    void testMissingAt() { assertFalse(ValidEmailRules.emailValidityCheck("mail.without.at")); }

    @Test
    void testShortTopLevelDomain() { assertFalse(ValidEmailRules.emailValidityCheck("shortTLD@test.d")); }

    @Test
    void testDigitInTopLevelDomain() { assertFalse(ValidEmailRules.emailValidityCheck("digitIn@tld.de2")); }
};