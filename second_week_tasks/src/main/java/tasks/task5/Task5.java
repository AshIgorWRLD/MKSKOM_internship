package tasks.task5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {

    private <K> Map<K, Integer> arrayToMap(K[] ks){
        List<K> list = Arrays.asList(ks);
        Map<K, Integer> myFrequencyMap = list.stream().
                collect(Collectors.toMap(e -> e, e -> 1,Integer::sum));
        return myFrequencyMap;
    }

    public <K> void doTask(K[] ks){
        Map map = arrayToMap(ks);
        map.forEach((x, y) -> {
            System.out.println(x + ": " + y);
        });
    }
}
