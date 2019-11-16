package com.company.hw;

import java.util.*;
import com.company.hw.exceptions.NotAnyBooks;

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
                        Scanner input = new Scanner(System.in);
                        String inpAuthor = input.next();
                        try {
                            olya.getFilteredByAuthor(inpAuthor);
                        }
                        catch(NotAnyBooks x){
                            System.out.println("We don't have any Books by this Author");
                        }
                        break;
                    case 3:
                        System.out.println("[3] All books alphabetically by Book Name: ");
                        olya.sortAlpabetically();
                        break;
                    case 4:
                        System.out.print("[4] Enter the year->");
                        Scanner input4 = new Scanner(System.in);
                        int inpYear = input4.nextInt();
                        try {
                            olya.hasEarlierBooks(inpYear);
                        }
                        catch(NotAnyBooks x){
                            System.out.println("We have books only > 1603");
                        }
                        break;
                    case 5:
                        System.out.print("[5] Enter Genre ->");
                        Scanner input5 = new Scanner(System.in);
                        String inpGenre = input5.next();
                        try {
                            olya.checkGenre(inpGenre);
                        }
                        catch(NotAnyBooks x){
                            System.out.println("We don't have books in this Genre");
                        }
                        break;

                    case 6:
                        System.out.print("[6] Enter Author ->");
                        Scanner input6 = new Scanner(System.in);
                        String inpString = input6.next();
                        System.out.println(olya.hasNotBooksByAuthor(inpString));
                        break;
                    case 7:
                        System.out.println("[7] Complicated Task:");
                        try {
                            olya.filteredByGenre();
                        }
                        catch(NotAnyBooks x){
                            System.out.println("Hey, we don't have any Books now!");
                        }

                        break;
                    case 8:
                        System.out.println("[8] Map:");
                        try {
                            olya.useMap();
                        }
                        catch(NotAnyBooks x){
                            System.out.println("Hey, we don't have any Books now!");
                        }
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

