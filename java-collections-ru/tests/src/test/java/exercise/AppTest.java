package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result = App.take(numbers, 2);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(expected).isEqualTo(result); // => [1, 2]


        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = App.take(numbers2, 8);
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        assertThat(expected2).isEqualTo(result2); // => [7, 3, 10]
        // END
    }
}
