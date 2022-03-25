import tasks.task1.Task1;
import tasks.task2.Task2;
import tasks.task3.Task3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*Task1 task1 = new Task1();
        task1.doTask(createMap(new String[]{"kanye", "drake", "mom"}),
                createMap(new String[]{"kanye", "jay z", "dad"}));

        Task2 task2 = new Task2();
        task2.doTask(createIntArray(5));

        Task3 task3 = new Task3();

       task3.doTask();
         */
        String string = null;
        System.out.println(Optional.ofNullable(string).orElse("asa"));

    }

    private static Integer[] createIntArray(int length){
        Random random = new Random();
        Integer[] array = new Integer[length];
        for(int i = 0; i < length; i++){
            array[i] = random.nextInt()%100;
        }
        return array;
    }

    private static Map<String, Integer> createMap(String[] inputValues) {
        Random random = new Random(System.currentTimeMillis());
        List<String> list = Arrays.stream(inputValues).toList();
        return list.stream().collect(Collectors.toMap(v -> v, x -> random.nextInt() % 100));
    }
}
