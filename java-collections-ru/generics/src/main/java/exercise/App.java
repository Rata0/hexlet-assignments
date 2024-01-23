package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();

        Map<String, String> book1 = Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611");
        Map<String, String> book2 = Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111");
        Map<String, String> book3 = Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611");
        Map<String, String> book4 = Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222");
        Map<String, String> book5 = Map.of("title", "Still foooing", "author", "FooBar", "year", "3333");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = Map.of("author", "Shakespeare", "year", "1611");

        List<Map<String, String>> result = findWhere(books, where);

        System.out.println(result);
    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            if (isMatch(book, where)) {
                result.add(book);
            }
        }

        return result;
    }

    public static boolean isMatch(Map<String, String> book, Map<String, String> where) {
        var entries = where.entrySet();
        for (var entry: entries) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (!book.containsKey(key) || !book.containsValue(value)) {
                return false;
            }

        }

        return true;
    }
}

//END
