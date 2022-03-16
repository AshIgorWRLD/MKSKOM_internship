import tasks.task1.Task1;
import tasks.task2.Task2;
import tasks.task3.Task3;
import tasks.task4.Task4;
import tasks.task5.Task5;
import tasks.task6.Task6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        Task1 task1 = new Task1();
        String[] inputStrings = {"dash12", "dash23", "dash", "dash565"};
        task1.doTask(inputStrings);
        Task2 task2 = new Task2();
        task2.doTask("12341241234");
        Task3 task3 = new Task3();
        Collection<String> collection = createCollection();
        task3.doTask3(collection);
        Task4 task4 = new Task4();
        task4.doTask();
        Task5 task5 = new Task5();
        task5.doTask(createArray());
        Task6 task6 = new Task6();
        task6.doTask(createMap1(), createMap2());
    }

    public static Collection createCollection(){
        Collection<String> collection = new ArrayList<>();
        collection.add("1234");
        collection.add("1234");
        collection.add("ssdd");
        return collection;
    }

    public static String[] createArray(){
        return new String[]{"kanye", "drake", "XXX", "kanye", "eminem", "Jay Z", "2pac", "eminem", "kanye"};
    }

    public static Map<String, Integer> createMap1(){
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("123", 12);
        newMap.put("234", 14);
        newMap.put("345", 13);
        return newMap;
    }

    public static Map<String, Integer> createMap2(){
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("456", 2);
        newMap.put("567", 3);
        newMap.put("678", 4);
        return newMap;
    }

}
