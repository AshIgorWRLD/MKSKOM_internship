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
        //list.add(77);
        printIntList(list);
        return list;
    }

    private int findFirstAbove50Element(List<Integer> list) {
        Optional<Integer> rightElement = list.stream().filter(x -> (x > 50)).findFirst();
        Integer value = 0;

        value = rightElement.orElseThrow(() -> {
            log.error("NO ELEMENT > 50");
            return new RuntimeException("NO SUCH ELEMENT");
        });

        System.out.println("FIRST ELEMENT ABOVE 50: " + value);
        return value;
    }


    private List<Integer> findAllAbove50Elements(List<Integer> list) {
        return list.stream()
                .filter(x -> (x > 50))
                .sorted()
                .peek(System.out::println).toList();
    }


    private double countAverageValue(List<Integer> list) {
        return list.stream()
                .reduce(Integer::sum)
                .map(result->(double)result/list.size())
                .orElse(0.0);
    }

    private double x2Sum(List<Integer> list) {
        return list.stream()
                .map(x->x*2)
                .mapToInt(x -> x)
                .sum();
    }

    private int find77NumberWithException(List<Integer> list) {
        Optional<Integer> element77 = list.stream()
                        .filter(x -> (x == 77))
                        .findFirst();
        Integer value = 0;

        value = element77.orElseThrow(() -> {
            log.error("NO ELEMENT == 77");
            return new RuntimeException("No77ElementException");
        });

        return value;
    }

    private int find77NumberWithZero(List<Integer> list) {
        return list.stream()
                .filter(x -> (x == 77))
                .findFirst()
                .orElse(0);
    }

    public void doTask() {
        List<Integer> list = createListOfInts(3);

        /*try {
            findFirstAbove50Element(list);
        }catch (RuntimeException ignored){}

         */
        //findAllAbove50Elements(list);
        //System.out.println(countAverageValue(list));
        System.out.println(x2Sum(list));
        //System.out.println(find77NumberWithException(list));
        //System.out.println(find77NumberWithZero(list));
    }
}
