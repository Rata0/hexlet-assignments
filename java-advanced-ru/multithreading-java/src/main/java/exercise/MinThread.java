package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
        this.min = numbers[0];
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i < numbers.length; i += 1) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
    }

    public int getMin() {
        return min;
    }
}
// END
