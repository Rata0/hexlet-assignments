package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
        this.max = numbers[0];
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i < numbers.length; i += 1) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
    }

    public int getMax() {
        return max;
    }
}
// END
