package com.company.hw;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        User olyaUser = new User();

        Scanner myInput = new Scanner(System.in);
        System.out.println("Here are 1-8 commands. \tEnter 0 to EXIT \nEnter Number of task:");
        while (myInput.hasNextInt()) {
            int task = myInput.nextInt();
            {
                switch (task) {
                    case 1:
                        System.out.println("[1] All available: ");
                        olyaUser.printAvailableBooks();
                        break;
                    case 2:
                        System.out.print("[2] Enter author's Surname: Shevchenko or Bronte ->");
                        Scanner input = new Scanner(System.in);
                        String inpAuthor = input.next();
                        olyaUser.filterBooksByAuthor(inpAuthor);
                        break;
                    case 3:
                        System.out.println("[3] All books alphabetically by Book Name: ");
                        olyaUser.sortAlpabetically();
                        break;
                    case 4:
                        System.out.print("[4] Enter the year->");
                        Scanner input4 = new Scanner(System.in);
                        int inpYear = input4.nextInt();
                        olyaUser.findEarlierBooks(inpYear);
                        break;
                    case 5:
                        System.out.print("[5] Enter Genre ->");
                        Scanner input5 = new Scanner(System.in);
                        String inpGenre = input5.next();
                        olyaUser.checkGenre(inpGenre);
                        break;

                    case 6:
                        System.out.print("[6] Enter Author ->");
                        Scanner input6 = new Scanner(System.in);
                        String inpString = input6.next();
                        System.out.println(olyaUser.hasNoneBooksByAuthor(inpString));
                        break;
                    case 7:
                        System.out.println("[7] Complicated Task:");
                        olyaUser.printFilteredBooksByGenre();
                        break;
                    case 8:
                        System.out.println("[8] Map:");
                        olyaUser.useMap();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Woops. Hyston we have a problems. Try again with menu");
                        System.out.println("Enter 0 to EXIT");
                }
            }
        }
    }
}
