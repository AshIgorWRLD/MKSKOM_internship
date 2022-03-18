package tasks.task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Task4 {

    private static final int ARRAY_LENGTH = 1000000;

    private ArrayList<Integer> createArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for(long i = 0; i < ARRAY_LENGTH; i++){
            arrayList.add(random.nextInt()%100);
        }
        return arrayList;
    }

    private void chooseArrayElement(ArrayList<Integer> arrayList){
        Random random = new Random(System.currentTimeMillis());
        long a;
        for(long i = 0; i < ARRAY_LENGTH; i++){
            a = arrayList.get(Math.abs(random.nextInt()%ARRAY_LENGTH));
        }
    }


    private LinkedList<Integer> createLinkedList(){
        LinkedList<Integer> arrayList = new LinkedList<>();
        Random random = new Random(System.currentTimeMillis());
        for(long i = 0; i < ARRAY_LENGTH; i++){
            arrayList.add(random.nextInt()%100);
        }
        return arrayList;
    }

    private void chooseLinkedElement(LinkedList<Integer> arrayList){
        Random random = new Random(System.currentTimeMillis());
        long a;
        for(long i = 0; i < ARRAY_LENGTH; i++){
            a = arrayList.get(Math.abs(random.nextInt()%ARRAY_LENGTH));
        }
    }

    public void doTask(){
        long startTime = System.currentTimeMillis();
        LinkedList<Integer> arrayList = createLinkedList();
        long createTime = System.currentTimeMillis();
        chooseLinkedElement(arrayList);
        long chooseTime = System.currentTimeMillis();
        System.out.println("CREATE TIME: " + (createTime - startTime));
        System.out.println("CHOOSE TIME: " + (chooseTime - createTime));
        System.out.println("ALL WORK TIME: " + (chooseTime - startTime));
    }
}
