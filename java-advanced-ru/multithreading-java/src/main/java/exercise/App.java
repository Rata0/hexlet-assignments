package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MinThread minThread = new MinThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        LOGGER.log(Level.INFO, "Thread "+ minThread.getName() + " started");
        minThread.start();
        LOGGER.log(Level.INFO, "Thread "+ maxThread.getName() + " started");
        maxThread.start();

        try {
            minThread.join();
            LOGGER.log(Level.INFO, "Thread "+ minThread.getName() + " finished");
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread "+ maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("min", minThread.getMin());
        result.put("max", maxThread.getMax());

        return result;
    }
    // END
}
