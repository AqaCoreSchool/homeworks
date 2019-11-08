package homework.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class runs username validation
 *
 * @author Mykyta Konsevych
 * @version 1.0 08.11.2019
 */

public class RegEx {

    private static boolean nameValidation(String testString) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+\\s[A-Z][a-z]+$");
        Matcher matcher = pattern.matcher(testString);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println("Please enter your firs and last name: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println("Validation passed: " +  nameValidation(userInput));

    }
}
