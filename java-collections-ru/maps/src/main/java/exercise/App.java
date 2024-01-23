package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map<String, Integer> wordsCount = getWordCount(sentence);
        String result = toString(wordsCount);
        System.out.println(result);

        Map<String, Integer> wordsCount2 = getWordCount("");
        String result2 = toString(wordsCount2);
        System.out.println(result2);
    }
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> countWords = new HashMap<>();

        if (text.length() == 0) {
            return countWords;
        }

        var words = text.split(" ");

        for (var word : words) {
            var count = countWords.getOrDefault(word, 0);
            countWords.put(word, count + 1);
        }
        return countWords;
    }

    public static String toString(Map<String, Integer> wordCount) {
        if (wordCount.isEmpty()) {
            return "{}";
        }

        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.append("  ")
                  .append(entry.getKey())
                  .append(": ")
                  .append(entry.getValue())
                  .append("\n");
        }
        result.append("}");
        return result.toString();
    }

}
//END
