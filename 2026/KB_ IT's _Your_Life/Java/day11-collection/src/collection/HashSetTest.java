package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Jdbc");
        set.add("fddf");
        set.add("fddd");
        set.add("222f");
        set.add("222f");

        System.out.println(set);
        System.out.println(set.size());
        Iterator<String> iterator = set.iterator();
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());


        while(iterator.hasNext()){
            String e = iterator.next();
            System.out.println("꺼낸 값은 " + e);
            ;
        }

        set.remove("fddf");
        System.out.println(set);
    }
}
