package Controller;

import java.util.HashMap;

public class wordList {
    private static HashMap<Integer, String[]> wordList = new HashMap<>();

    static {
        wordList.put(1, new String[] {"one", "un"});
        wordList.put(2, new String[] {"two", "deux"});
        wordList.put(3, new String[] {"three", "trois"});
        wordList.put(4, new String[] {"four", "quatre"});
        wordList.put(5, new String[] {"five", "cinq"});
        wordList.put(6, new String[] {"six", "six"});
        wordList.put(7, new String[] {"seven", "sept"});
        wordList.put(8, new String[] {"eight", "huit"});
        wordList.put(9, new String[] {"nine", "neuf"});
        wordList.put(10, new String[] {"seven", "sept"});
        wordList.put(11, new String[] {"eight", "huit"});
        wordList.put(12, new String[] {"nine", "neuf"});
    }

    public static String getWord(int value, String language) {
        if (wordList.containsKey(value)) {
            if (language.equals("English")) {
                return wordList.get(value)[0];
            } else if (language.equals("French")) {
                return wordList.get(value)[1];
            }
        }
        return "";
    }
}
