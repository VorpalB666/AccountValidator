package de.accountvalidator.policy;

public class ValidPhoneNumberRules {
    public static boolean PhoneNumberValidityCheck (String phoneNumber) {
        if (!(phoneNumber.startsWith("+") || phoneNumber.startsWith("0"))) {
            return false;
        }

        for (int i=1; i<phoneNumber.length(); i++) {
            char currentChar = phoneNumber.charAt(i);

            if (!Character.isDigit(currentChar)) {
                System.out.println("Please enter valid phone number");
                return false;
            }
        }


        return true;
    }
}