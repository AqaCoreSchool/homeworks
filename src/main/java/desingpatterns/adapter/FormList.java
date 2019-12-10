package desingpatterns.adapter;

public enum FormList {

    FIRST("FirstForm"),
    SECOND("SecondForm");

    private String name;

    FormList(String name) {
    }

    public String getName() {
        return name;
    }


}
