package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread {
    SafetyList safetyList;
    private Random random;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int number = random.nextInt(100);
            safetyList.add(number);
        }
    }
}
// END
