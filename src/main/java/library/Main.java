package library;

import library.common.Common;
import library.common.Constant;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Member member = new Member();
        member.getLibraryWorkingTime();
        Scanner userInput = new Scanner(System.in);
        Scanner innerInput;
        String innerString;
        String lineSeparator = System.lineSeparator();
        List<BookItem> tempList;

        System.out.println("TITLE : AUTHOR : GENRE : RELEASEDATE : LANGUAGE : PAGES");
        System.out.println(lineSeparator);
        member.getAllBooks();
        System.out.println(lineSeparator);

        System.out.println("What do you want to do? Make ur choice by entering a number of operation");
        System.out.println("1. Retrieve list of available books by author.");
        System.out.println("2. Sort all books.");
        System.out.println("3. Check if at least one book in your list corresponds to release year.");
        System.out.println("4. Are all books correspond genre.");
        System.out.println("5. Are none of books corresponds to author.");
        System.out.println("6. Collect the oldest book names per each genre, sort them alphabetically and\n" +
                "print them to console using comma as a delimiter");
        System.out.println("I used Map in 6th task. ");
        System.out.println("INFO: enter 'exit' to finish");

        while (userInput.hasNext()) {
            switch (userInput.next()) {
                case "1":
                    System.out.println("Enter author's name:");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next().toUpperCase();
                    member.getBooksByAuthor(innerString);
                    System.out.println(Constant.OPERATION_FINISHED);
                    break;
                case "2":
                    System.out.println("Sorting books alphabetically...");
                    member.sortBooks(member.getBooksList());
                    System.out.println(Constant.OPERATION_FINISHED);
                    break;
                case "3":
                    System.out.println("Enter the year to check if at least one book in list corresponds it.");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next();
                    System.out.println(member.isOneByYear(Integer.parseInt(innerString)));
                    System.out.println(Constant.OPERATION_FINISHED);
                    break;
                case "4":
                    System.out.println("Enter the genre to check if all books in list correspond it.");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next();
                    System.out.println(member.areAllByGenre(innerString.toUpperCase()));
                    System.out.println(Constant.OPERATION_FINISHED);
                    break;
                case "5":
                    System.out.println("Enter author's name to check if none of the books from list correspond it");
                    innerInput = new Scanner(System.in);
                    innerString = innerInput.next();
                    System.out.println(member.areNoneByAuthor(innerString.toUpperCase()));
                    System.out.println(Constant.OPERATION_FINISHED);
                    break;
                case "6":
                    tempList = member.getOldestBookPerGenre(member.getBooksList());
                    List<BookItem> resultList = tempList.stream()
                            .sorted(Comparator.comparing(BookItem::getTitle))
                            .collect(Collectors.toList());
                    System.out.println(Common.setCommaAsDelimiter(resultList));
                    System.out.println("Operation finished! Please, choose the next one!");
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter the number in range 1-6");
                    break;
            }
        }
    }
}
