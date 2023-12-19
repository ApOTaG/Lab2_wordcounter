package com.example.myapplication;

public class WordCounter {
    public static int getWordsCount(String phrase) {
        String[] words = phrase.trim().split("\\s+");
        return words.length;
    }

    public static int getSymbolsCount(String phrase) {
        return phrase.length();
    }
}
