package de.accountvalidator.policy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UsernamePolicy {
    private static final String USERNAME_ALLOWED_CHARS_PATTERN = "[0-9A-Za-z§$%&_*\\-]+";

    private static final Pattern USERNAME_ALLOWED_PATTERN = Pattern.compile(USERNAME_ALLOWED_CHARS_PATTERN);

    public static boolean usernameValidityCheck(String username) {
        if (!USERNAME_ALLOWED_PATTERN.matcher(username).matches()) {
            return false;
        }

        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }

        if (username.length() < 7) {
            return false;
        }

        return true;
    }

    public static boolean UsernameOnList(String username) {
        try (Stream<String> userList = Files.lines(Path.of("src/main/resources/usernames.txt"))) {
            return userList.anyMatch(line -> line.trim().equals(username));
        } catch (IOException e) {
            System.out.println("Konnte Datei nicht lesen. Fehler: " + e.getMessage());
        }
        return false;
    }

    /*
    Username Information
    - only A-Z, a-z, 0-9, §$%&_*-
    - begins with letter
    - at least 7 characters
    - not used yet
     */
}