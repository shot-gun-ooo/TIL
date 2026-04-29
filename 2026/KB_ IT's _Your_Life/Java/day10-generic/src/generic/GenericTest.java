package generic;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        //ArrayList는 제너릭이 적용된 클래스, 객체 생성시 타입을 정할 수 있음.

        list.add("홍길동");
        list.add("길동");
        list.add("홍길");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(0).equals("홍길동"));

        System.out.println(((String)(list.get(0))).charAt(0));
    }
}
