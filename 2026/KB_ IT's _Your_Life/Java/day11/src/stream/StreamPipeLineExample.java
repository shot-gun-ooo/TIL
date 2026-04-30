package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        // 1. 일반적인 리스트 생성
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", 10));
        list.add(new Student("신용권", 20));
        list.add(new Student("유미선", 30));

        // 2. Arrays.asList 사용 (세미콜론이 아니라 쉼표로 구분해야 합니다)
        List<Student> list2 = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        // 3. 스트림 파이프라인 (result 타입 선언 필수!)
        int result = list2.stream()
                .mapToInt(student -> student.getScore()) // 람다식 간소화
                .sum();

        System.out.println("점수 합계: " + result);


    }
}