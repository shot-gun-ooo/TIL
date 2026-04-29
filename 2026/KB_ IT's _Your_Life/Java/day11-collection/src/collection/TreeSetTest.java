package collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍길동");
        treeSet.add("성길동");
        treeSet.add("용길동");
        System.out.println(treeSet);
    }
}
