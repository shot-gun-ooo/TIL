package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("ghdrlfehd",56);
        map.put("1",52);
        map.put("323",544);
        map.put("323",5);
        System.out.println(map);
        System.out.println(map.size());

        System.out.println(map.get("1"));
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + ";" + map.get(key));
        }
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String,Integer> entry = iterator1.next();
            System.out.println(entry.getKey()+" " + entry.getValue());
        }
        map.remove("323");
        System.out.println(map.size());
    }
}
