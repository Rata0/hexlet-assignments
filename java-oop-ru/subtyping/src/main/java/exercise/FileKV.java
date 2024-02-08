package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.data = initialData;
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        saveDataToFile();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveDataToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }

    private void saveDataToFile() {
        String serializedData = Utils.serialize(data);
        Utils.writeFile(filePath, serializedData);
    }
}
// END
