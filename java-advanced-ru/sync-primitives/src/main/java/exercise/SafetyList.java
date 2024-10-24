package exercise;

import java.util.Arrays;

public class SafetyList {
    private int[] array;
    private int size;
    private static final int SIZE_INITIALIZATION = 10;

    // BEGIN
    public SafetyList() {
        this.array = new int[SIZE_INITIALIZATION];
        this.size = 0;
    }

    public synchronized void add(int number) {
        if (size == array.length) {
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }

        array[size] = number;
        size++;
    }

    public synchronized int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " Size " + size);
        }

        return array[index];
    }

    public synchronized int getSize() {
        return size;
    }
    // END
}
