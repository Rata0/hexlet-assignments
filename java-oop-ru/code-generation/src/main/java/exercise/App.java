package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


// BEGIN
public class App {
    public static void save(Path pathFile, Car car) throws IOException {
        String json = car.serialize();
        Files.writeString(pathFile, json);
    }

    public static Car extract(Path pathFile) throws IOException {
        String json = Files.readString(pathFile);
        Car instance = Car.unserialize(json);
        return instance;
    }
}
// END
