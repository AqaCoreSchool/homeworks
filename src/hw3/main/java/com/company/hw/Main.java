package com.company.hw;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        User olya = new User();
        boolean shouldBreak = false;

        Scanner myInput = new Scanner(System.in);
        System.out.println("Here are 1-8 commands. \tEnter any word to EXIT \nEnter Number of task:");
        while (myInput.hasNextInt()) {
            int task = myInput.nextInt();
            {
                switch (task) {
                    case 1:
                        System.out.println("[1] All available: ");
                        olya.getAvailableBooks();
                        break;
                    case 2:
                        System.out.print("[2] Enter author's Surname: Shevchenko or Bronte ->");
                        Scanner input = new Scanner(System.in);//повернути boolean
                        String inpAuthor = input.next();
                        olya.getFilteredByAuthor(inpAuthor);
                        break;
                    case 3:
                        System.out.println("[3] All books alphabetically by Book Name: ");
                        olya.sortAlpabetically();
                        break;
                    case 4:
                        System.out.print("[4] Enter the year->");
                        Scanner input4 = new Scanner(System.in);
                        int inpYear = input4.nextInt();
                        System.out.println(olya.hasEarlierBooks(inpYear));
                        break;
                    case 5:
                        System.out.print("[5] Enter Genre ->");
                        Scanner input5 = new Scanner(System.in);
                        String inpGenre = input5.next();
                        System.out.println(olya.checkGenre(inpGenre));
                        break;

                    case 6:
                        System.out.print("[6] Enter Author ->");
                        Scanner input6 = new Scanner(System.in);
                        String inpString = input6.next();
                        System.out.println(olya.hasNotBooksByAuthor(inpString));
                        break;
                    case 7:
                        System.out.println("[7] Complicated Task:");
                        olya.filteredByGenre();
                        break;
                    case 8:
                        System.out.println("[8] Map:");
                        olya.useMap();
                        break;

                    default:
                        System.out.println("Woops. Hyston we have a problems. Try again with menu");
                        System.out.println("Enter Word to EXIT");
                }
                if (shouldBreak) break;
            }
        }
    }
}

