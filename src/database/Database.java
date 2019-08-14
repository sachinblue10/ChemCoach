package database;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class created by Sach
 */

public class Database {

    private static final String userPath = "/Users/Krish/IdeaProjects/ChemCoach/src/database/usernames";
    private static final String passPath = "/Users/Krish/IdeaProjects/ChemCoach/src/database/passwords";
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();

    public static ArrayList<String> getUsernames() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(userPath));
        while (scanner.hasNext()) {
            usernames.add(scanner.nextLine());
        }
        return usernames;
    }

    public static ArrayList<String> getPasswords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(passPath));
        while (scanner.hasNext()) {
            passwords.add(scanner.nextLine());
        }
        return passwords;
    }

    public static void addUsername(String username) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(userPath, true));
        writer.append("\n").append(username);
        writer.close();
    }

    public static void addPassword(String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(passPath, true));
        writer.append("\n").append(password);
        writer.close();
    }

}
