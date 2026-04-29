package generic;

import java.util.ArrayList;

public class GenericTest2 {
    public static void main(String[] args) {
        // 1. 문자열만 담는 리스트
        ArrayList<String> list = new ArrayList<String>();
        list.add("gun");
        list.add("g1n");
        list.add("g3n");
        System.out.println(list.get(0).charAt(0)); // 'g' 출력

        // 2. 정수만 담는 리스트
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        // [수정 포인트] list가 아니라 list2에 숫자를 넣어야 합니다!
        list2.add(100);
        list2.add(200);
        list2.add(300); // 중복 가능

        // [수정 포인트] list2에서 값을 꺼내야 합니다.
        System.out.println(list2.get(0).intValue()); // 100 출력
    }
}
