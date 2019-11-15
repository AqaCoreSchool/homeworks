package library.book;


import java.util.*;

public class WorksWithBooks {

    public List createListOfBooks(List catalog){
     Book books[] = new Book[5];
     // ADD 10 ITEM
     books[0] = new Book( "The Hunger Game","Suzanne Collins","ADWENTURE", 2008);
     books[1] = new Book( "The Great Gatsby","F. Scott Fitzgerald","HistoricalFiction".toUpperCase(), 1925);
     books[2] = new Book( "The Grapes of Wrath","John Steinbeck","HistoricalFiction".toUpperCase(), 1939);
     books[3] = new Book( "Nineteen Eighty-Four","George Orwell","ScienceFiction".toUpperCase(), 1949);
     books[3] = new Book( "Nineteen Eighty-Four","George Orwell","ScienceFiction".toUpperCase(), 1948);
     books[4] = new Book( "Ulysses","James Joyce","Ireland".toUpperCase(), 1949);

       // replace on 15
        for (int i = 0; i < books.length; i++) {
         catalog.add( books[i] );
        }
     return catalog;
    }
    public List getAvailablebooks(List catalog){
        Book book;
        for (int i = 0; i <catalog.size() ; i++) {
            book = (Book) catalog.get( i );
            System.out.println(book.getName()+" "+book.getYear()+",");
        }
    return catalog;
    }
    public List filteredByAuthor(List catalog, String author){
//        Collections.sort(catalog, new Comparator<Book>() {
//
//            @Override
//            public int compare(Book o1, Book o2) {
//                return compareTwoArraysOfChar( o1.getName().toCharArray(),o2.getName().toCharArray() )
//                        ? -1 : o1.getName().equals( o2.getName() ) ? 0 : 1;
//            }
        List <Book>listByAuthor = new LinkedList<>(  );
        Book book;

        for (int i = 0; i <catalog.size() ; i++) {
            book = (Book) catalog.get( i );
            if(book.getAuthor().equals( author )){
                listByAuthor.add( (Book) catalog.get( i ) );
            }
        }

      //  });
        getAvailablebooks( listByAuthor );
       return listByAuthor;
    }

    public List sortAllbooksAlphabeticaly(List catalog,boolean order){
                Collections.sort(catalog, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                return compareTwoArraysOfChar( o1.getName().toCharArray(),o2.getName().toCharArray(),order )
                        ? -1 : o1.getName().equals( o2.getName() ) ? 0 : 1;
            }
                });

        getAvailablebooks( catalog );
        return catalog;
    }

    /// ask queeastion
    /// ADD ENUM
    public boolean checkByBooks(List catalog, VereficatiionCriteria criteria){
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
            book = (Book) catalog.get( i );
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

    public boolean compareTwoArraysOfChar (char a1[],char a2[], boolean order){
        int sumArrays1=0;
        int sumArrays2=0;

        for (int i = 0; i < a1.length; i++) {
          sumArrays1 += a1[i];
        }
        for (int i = 0; i <a2.length ; i++) {
          sumArrays2 += a2[i];
        }
        if(order)
        return sumArrays1 > sumArrays2;

        else
        return sumArrays1 < sumArrays2;
    }
    public List getBooksOlderestByGenres(List catalog,List olderestBookByGenre, GenreOfBooks []genres){

        Book book;
        for (int i = 0; i < genres.length ; i++) {
            List <Book>temp = new LinkedList(  );
            for (int j = 0; j <catalog.size() ; j++) {
            book = (Book) catalog.get( j );
                if(book.getGenre().equals( genres[i].toString() ))
                temp.add( (Book) catalog.get( j ) );
            }
            Collections.sort(temp, new Comparator<Book>() {

                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getYear() < o2.getYear()
                            ? -1 : o1.getYear()==o2.getYear()? 0 : 1;
                }
            });
            if(temp.size()!=0) {
                olderestBookByGenre.add( temp.get( 0 ) );

            }
        }
        getAvailablebooks( olderestBookByGenre );
     return olderestBookByGenre;
    }

    public Map getUniqueMap(List catalog,Map uniqueCatalog ){
      Book book;
        for (int i = 0; i < catalog.size() ; i++) {
            book =(Book) catalog.get( i );
            uniqueCatalog.put( book.hashCode(), book );

        }
      return uniqueCatalog;
    }
}
