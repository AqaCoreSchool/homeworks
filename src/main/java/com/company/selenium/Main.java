package com.company.selenium;

public class Main {
    public static void main(String[] args) {
        WebPageTest test= new WebPageTest();
        test.setup();
        test.setTimeIn();
        test.setTimeOut();
        test.checkRecords();
        test.setWeekBack();
    }
}
