package tasks.task1;

import lombok.extern.slf4j.Slf4j;
import tasks.Task;

import java.util.Random;

@Slf4j
public class Task1 implements Task {

    private final int arrayLength;

    public Task1(int arrayLength){
        this.arrayLength = arrayLength;
    }

    private int[] initArray(){
        if(arrayLength <= 0){
            return null;
        }
        int[] array = new int[arrayLength];
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt();
        }
        return array;
    }

    public void doTask(){
        int[] array = initArray();
        if(null == array){

        }

    }
}
