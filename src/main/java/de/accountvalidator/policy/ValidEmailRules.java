package de.accountvalidator.policy;

public class ValidEmailRules {
    public static boolean emailValidityCheck (String email) {
        if (!email.matches(".*[@].*\\.[a-zA-Z]{2,}$")) {
            return false;
        }

        return true;
    }
}