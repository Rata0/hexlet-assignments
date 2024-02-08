package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        List<Home> sortedApartments = apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .toList();

        List<String> resultListApartments = sortedApartments.stream()
                .limit(n)
                .map(Home::toString)
                .toList();

        return resultListApartments;
    }
}
// END
