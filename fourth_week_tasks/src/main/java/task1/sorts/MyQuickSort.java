package task1.sorts;

import task1.human.Human;

import java.util.Comparator;

public class MyQuickSort {

    public static void qSort(Human[] array, int first, int last, Comparator<Human> humanComparator){
        if(first < last){
            int left = first;
            int right = last;
            Human middle = array[(left + right) / 2];
            while (left <= right){
                while (humanComparator.compare(array[left], middle) < 0){
                    left++;
                }
                while (humanComparator.compare(array[right], middle) > 0){
                    right--;
                }
                if(left <= right){
                    Human tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                    left++;
                    right--;
                }
            }
            qSort(array, first, right, humanComparator);
            qSort(array, left, last, humanComparator);
        }
    }
}
