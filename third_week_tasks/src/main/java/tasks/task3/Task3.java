package tasks.task3;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Task3 {

    private final Random random = new Random();

    private int randomNumber() {
        return random.nextInt() % 100;
    }

    private void printIntList(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder().append("\nLIST:\n");
        for (int i : list) {
            stringBuilder.append(i).append(";");
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    private List<Integer> createListOfInts(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(randomNumber());
        }
        printIntList(list);
        return list;
    }

    private int findFirstAbove50Element(List<Integer> list) {
        Optional<Integer> rightElement = list.stream().filter(x -> (x > 50)).findFirst();
        Integer value = 0;
        try {
            value = rightElement.orElseThrow(() -> new RuntimeException("NO SUCH ELEMENT"));
        } catch (RuntimeException e) {
            log.error("NO ELEMENT > 50", e);
        }
        System.out.println("FIRST ELEMENT ABOVE 50: " + value);
        return value;
    }

    private List<Integer> findAllAbove50Elements(List<Integer> list) {
        List<Integer> rightList = list.stream().filter(x -> (x > 50)).sorted().toList();
        if (null != rightList) {
            System.out.print("\nALL ELEMENTS ABOVE 50: ");
            printIntList(rightList);
        }
        return rightList;
    }


    private double countAverageValue(List<Integer> list) {
        return (double) (list.stream().mapToInt(x -> x).sum()) / list.size();
    }

    private void x2(Integer number) {
        number *= 2;
    }

    private double x2Sum(List<Integer> list) {
        return list.stream().peek(this::x2).mapToInt(x -> x).sum();
    }

    private int find77NumberWithException(List<Integer> list) {
        Optional<Integer> element77 = list.stream().filter(x -> (x == 77)).findFirst();
        Integer value = 0;
        try {
            value = element77.orElseThrow(() -> new RuntimeException("No77ElementException"));
        } catch (RuntimeException e) {
            log.error("NO ELEMENT == 77", e);
        }
        return value;
    }

    private int find77NumberWithZero(List<Integer> list) {
        Optional<Integer> element77 = list.stream().filter(x -> (x == 77)).findFirst();
        return element77.orElse(0);
    }

    public void doTask() {
        List<Integer> list = createListOfInts(10);
        findFirstAbove50Element(list);
        findAllAbove50Elements(list);
        System.out.println(countAverageValue(list));
        System.out.println(x2Sum(list));
        System.out.println(find77NumberWithException(list));
        System.out.println(find77NumberWithZero(list));
    }
}
