package de.accountvalidator.policy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPhoneNumberRulesTest {
    @Test
    void testValidPhoneNumber1() { assertTrue(ValidPhoneNumberRules.PhoneNumberValidityCheck("+491717546373")); }

    @Test
    void testValidPhoneNumber2() { assertTrue(ValidPhoneNumberRules.PhoneNumberValidityCheck("00498924578695")); }

    @Test
    void testValidPhoneNumber3() { assertTrue(ValidPhoneNumberRules.PhoneNumberValidityCheck("08927543636")); }

    @Test
    void testInvalidFirstChar1() { assertFalse(ValidPhoneNumberRules.PhoneNumberValidityCheck("789652486285")); }

    @Test
    void testInvalidFirstChar2() { assertFalse(ValidPhoneNumberRules.PhoneNumberValidityCheck("-948474773874")); }

    @Test
    void testNonDigitChar1() { assertFalse(ValidPhoneNumberRules.PhoneNumberValidityCheck("08947f387458437")); }

    @Test
    void testNonDigitChar2() { assertFalse(ValidPhoneNumberRules.PhoneNumberValidityCheck("+4989-478387284")); }

    @Test
    void testNonDigitChar3() { assertFalse(ValidPhoneNumberRules.PhoneNumberValidityCheck("089/173683635"));}
}