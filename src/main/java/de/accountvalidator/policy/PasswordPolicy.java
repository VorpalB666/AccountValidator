package de.accountvalidator.policy;

// safed passwords hashed with salt

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PasswordPolicy {
    private static final String PASSWORD_ALLOWED_CHARS_PATTERN = "[0-9A-Za-z§$%&_/()=?*\\-+#]+";

    private static final Pattern PASSWORD_ALLOWED_PATTERN = Pattern.compile(PASSWORD_ALLOWED_CHARS_PATTERN);

    public static boolean passwordValidityCheck(String password) {
        if (!PASSWORD_ALLOWED_PATTERN.matcher(password).matches()) {
            return false;
        }

        if (password.length() < 10) {
            return false;
        }

        if (!password.chars().anyMatch(Character::isDigit)) {
            return false;
        }

        if (!password.chars().anyMatch(Character::isUpperCase)) {
            return false;
        }

        if (!password.chars().anyMatch(Character::isLowerCase)) {
            return false;
        }

        if (!password.matches(".*[!§$%&/()=?*\\-+#].*")) {
            return false;
        }

        return true;
    }


    public static boolean PasswordOnList(String password) {
        try (Stream<String> passwordList = Files.lines(Path.of("src/main/resources/rockyou_1.txt"))) {
            return passwordList.anyMatch(line -> line.trim().equals(password));
        } catch (IOException e) {
            System.out.println("Konnte Datei nicht lesen. Fehler: " + e.getMessage());
        }
        return false;
    }

    /*
    Password Information
    - Allowed characters: 0-9, A-Z, a-z, §$%&_/()=?*-+#
    - at least 10 characters long
    - at least 1 digit
    - at least 1 upper case letter
    - at least 1 lower case letter
    - at least 1 special sign
     */
}