package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        App.scrabble("rkqodlw", "world"); // true
        App.scrabble("ajv", "java"); // false
        App.scrabble("avjafff", "JaVa"); // true
        App.scrabble("", "hexlet"); // false
    }

    public static boolean scrabble(String chars, String word) {
        var lowerChars = chars.toLowerCase();
        var lowerWord = word.toLowerCase();

        List<Character> charList = new ArrayList<>();

        for (var ch : lowerChars.toCharArray()) {
            charList.add(ch);
        }

        for (var ch : lowerWord.toCharArray()) {
            if (charList.contains(ch)) {
                charList.remove(charList.indexOf(ch));
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
