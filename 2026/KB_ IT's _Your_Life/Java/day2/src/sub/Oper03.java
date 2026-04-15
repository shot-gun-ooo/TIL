package sub;

public class Oper03 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 비교 연산자 (Comparison Operators)
         * ===============================
         *
         * 비교 연산자의 결과는 항상 boolean (true / false) 이다
         *
         * ==  : 같다
         * !=  : 다르다
         * >   : 초과
         * >=  : 이상
         * <   : 미만
         * <=  : 이하
         *
         * 주의사항
         *  - boolean 타입과 참조형(String 등)에는
         *    >, >=, <, <= 사용 불가
         *  - String 비교는 반드시 equals() 사용
         */


        // ===============================
        // 1. 기본 비교 연산자
        // ===============================
        int num1 = 10;
        int num2 = 10;

        System.out.println(num1 == num2);  // true
        System.out.println(num1 != num2);  // false
        System.out.println(num1 <= num2);  // true
        System.out.println(num1 >  num2);  // false

        // char 도 유니코드 값으로 비교된다
        char char1 = 'A';  // 65
        char char2 = 'B';  // 66
        System.out.println(char1 < char2);  // true (65 < 66)


        // ===============================
        // 2. 실수 비교 주의
        // ===============================
        // 정수와 실수를 == 로 비교하면 자동 형변환 후 비교
        int   num3 = 1;
        double num4 = 1.0;
        System.out.println(num3 == num4);  // true (int → double 자동 변환)

        // float 과 double 은 정밀도가 달라 같은 값도 != 가 될 수 있다
        float  num5 = 0.1f;
        double num6 = 0.1;
        System.out.println(num5 == num6);           // false (정밀도 차이)
        System.out.println(num5 == (float) num6);   // true  (같은 타입으로 변환 후 비교)


        // ===============================
        // 3. String 비교 (중요)
        // ===============================
        /*
         * String 은 참조 자료형이다
         * == 는 값이 아니라 참조(같은 객체인지)를 비교한다
         * 문자열 내용을 비교하려면 반드시 equals() 를 사용해야 한다
         *
         * 문자열 생성 방식
         *  1. 리터럴 방식  : String a = "이효리";
         *     → String Pool 에 저장
         *     → 동일한 문자열이 있으면 같은 객체를 재사용
         *
         *  2. new 방식     : String c = new String("이효리");
         *     → Heap 영역에 항상 새로운 객체 생성
         */

        String a = "이효리";    // String Pool 에 저장
        String b = "이효리";    // Pool 에 이미 있으므로 같은 객체 재사용
        String c = new String("이효리");  // Heap 에 새 객체 생성

        // == 비교 (참조 비교 - 같은 객체인지)
        System.out.println(a == b);  // true  (같은 Pool 객체)
        System.out.println(a == c);  // false (c는 Heap의 새 객체)

        // equals() 비교 (값 비교 - 내용이 같은지)
        System.out.println(a.equals(b));  // true
        System.out.println(a.equals(c));  // true


        // ===============================
        // 4. hashCode / identityHashCode
        // ===============================
        /*
         * hashCode()
         *  - String 은 내용이 같으면 hashCode() 값이 동일하다
         *  - 문자열 내용 기반으로 계산되기 때문
         *
         * System.identityHashCode()
         *  - 객체 자체(identity)를 식별하는 JVM 내부 해시값
         *  - 내용과 무관하게 객체가 다르면 값이 다르다
         */

        System.out.println(a.hashCode());  // 세 개 모두 동일
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        System.out.println(System.identityHashCode(a));  // a 와 b 는 동일
        System.out.println(System.identityHashCode(b));  // a 와 b 는 동일
        System.out.println(System.identityHashCode(c));  // c 는 다름


        // ===============================
        // 5. intern()
        // ===============================
        /*
         * intern()
         *  - String Pool 에 동일한 문자열이 있으면 그 참조를 반환
         *  - 없으면 Pool 에 추가 후 참조 반환
         *  - new 로 생성한 문자열을 Pool 과 == 비교하고 싶을 때 사용
         */

        String str1 = new String("Hello");  // Heap 에 새 객체
        String str2 = "Hello";              // String Pool

        System.out.println(str1 == str2);         // false (다른 객체)
        System.out.println(str1.equals(str2));    // true  (내용 같음)

        String str3 = str1.intern();  // Pool 에서 "Hello" 참조 반환
        System.out.println(str3 == str2);         // true  (같은 Pool 객체)
        System.out.println(str3.equals(str2));    // true
    }
}