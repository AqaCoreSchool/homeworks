package com.rybka.homework1;

public class FullNameChecker {

    public static void main(String[] args) {
        System.out.printf("Case with '%s'%14s%n", "Andrii Rybka", checkFullName("Andrii Rybka")); // true
        System.out.printf("Case with '%s'%15s%n", "andrii rybka", checkFullName("andrii rybka")); // false
        System.out.printf("Case with '%s'%15s%n", "Andrii rybka", checkFullName("Andrii rybka")); // false
        System.out.printf("Case with '%s'%15s%n", "andrii Rybka", checkFullName("andrii Rybka")); // false
        System.out.printf("Case with '%s'%15s%n", "ANdrii Rybka", checkFullName("ANdrii Rybka")); // false
        System.out.printf("Case with '%s'%15s%n", "Andrii RyBka", checkFullName("Andrii RyBka")); // false
        System.out.printf("Case with '%s'%10s%n", "Andrii      Rybka", checkFullName("Andrii      Rybka")); // false
    }

    private static boolean checkFullName(String fullName){
        return fullName.matches("([A-Z][a-z]+)\\s([A-Z][a-z]+)");
    }
}
