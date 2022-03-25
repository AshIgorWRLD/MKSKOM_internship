package task1.sorts;

import task1.human.Human;

import java.util.Comparator;

public class MyInsertionSort {

    public static void insertionSort(Human[] array, Comparator<Human> humanComparator){
        for (int i = 1; i < array.length; i++) {
            Human tmp = array[i];
            int j = i - 1;
            while(j >= 0 && humanComparator.compare(tmp, array[j]) < 0) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }
    }
}