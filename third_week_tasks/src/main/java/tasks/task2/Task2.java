package tasks.task2;

import java.util.Random;
import java.util.function.Function;

public class Task2 {

    private final Random random = new Random();

    private int randomNumber() {
        return random.nextInt() % 100;
    }

    private <T> String[] fill(T[] array) {
        Function<T, String> converter = x -> "ELEMENT " + x.toString() + ": " + randomNumber();
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = converter.apply(array[i]);
        }
        return newArray;
    }

    private void printNewArray(String[] array) {
        StringBuilder stringBuilder = new StringBuilder().append("\n");
        for (String s : array) {
            stringBuilder.append(s).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public <T> void doTask(T[] array) {
        printNewArray(fill(array));
    }
}
