package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testSetAndGet() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");

        FileKV storage = new FileKV(filepath.toString(), initialData);

        storage.set("key3", "value3");
        assertEquals("value3", storage.get("key3", "default"));

        storage.set("key2", "updatedValue");
        assertEquals("updatedValue", storage.get("key2", "default"));
    }

    @Test
    void testUnset() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");

        FileKV storage = new FileKV(filepath.toString(), initialData);

        storage.unset("key1");
        assertNull(storage.get("key1", null));
    }

    private void assertNull(String key1) {
    }

    @Test
    void testToMap() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");

        FileKV storage = new FileKV(filepath.toString(), initialData);

        Map<String, String> dataMap = storage.toMap();
        assertEquals(2, dataMap.size());
        assertEquals("value1", dataMap.get("key1"));
        assertEquals("value2", dataMap.get("key2"));
    }
    // END
}
