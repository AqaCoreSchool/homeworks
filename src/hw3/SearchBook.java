package hw3;

import java.util.*;


public class SearchBook {
    public static void main(String[] args) {

        List<Library> books = new ArrayList<>();
        books.add(new Novel("N. Pidmogylnuy", "City", 1920, 3, false));
        books.add(new Novel("M. Zerov", "Incognito", 1918, 3, false));
        books.add(new Novel("B. Voronnuy", "Infanta", 1904, 3, true));
        books.add(new Novel("O. Vyshnya", "Bekas", 1900, 5, true));
        books.add(new Novel("E. Bronte", "Wuthering Heights", 1847, 5, true));
        books.add(new Novel("W. Shakespeare", "Gamlet", 1603, 1, false));

        books.add(new Comics("A. Chornuy", "Fly", 2019, true));
        books.add(new Comics("K. Dankovych", "My life", 2017, false));
        books.add(new Comics("H. Nazarov", "Green door of Earth", 2018, false));
        books.add(new Comics("L. Poznyak", "Family", 1992, true));

        books.add(new Encyclopedia("O. Bilyk", "Anatomy", 2012, true));
        books.add(new Encyclopedia("P. Ivanov", "Ukrainian World", 2010, false));
        books.add(new Encyclopedia("M. Orlyk", "The World Of Us", 2017, false));
        books.add(new Encyclopedia("A. Kvadrat", "Geometry", 2001, true));
        books.add(new Encyclopedia("Y. Bachynskyi", "Irredenta", 1920, false));
        books.add(new Encyclopedia("A. Figure", "Universe of Algebra", 2011, true));


        boolean shouldBreak = false;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Here are 1-8 commands. \tEnter any word to EXIT \nEnter Number of task:");
        while (myObj.hasNextInt()) {
            int task = myObj.nextInt();
            {
                switch (task) {
                    case 1:
                        System.out.println("[1] All AVAILABLE:");
                        for (Library element : books) {
                            if (element.available) {
                                System.out.println(element);
                            }
                        }
                        break;

                    case 2:
                        books.sort(new SortByAuthor());
                        System.out.println("[2] Available books by Authors: ");
                        for (Library element : books) {
                            if (element.available) {
                                System.out.println(String.format("<%s> %s", element.getBookName(), element.getAuthor()));
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n[3] ALPHABETICALLY:");
                        books.sort(new SortByBook());
                        for (Library element : books) {
                            System.out.println(element);
                        }
                        break;

                    case 4:
                        System.out.println("\n[4] Enter year of publishing:");
                        Scanner input = new Scanner(System.in);
                        int inpYear = input.nextInt();
                        System.out.println(String.format("Books which published earlier than %s :", inpYear));
                        for (Library next : books) {
                            if (next.getYear() < inpYear) {
                                System.out.println(next);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("[5] ALL NOVEL");
                        for (Library next : books) {
                            if (next.getClass().toString().contains("Novel")) {
                                System.out.println(next);
                            }
                        }
                        break;

                    case 6:
                        System.out.println("[6] None of SHEVCHENKO");
                        for (Library next : books) {
                            if (!next.getAuthor().contains("T. Shevchenko")) {
                                System.out.println("We don't have Shevchenko Poetry( ");
                                break;
                            } else
                                System.out.println(next);
                        }
                        break;

                    case 7:
                        System.out.println("[7] Complicated Task");
                        List<Library> listOfNovel = new ArrayList<>();
                        for (Library element : books) {
                            if (element.getClass().toString().contains("Novel")) {
                                listOfNovel.add(element);
                            }
                        }
                        listOfNovel.sort(new SortByYear());
                        Library oldestNovel = listOfNovel.get(0);

                        List<Library> listOfComics = new ArrayList<>();
                        for (Library element : books) {
                            if (element.getClass().toString().contains("Comics")) {
                                listOfComics.add(element);
                            }
                        }
                        listOfComics.sort(new SortByYear());
                        Library oldestComics = listOfComics.get(0);

                        List<Library> listOfEncyclopedia = new ArrayList<>();
                        for (Library element : books) {
                            if (element.getClass().toString().contains("Encyclopedia")) {
                                listOfEncyclopedia.add(element);
                            }
                        }
                        listOfEncyclopedia.sort(new SortByYear());
                        Library oldestEncyclopedia = listOfEncyclopedia.get(0);

                        List<Library> bookList = new ArrayList<>();
                        bookList.add(oldestNovel);
                        bookList.add(oldestComics);
                        bookList.add(oldestEncyclopedia);

                        bookList.sort(new SortByBook());
                        for (Library library : bookList) {
                            String text = library.getClass().toString().toUpperCase().substring(10);
                            System.out.print(String.format("%s %s, ", library, text));
                            System.out.println();
                        }
                        break;

                    case 8:
                        System.out.println("[8] Example of MAP");
                        Map<Integer, String> bookMap = new HashMap<>();
                            bookMap.put(978966860, books.get(0).getBookName());
                            bookMap.put(978966460, books.get(1).getBookName());
                            bookMap.put(978969652, books.get(2).getBookName());
                            bookMap.put(978945286, books.get(3).getBookName());
                        System.out.println(String.format("ISBN %s : Book Name %s ", bookMap.keySet(),bookMap.values()));
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
