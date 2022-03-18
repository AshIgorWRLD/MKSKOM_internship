package tasks.task1;

import lombok.extern.slf4j.Slf4j;
import tasks.Task;

import java.util.Random;

@Slf4j
public class Task1 implements Task {

    private final int arrayLength;

    public Task1(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    private int[] initArray() {
        if (arrayLength <= 0) {
            return null;
        }
        int[] array = new int[arrayLength];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt() % 1000;
        }
        return array;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void findInfo(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];
        int sum = array[0];
        for (int i = 1; i < arrayLength; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
            if (array[i] < minValue) {
                minValue = array[i];
            }
            sum += array[i];
        }
        System.out.println("Max value " + maxValue + "\nMin value " + minValue +
                "\nMedium value " + (double) sum / arrayLength);
        bubbleSort(array);
        printArray(array);
    }

    private void bubbleSort(int[] array) {
<<<<<<< HEAD
=======


>>>>>>> 4ff6b39497ac593223c353f3284c9b1cba253fd5
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = true;
            for (int i = 0; i < array.length - 1; i++) {
                isEnd = isEnd(array, isEnd, i);
            }
        }
    }

    private boolean isEnd(int[] array, boolean isEnd, int i) {
        if (array[i] > array[i + 1]) {
            isEnd = false;
            int tmp = array[i + 1];
            array[i + 1] = array[i];
            array[i] = tmp;
        }
        return isEnd;
    }

    public void doTask() {
        int[] array = initArray();
        if (null == array) {
            log.info("WRONG ARRAY LENGTH");
            return;
        }
        printArray(array);
        findInfo(array);
    }
}
