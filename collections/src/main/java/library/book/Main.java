package library.book;


import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {

      WorksWithBooks analysisOfBooks = new WorksWithBooks();
      List<Book> catalog = new LinkedList(  );
        Map <Integer,Book>uniqueCatalog = new HashMap<>(  );
        List <Book>olderestBooksByGenres = new LinkedList(  );

        GenreOfBooks genres[] = GenreOfBooks.values();

      /* analysisOfBooks.getAvailablebooks( catalog );
        System.out.println();
       analysisOfBooks.filteredByAuthor( catalog,"George Orwell" );
        System.out.println();
       analysisOfBooks.sortAllbooksAlphabeticaly( catalog,true );
        System.out.println();
        analysisOfBooks.sortAllbooksAlphabeticaly( catalog,false );*/
      //  System.out.println("Check if at least one book in your list corresponds to some search criteria ");
//        analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.YEAR);
//        System.out.println("Check if all books correspond to some search criteria (e.g. genre is a ‘Novel’)");
//        analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.GENRE );
        /*System.out.println("Check if none of the movies from list corresponds to some search criteria (e.g. author is T.Shevchenko)");
        analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.AUTHOR );
        // get olderest books and sort
        System.out.println("Traverse book list, collect the oldest book names per each genre, sort them alphabetically and print them to console using comma as a delimiter\n");
*/
//        GenreOfBooks genres[] = GenreOfBooks.values();
//
//        List <Book>olderestBooksByGenres = new LinkedList(  );
//        olderestBooksByGenres = analysisOfBooks.getBooksByGenres( catalog,olderestBooksByGenres,genres );
//        System.out.println("Olderest");
//        analysisOfBooks.getAvailablebooks( olderestBooksByGenres );
        Scanner numberOFAction = new Scanner( System.in );
        Scanner nameOfAuthor = new Scanner( System.in );

        System.out.println("Enter size");
        int size = numberOFAction.nextInt();
        try {
            if (size != 0) {
                analysisOfBooks.createListOfBooks( catalog, size ,GenreOfBooks.values());
            } else {
                throw new WorkWithBookException( "size cannot be 0" );
            }
        }
        catch (WorkWithBookException ex){
            ex.printStackTrace();

        }
        while (true){
            System.out.println("1) Retrieve list of available books \n"+
                    "2) retrieve list of available books filtered by \n"+
                    "3) sort all books alphabetically\n"+
                    "4) check if at least one book in your list corresponds to some search criteria \n"+
                    "5) Check if all books correspond to some search criteria (e.g. genre is a ‘Novel \n"+
                    "6) Check if none of the movies from list corresponds to some search criteria \n"+
                    "7) Traverse book list, collect the oldest book names per each genre, sort them alphabetically and print them to console using comma as a delimiter\n"+
                    "8) Create map to hold key-value pairs\n");
            System.out.println("Enter number 1-8");
            switch (numberOFAction.nextInt()){
                        case 1:
                            analysisOfBooks.getAvailablebooks( catalog );
                            break;
                        case 2:
                            System.out.println("Enter author");
                            String author = nameOfAuthor.nextLine();
                            String rule = "(" + "\\p{Upper}(\\p{Lower}+\\s?)" + "){2,3}";
                               try {
                                   if (author.matches( rule )) {
                                       analysisOfBooks.filteredByAuthor( catalog, author );
                                   } else {
                                       throw new WorkWithBookException( "Incorrect name of author" );
                                   }
                               }
                               catch (WorkWithBookException exp){
                                   exp.printStackTrace();
                               }
                             break;
                        case 3:
                            analysisOfBooks.sortAllbooksAlphabeticaly( catalog );
                             break;
                        case 4:
                            analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.YEAR);

                             break;
                        case 5:
                            analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.GENRE);

                             break;
                        case 6:
                            analysisOfBooks.checkByBooks( catalog,VereficatiionCriteria.AUTHOR );
                             break;
                        case 7:
                            analysisOfBooks.getBooksOlderestByGenres(catalog,olderestBooksByGenres, genres);
                            olderestBooksByGenres.clear();
                             break;
                        case 8:
                            analysisOfBooks.getUniqueMap( catalog,uniqueCatalog );
                            break;
                        default:
                            System.out.println("Try again\n");
            }
                }





    }
}
