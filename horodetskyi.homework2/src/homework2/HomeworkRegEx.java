package homework2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HomeworkRegEx {

    public static void main(String[] args) {

        System.out.println("enter first and last name : ");

        String value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+\\s{1}+[A-Z][a-z]+$");

        System.out.println(Pattern.matches(String.valueOf(pattern), value));

    }

}
