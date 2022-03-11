import tasks.Task;
import tasks.task1.Task1;
import tasks.task2.Task2;
import tasks.task3.Task3;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1(15);
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        //doTask(task1);
        //doTask(task2);
        doTask(task3);
    }

    private static void doTask(Task task) {
        task.doTask();
    }
}
