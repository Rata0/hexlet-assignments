package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> dateBase = new HashMap<>();

    public InMemoryKV(Map<String, String> dictionary) {
        this.dateBase.putAll(dictionary);
    }

    @Override
    public void set(String key, String value) {
        this.dateBase.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.dateBase.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.dateBase.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dateBase);
    }
}
// END
