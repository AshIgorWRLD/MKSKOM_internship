package task1;

import task1.human.CallableHuman;
import task1.human.Gender;
import task1.human.Human;
import task1.sorts.MyInsertionSort;
import task1.sorts.MyQuickSort;
import task1.sorts.Sortable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {

    private final Sortable<Human> sortable1;
    private final Sortable<Human> sortable2;
    private final Sortable<Human> sortable3;
    private final Comparator<Human> humanComparator;

    public Task1() {
        humanComparator = generateHumanComparator();
        sortable1 = generateStreamSortable();
        sortable2 = generateQuickSortSortable();
        sortable3 = generateInsertionSortSortable();
    }

    private Sortable<Human> generateStreamSortable() {
        return x -> {
            x.stream().
                    sorted(humanComparator).
                    forEach(Human::print);
        };
    }

    private Human findPerson(List<Human> humanList, String name, Gender gender, int age) {
        return humanList.stream().
                filter(x -> x.getName().equals(name) && x.getGender().equals(gender) &&
                        x.getAge() == age).
                findFirst().
                orElse(new Human(0, Gender.MALE, "NO SUCH PERSON"));
    }

    private Sortable<Human> generateQuickSortSortable() {
        return x -> {
            Human[] humanArray = x.toArray(Human[]::new);
            MyQuickSort.qSort(humanArray, 0, humanArray.length - 1, humanComparator);
            printHumanArray(humanArray);
        };
    }

    private Sortable<Human> generateInsertionSortSortable() {
        return x -> {
            Human[] humanArray = x.toArray(Human[]::new);
            MyInsertionSort.insertionSort(humanArray, humanComparator);
            printHumanArray(humanArray);
        };
    }

    private void printHumanArray(Human[] humanArray) {
        for (Human human : humanArray) {
            human.print();
        }
    }

    private Comparator<Human> generateHumanComparator() {
        return (p1, p2) -> {
            if (p1.getGender().equals(Gender.MALE) && p2.getGender().equals(Gender.MALE)) {
                if (p1.getAge() == p2.getAge()) {
                    return p1.getName().compareTo(p2.getName());
                }
                return p1.getAge() - p2.getAge();
            } else if (p1.getGender().equals(Gender.MALE)) {
                return -1;
            } else if (p2.getGender().equals(Gender.MALE)) {
                return 1;
            } else {
                if (p1.getAge() == p2.getAge()) {
                    return p1.getName().compareTo(p2.getName());
                }
                return p1.getAge() - p2.getAge();
            }
        };
    }

    private List<Human> createHumanList() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(40, Gender.MALE, "Kanye"));
        humanList.add(new Human(37, Gender.MALE, "Drake"));
        humanList.add(new Human(42, Gender.FEMALE, "Kim"));
        humanList.add(new Human(21, Gender.FEMALE, "Elena"));
        humanList.add(new Human(20, Gender.MALE, "Uri"));
        humanList.add(new Human(99, Gender.FEMALE, "Elizabeth"));
        humanList.add(new Human(55, Gender.MALE, "Jack"));
        humanList.add(new Human(40, Gender.MALE, "John"));
        humanList.add(new Human(21, Gender.FEMALE, "Tanya"));
        humanList.add(new Human(33, Gender.FEMALE, "Alyona"));
        humanList.add(new Human(32, Gender.FEMALE, "Lisa"));
        humanList.add(new Human(35, Gender.MALE, "Leha"));
        humanList.add(new Human(29, Gender.MALE, "Sanyochek"));
        humanList.add(new Human(78, Gender.FEMALE, "Ann"));
        humanList.add(new Human(67, Gender.MALE, "Dmitry"));
        humanList.add(new Human(11, Gender.FEMALE, "Eseniya"));
        humanList.add(new Human(78, Gender.MALE, "Ivan"));
        return humanList;
    }

    private List<CallableHuman> createCallableHumanList() {
        List<CallableHuman> humanList = new ArrayList<>();
        humanList.add(new CallableHuman(40, Gender.MALE, "Kanye",
                "89132223453"));
        humanList.add(new CallableHuman(37, Gender.MALE, "Drake", "89132223450",
                "89132223452", "89132223451"));
        humanList.add(new CallableHuman(42, Gender.FEMALE, "Kim"));
        humanList.add(new CallableHuman(21, Gender.FEMALE, "Elena",
                "89132223433", "89132233453"));
        humanList.add(new CallableHuman(20, Gender.MALE, "Uri", "89132223423"));
        return humanList;
    }

    private void sort1(List<Human> humanList) {
        long startTime = System.currentTimeMillis();
        sortable1.sort(humanList);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------------------\nTime for SORT1: " +
                (endTime - startTime) + " ms\n-------------------------------");
    }

    private void sort2(List<Human> humanList) {
        long startTime = System.currentTimeMillis();
        sortable2.sort(humanList);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------------------\nTime for SORT2: " +
                (endTime - startTime) + " ms\n-------------------------------");
    }

    private void sort3(List<Human> humanList) {
        long startTime = System.currentTimeMillis();
        sortable3.sort(humanList);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------------------\nTime for SORT3: " +
                (endTime - startTime) + " ms\n-------------------------------");
    }

    private void testCallableHuman(){
        List<CallableHuman> callableHumanList = createCallableHumanList();
        System.out.println("----------------------------------\nCALLABLE HUMAN LIST 1 ITERATION\n");
        callableHumanList.forEach(CallableHuman::print);
        System.out.println("----------------------------------\nPHONE LIST 1 ITERATION\n");
        CallableHuman.getAllPhonesFromList(callableHumanList).forEach(System.out::print);
        CallableHuman tmpHuman = callableHumanList.get(0);
        tmpHuman.addPhoneNumber("89152223453");
        callableHumanList.add(tmpHuman);
        System.out.println("----------------------------------\nCALLABLE HUMAN LIST 2 ITERATION\n");
        callableHumanList.forEach(CallableHuman::print);
        System.out.println("----------------------------------\nPHONE LIST 2 ITERATION\n");
        CallableHuman.getAllPhonesFromList(callableHumanList).forEach(System.out::print);
        tmpHuman = callableHumanList.get(0);
        tmpHuman.addPhoneNumber("89152223453");
        callableHumanList.add(tmpHuman);
        System.out.println("----------------------------------\nCALLABLE HUMAN LIST 3 ITERATION\n");
        callableHumanList.forEach(CallableHuman::print);
        System.out.println("----------------------------------\nPHONE LIST 3 ITERATION\n");
        CallableHuman.getAllPhonesFromList(callableHumanList).forEach(System.out::print);
        tmpHuman = callableHumanList.get(0);
        tmpHuman.deletePhoneNumber("89152223453");
        callableHumanList.add(tmpHuman);
        System.out.println("----------------------------------\nCALLABLE HUMAN LIST 4 ITERATION\n");
        callableHumanList.forEach(CallableHuman::print);
        System.out.println("----------------------------------\nPHONE LIST 4 ITERATION\n");
        CallableHuman.getAllPhonesFromList(callableHumanList).forEach(System.out::print);

    }

    public void doTask() {
        System.out.println("""

                -----------------------------------------------
                ----------------------1.1----------------------
                -----------------------------------------------
                """);
        sort1(createHumanList());
        System.out.println("----------------------");
        sort2(createHumanList());
        System.out.println("----------------------");
        sort3(createHumanList());
        System.out.println("""

                -----------------------------------------------
                ----------------------1.2----------------------
                -----------------------------------------------
                """);
        findPerson(createHumanList(), "hjjhj", Gender.MALE, 90).print();
        findPerson(createHumanList(), "Tanya", Gender.FEMALE, 21).print();
        System.out.println("""

                -----------------------------------------------
                ----------------------1.3----------------------
                -----------------------------------------------
                """);
        testCallableHuman();
    }
}
