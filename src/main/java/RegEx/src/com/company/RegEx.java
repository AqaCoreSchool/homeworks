package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {

        String text = "olya bilynska, Olya bilynska, olya Bilynska, Olya Bilynska, OLya Bilynska, Olya BiLYnska";
        Pattern pattern = Pattern.compile("(\\b[A-Z][a-z]+)\\s([A-Z][a-z]+\\b)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
