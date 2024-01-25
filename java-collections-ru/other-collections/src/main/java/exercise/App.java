package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        for (var key : keys) {
            boolean keyInObject1 = data1.containsKey(key);
            boolean keyInObject2 = data2.containsKey(key);

            if (!keyInObject1 && keyInObject2) {
                result.put(key, "added");
            } else if (keyInObject1 && !keyInObject2) {
                result.put(key, "deleted");
            } else if (keyInObject1 && keyInObject2) {
                var valueInObject1 = data1.get(key);
                var valueInObject2 = data2.get(key);

                if (!valueInObject1.equals(valueInObject2)) {
                    result.put(key, "changed");
                } else {
                    result.put(key, "unchanged");
                }

            }
        }

        return result;
    }
}
//END
