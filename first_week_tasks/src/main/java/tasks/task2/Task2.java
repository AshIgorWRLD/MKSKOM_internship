package tasks.task2;

import tasks.Task;

public class Task2 implements Task {

    @Override
    public void doTask() {
        Vector[] basis = Vector.getBasis(10);
        Vector.printBasis(basis);
        Vector.calculateBasisScalars(basis);
    }
}
