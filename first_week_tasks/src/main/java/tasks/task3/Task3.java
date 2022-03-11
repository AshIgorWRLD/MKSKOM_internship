package tasks.task3;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import tasks.Task;

import java.io.FileNotFoundException;
import java.util.Random;

@Slf4j
public class Task3 implements Task {

    private static final int FIRST_BORDER = 1000;
    private static final int SECOND_BORDER = 1003;
    private static final int THIRD_BORDER = 1006;

    private void startCounter() throws FileNotFoundException, ClassNotFoundException, InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        int counter = 0;
        while (true) {
            counter += random.nextInt() % 10;
            if (FIRST_BORDER <= counter && SECOND_BORDER > counter) {
                throw new FileNotFoundException();
            } else if (SECOND_BORDER <= counter && THIRD_BORDER > counter) {
                throw new InterruptedException();
            } else if (THIRD_BORDER <= counter) {
                throw new ClassNotFoundException();
            }
        }
    }

    @Override
    public void doTask() {
        try {
            startCounter();
        } catch (FileNotFoundException e) {
            log.error("FILE NOT FOUND EXCEPTION", e);
        } catch (ClassNotFoundException e) {
            log.error("CLASS NOT FOUND EXCEPTION", e);
        } catch (InterruptedException e) {
            log.error("INTERRUPTED EXCEPTION", e);
        }
    }
}
