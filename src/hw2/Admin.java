package hw2;

class Admin extends Comics {
    private int id;

    Admin(String a, int b, int i) {
        super(a, b);
        id = i;
    }

//    int c_year(){
//        return year;
//    }
//
//    String c_author(){
//        return name_of_book;
//    }

    void staff() {
        System.out.println(String.format("Customer search %s from |%d|. Admin with %d ID help you soon.", getName(), getYear(),id));
    }
}
