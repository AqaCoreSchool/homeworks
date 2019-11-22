package java8;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;


public class WorksWithBooks {
     List<Book> createListOfBooks(List<Book> catalog, Integer size, GenreOfBooks genreOfBooks[]){
     Book[] books = new Book[size];
     Faker faker = new Faker();
     Random random = new Random(  );

        for (int i = 0; i <size ; i++) {

            books[i] = new Book(faker.book().title(),faker.book().author(),
                    genreOfBooks[random.nextInt(4)].toString(), random.nextInt(2019-2000+1)+2000);
        }

       // replace on 15
        for (int i = 0; i < books.length; i++) {
         catalog.add(  books[i] );
        }
     return catalog;
    }
     List<Book> getAvailablebooks(List <Book> catalog){

       /* Book book;
        for (int i = 0; i <catalog.size() ; i++) {
            book = (Book) catalog.get( i );
            System.out.println(book.getName()+"| "+book.getAuthor()+" "+book.getYear()+" "+book.getGenre()+",");
//        }*/
//     catalog.stream().collect(
//                Collectors.toList(Book::getName, Book::getAuthor, Book::getYear, Book::getGenre);
//        TreeMap<String, String> reversedTreeMap = filmDescription.keySet().stream()
//                .collect(Collectors.toMap(filmDescription::get, i -> i, (a, b) -> b, TreeMap::new));
//        reversedTreeMap.forEach((key, value) -> System.out.print(key + " - " + value + ", "));

catalog.stream().forEach( x-> System.out.println(x.getName()+"| "+
        x.getAuthor()+" "+x.getGenre()+" "+x.getYear()) );



    return catalog;
    }
      List<Book> filteredByAuthor(List <Book> catalog, String author){
        List<Book> listBooks;
//        Collections.sort(catalog, new Comparator<Book>() {
//
//            @Override
//            public int compare(Book o1, Book o2) {
//                return compareTwoArraysOfChar( o1.getName().toCharArray(),o2.getName().toCharArray() )
//                        ? -1 : o1.getName().equals( o2.getName() ) ? 0 : 1;
//            }

        //
//        for (int i = 0; i <catalog.size() ; i++) {
//            book = (Book) catalog.get( i );
//            if(book.getAuthor().equals( author )){
//                listByAuthor.add( (Book) catalog.get( i ) );
//            }
//        }
       listBooks = catalog.stream()
                .filter( x-> author.equals( x.getAuthor() ) )
                .map(x->x)
                .collect(Collectors.toList());

        System.out.println();

      //  });
//        try {
//            if (!listByAuthor.isEmpty()) {
//               // getAvailablebooks( listByAuthor );
//            } else {
//                throw new WorkWithBookException( "Library doesn't have books with this author :" +
//                        author + " , try again" );
//            }
//        }
//        catch (WorkWithBookException exp){
//            exp.printStackTrace();
//        }
        getAvailablebooks( listBooks );
       return listBooks;
    }

    List<Book> sortAllbooksAlphabeticaly(List <Book>catalog){
        List <Book> sortedList;
//                Collections.sort(catalog, new Comparator<Book>() {
//
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getName().compareToIgnoreCase(o2.getName());
//            }
//                });
//
//        getAvailablebooks( catalog );
        sortedList = catalog.stream()
                .sorted( (book1, book2) -> book1.getName().compareTo( book2.getName() ) )
                .map(x->x)
                .collect(Collectors.toList());
        getAvailablebooks( sortedList );
        return sortedList;
    }

    /// ask queeastion
    /// ADD ENUM
    boolean checkByBooks(List<Book> catalog, VereficatiionCriteria criteria){
        Scanner inputValueCriteria = new Scanner( System.in );
        String genre="";
        String author="";
        int year =0;
        switch (criteria.number){
            case 0:
                System.out.println("Enter genre");
                genre = inputValueCriteria.next().toUpperCase();
                break;
            case 1:
                System.out.println("Enter author");
                author = inputValueCriteria.nextLine();
                break;
            case 2:
                System.out.println("Enter year");
                year = inputValueCriteria.nextInt();
                break;

        }
        Book book;
        for (int i = 0; i <catalog.size() ; i++) {
            book =  catalog.get( i );
         if(criteria.number==0){
             if(!book.getGenre().equals( genre )){
                 System.out.println(false);
                 return false;
             }

         }
         else if(criteria.number==1){
             if(book.getAuthor().equals( author )){
                 System.out.println(false);
                 return false;
             }
         }
         else{

             if(book.getYear()<year){
                 System.out.println(true);
                 return true;
             }
         }
        }
        if(criteria.number==2) {
            System.out.println( false );
            return false;
        }
        else{
            System.out.println( true );
            return true;
        }

    }

//    public boolean compareTwoArraysOfChar (char a1[],char a2[], boolean order){
//        int sumArrays1=0;
//        int sumArrays2=0;
//
//        for (int i = 0; i < a1.length; i++) {
//          sumArrays1 += a1[i];
//        }
//        for (int i = 0; i <a2.length ; i++) {
//          sumArrays2 += a2[i];
//        }
//        if(order)
//        return sumArrays1 > sumArrays2;
//
//        else
//        return sumArrays1 < sumArrays2;
//    }
    public List getBooksOlderestByGenres(List <Book> catalog, List<Book> olderestBookByGenre, GenreOfBooks[]genres){

        List <Book> olderest = new LinkedList<>(  ) ;
        //Book book;
//        for (int i = 0; i < genres.length ; i++) {
//            List<Book> temp = new LinkedList(  );
//            for (int j = 0; j <catalog.size() ; j++) {
//            book = (Book) catalog.get( j );
//                if(book.getGenre().equals( genres[i].toString() ))
//                temp.add( (Book) catalog.get( j ) );
//            }
//            Collections.sort(temp, new Comparator<Book>() {
//
//                @Override
//                public int compare(Book o1, Book o2) {
//                    return o1.getYear() < o2.getYear()
//                            ? -1 : o1.getYear()==o2.getYear()? 0 : 1;
//                }
//            });
//            if(temp.size()!=0) {
//                olderestBookByGenre.add( temp.get( 0 ) );
//
//            }
//        }

List <Book>temp = new LinkedList(  );
        for (int i = 0; i < genres.length ; i++) {
            final String genre =genres[i].toString();
           try {
               temp = catalog.stream()
                       .filter( x -> x.getGenre().equals( genre ) )
                       .filter( x -> x.getYear() == catalog.stream()
                               .filter( y -> y.getGenre().equals( genre ) )
                               .mapToInt( y -> y.getYear() )
                               .min()
                               .orElseThrow( NoSuchElementException::new ) )
                       .map( x -> x )
                       .collect( Collectors.toList() );
           }
           catch (NoSuchElementException e){
               System.out.println("genre isn't exist");
           }
     if(!temp.isEmpty())
                olderest.add( temp.get( 0 ) );
           temp.clear();
        }







sortAllbooksAlphabeticaly( olderest );

     return olderest;
    }

     Map<Integer,Book> getUniqueMap(List<Book> catalog, Map<Integer,Book> uniqueCatalog ){
      Book book;
        for (int i = 0; i < catalog.size() ; i++) {
            book = catalog.get( i );
            uniqueCatalog.put( book.hashCode(), book );

        }
      return uniqueCatalog;
    }
}
