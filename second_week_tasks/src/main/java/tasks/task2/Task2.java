package tasks.task2;

public class Task2 {
    private static final String NUMBERS_IN_STRING = "\\d+";

    public void doTask(String inputString){

        //System.out.println("IsDigit: " + Character.isDigit(Character.inputString));
        if(inputString.matches(NUMBERS_IN_STRING)){
            System.out.println("ALRIGHT");
        }else{
            System.out.println("YOU NEED NUMBERS!");
        }
    }
}
