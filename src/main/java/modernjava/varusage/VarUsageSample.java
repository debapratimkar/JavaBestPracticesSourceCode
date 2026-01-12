package modernjava.varusage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VarUsageSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        var firstMap = getNewFilledMap();
        removeAtMostMatchesBadPractice(firstMap, 2);
        System.out.println(firstMap);

        System.out.println("\n-- GOOD PRACTICE --");
        var secondMap = getNewFilledMap();
        removeAtMostMatchesGoodPractice(secondMap, 2);
        System.out.println(secondMap);
    }

    static void removeAtMostMatchesBadPractice(Map<String, ? extends Number> map, int max) {
        for (Iterator<? extends Map.Entry<String, ? extends Number>> iterator = map.entrySet().iterator();
             iterator.hasNext(); ) {
            Map.Entry<String, ? extends Number> entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    static void removeAtMostMatchesGoodPractice(Map<String, ? extends Number> map, int max) {
        for (var iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            var entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    private static boolean matches(Map.Entry<String, ? extends Number> entry) {
        return entry.getValue().intValue() > 100; // arbitrary condition for demo purposes
    }

    private static Map<String, Integer> getNewFilledMap() {
        Map<String, Integer> exampleMap = new HashMap<>();
        exampleMap.put("apple", 120);
        exampleMap.put("banana", 80);
        exampleMap.put("cherry", 150);
        exampleMap.put("pear", 200);
        return exampleMap;
    }

}
