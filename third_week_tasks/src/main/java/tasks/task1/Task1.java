package tasks.task1;

import java.util.Map;

public class Task1 {

    private void addNewPair(Map<String, Integer> map, String key, Integer value) {
        map.merge(key, value, Integer::sum);
    }

    private Map<String, Integer> joinMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        /*
        Map<String, String> myMap = Stream.of(map2)
                .peek((x,y)->{
                    addNewPair(map1, x, y);
                });

         */
        map2.forEach((key, value) -> {
            addNewPair(map1, key, value);
        });
        return map1;
    }

    private void printMap(String mapName, Map<?, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nMAP ").append(mapName).append(":\n");
        map.forEach((key, value) -> {
            stringBuilder.append("key: ").append(key).append("; value: ").append(value).append("\n");
        });
        System.out.println(stringBuilder);
    }

    public void doTask(Map<String, Integer> map1, Map<String, Integer> map2) {
        printMap("MAP_1", map1);
        printMap("MAP_2", map2);
        Map<?, ?> newMap = joinMaps(map1, map2);
        printMap("JOINED_MAP", newMap);
    }
}
