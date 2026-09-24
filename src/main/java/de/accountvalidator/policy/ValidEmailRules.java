package de.accountvalidator.policy;

public class ValidEmailRules {
    public static boolean emailValidityCheck (String email) {
        if (!email.matches(".*[@].*\\.[a-zA-Z]{2,}$")) {
            System.out.println("Please enter valid email address");
            return false;
        }

        return true;
    }
}