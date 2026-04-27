package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("홍길동");
        set.add("김깅동");
        set.add("홍길동");

        System.out.println(set);
        System.out.println(set.size());
        set.add("홍길동");
        System.out.println(set);
        System.out.println(set.size());

    }
}
