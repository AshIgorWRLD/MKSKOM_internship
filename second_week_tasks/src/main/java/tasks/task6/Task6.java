package tasks.task6;

import java.util.HashMap;
import java.util.Map;

public class Task6 {

    private Map<String, Integer> joinMaps(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> newMap = new HashMap<>();
        newMap.putAll(map1);
        newMap.putAll(map2);
        return newMap;
    }

    public void doTask(Map<String, Integer> map1, Map<String, Integer> map2){
        Map map = joinMaps(map1, map2);
        map.forEach((x, y) -> {
            System.out.println(x + ": " + y);
        });
    }
}
