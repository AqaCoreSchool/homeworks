package hw2;

public class SearchBook {
    public static void main(String[] args){
        Novel mary = new Novel("Stefanyk", 1916, 4);
        Novel romantyka = new Novel("Hvylovuy", 1924, 3);
        Comics batman = new Comics("Bob Keyn", 1960);

        Encyclopedia e = new Encyclopedia("Terms of Services", 2018);
        System.out.println("\tWHAT TYPE BOOK IS?");
        mary.typing(true);
        romantyka.typing(true);
        batman.typing(false);
        e.noTyping(true);

        System.out.println("\t\nCOST:");
        mary.pay(100);
        batman.pay(52.2);
        romantyka.pay(125);
        e.pay(532.5);

        System.out.println("\t\nINFORMATION");
        mary.inform();
        batman.inform();
        e.inform();

        System.out.println("\t\nHOW MUCH PAGES in Encyclopedia?");
        e.how_much_pages(2100);

        System.out.println("\t\nWHAT ADMIN NEED TO DO?");
        Admin a1 = new Admin(batman.c_author(), batman.c_year(), 1);
        Admin a8 = new Admin(mary.c_author(), mary.c_year(), 8);
        Admin a4 = new Admin(romantyka.c_author(), romantyka.c_year(), 4);
        Admin a5 = new Admin(e.c_author(), e.c_year(), 5);
        Admin b10 = new Admin("Kostenko", 2019, 10);
        a1.staff();
        a8.staff();
        a4.staff();
        a5.staff();
        b10.staff();
    }
}
