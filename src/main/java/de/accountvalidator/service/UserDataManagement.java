package de.accountvalidator.service;

import java.util.Arrays;
import java.util.Scanner;

public class UserDataManagement {
    /*
    CRUD
    Create
    Retrieve
    Update
    Delete

    Test: create User
     */

    static class User {
        String username;
        String password;
        String email;
        String phone;

        User (String username, String password, String email, String phone) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.phone = phone;
        }
    }

    public static String stringScanner(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String userInput = scanner.nextLine().trim();
        return userInput;
    }

    public static String inputUsername() {
        while (true) {
            String usernameInput = stringScanner("Please enter username: ");

            if (!de.accountvalidator.policy.UsernamePolicy.usernameValidityCheck(usernameInput)) {
                System.out.println("No valid username");
            } else if (de.accountvalidator.policy.UsernamePolicy.UsernameOnList(usernameInput)) {
                System.out.println("username not available");
            } else {
                return usernameInput;
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String passwordInput = stringScanner("Please enter password: ");

            if (!de.accountvalidator.policy.PasswordPolicy.passwordValidityCheck(passwordInput)) {
                System.out.print("Invalid password. Password requirements:\n" +
                        "\t- Allowed characters: 0-9, A-Z, a-z, §$%&_/()=?*\\-+#\n" +
                        "\t- at least 10 characters long\n" +
                        "\t- at least 1 digit\n" +
                        "\t- at least 1 upper case letter\n" +
                        "\t- at least 1 lower case letter\n" +
                        "\t- at least 1 special sign");
            } else if (de.accountvalidator.policy.PasswordPolicy.PasswordOnList(passwordInput)){
                System.out.println("Caution! Your password is on a list of stolen passwords.");
                while(true) {
                    String decision = stringScanner("Continue (c) or enter new password (p)?");
                    if (decision.equals("c")) {
                        return passwordInput;
                    } else if (decision.equals("e")) {
                        break;
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } else {
                return passwordInput;
            }
        }
    }


    public static String inputEmail() {
        while (true) {
            String emailInput = stringScanner("Please enter email: ");

            return emailInput;
        }
    }


    public static void writeUserdataToFile() {
        User testuser = CreateUserAccount();
        System.out.printf("Username: %s, Password: %s, email: %s, phone: %s",
                testuser.username, testuser.password, testuser.email, testuser.phone);
    }


    public static String inputPhoneNumber() {
        while (true) {
            String phoneInput = stringScanner("Please enter phone number: ");

            return phoneInput;
        }
    }

    public static User CreateUserAccount() {
        String username = inputUsername();
        String password = inputPassword();
        String email = inputEmail();
        String phone = inputPhoneNumber();

        return new User(
                username,
                password,
                email,
                phone
        );
    }

    public static void main(String[] args) {
        writeUserdataToFile();
    }
}