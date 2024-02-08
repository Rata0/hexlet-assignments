package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage dateBase) {
        Map<String, String> dictionary = dateBase.toMap();
        for (Entry<String, String> entry : dictionary.entrySet()) {
            dateBase.unset(entry.getKey());
            dateBase.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
