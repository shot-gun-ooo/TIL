package sub;

import java.util.ArrayList;
import java.util.List;

public class Wrapper01 {

    public static void main(String[] args) {

        /*
         * ===============================
         * Wrapper 클래스
         * ===============================
         *
         * 기본 자료형(primitive type)을 객체(object)로 감싸주는 클래스
         * 기본 자료형 하나당 하나씩 제공된다
         *
         * 기본 자료형  →  Wrapper 클래스
         *  byte       →  Byte
         *  short      →  Short
         *  int        →  Integer
         *  long       →  Long
         *  float      →  Float
         *  double     →  Double
         *  char       →  Character
         *  boolean    →  Boolean
         *
         *
         * ===============================
         * Wrapper 클래스가 필요한 이유
         * ===============================
         *
         * Java에서는 기본 자료형을 객체로 다뤄야 하는 상황이 존재한다
         *
         * 1. 컬렉션(List, Map 등)에 저장할 때
         *     - 컬렉션은 객체만 저장 가능
         *     - 기본 자료형은 직접 저장 불가 → Wrapper 클래스 사용
         *
         * 2. null 을 저장해야 할 때
         *     - 기본 자료형은 null 불가
         *     - Wrapper 클래스는 객체이므로 null 가능
         *
         * 3. 제네릭(Generic) 사용할 때
         */


        // ===============================
        // 1. Wrapper 클래스가 필요한 이유
        // ===============================

        // 기본 자료형은 null 저장 불가
        // int a = null;    // 컴파일 에러
        Integer b = null;   // Wrapper 클래스는 null 가능
        System.out.println(b);  // null

        // 컬렉션에는 기본 자료형을 직접 넣을 수 없다
        // List<int> list = new ArrayList<>();  // 컴파일 에러
        List<Integer> list = new ArrayList<>();  // Wrapper 클래스는 가능
        list.add(100);  // Auto Boxing 으로 int → Integer 자동 변환
        list.add(200);
        System.out.println(list);  // [100, 200]


        // ===============================
        // 2. Boxing / Unboxing
        // ===============================
        //
        // Boxing   : 기본 자료형 → Wrapper 클래스 객체로 변환
        // Unboxing : Wrapper 클래스 객체 → 기본 자료형으로 변환
        //
        // Java 5부터 Auto Boxing / Auto Unboxing 을 지원한다
        // 컴파일러가 자동으로 변환해주기 때문에
        // 직접 변환 코드를 작성하지 않아도 된다

        // Auto Boxing : int → Integer 자동 변환
        Integer obj = 100;       // 컴파일러가 자동으로 Integer.valueOf(100) 으로 처리
        System.out.println(obj); // 100

        // Auto Unboxing : Integer → int 자동 변환
        int result = obj + 100;  // 컴파일러가 자동으로 obj.intValue() 로 처리
        System.out.println(result); // 200


        // ===============================
        // 3. 문자열 → 숫자 (Parsing)
        // ===============================
        // 사용자 입력값은  대부분 문자열(String)로 들어온다
        // 숫자 계산이 필요하면 반드시 숫자 타입으로 변환해야 한다

        int     value1 = Integer.parseInt("10");
        double  value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: " + value1);  // 10
        System.out.println("value2: " + value2);  // 3.14
        System.out.println("value3: " + value3);  // true

        // 문자열로 연산하면 결합, 변환 후 연산하면 계산
        String input1 = "10";
        String input2 = "20";

        System.out.println(input1 + input2);                                     // 1020 (문자열 결합)
        System.out.println(Integer.parseInt(input1) + Integer.parseInt(input2)); // 30   (숫자 연산)


        // ===============================
        // 4. 숫자 / 논리값 → 문자열
        // ===============================
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("str1: " + str1);  // 10
        System.out.println("str2: " + str2);  // 3.14
        System.out.println("str3: " + str3);  // true


        // ===============================
        // 5. Wrapper 클래스 유용한 상수
        // ===============================
        // 각 자료형의 최대값 / 최소값을 상수로 제공한다
        System.out.println(Integer.MAX_VALUE);  //  2147483647 ( 21억)
        System.out.println(Integer.MIN_VALUE);  // -2147483648 (-21억)
        System.out.println(Double.MAX_VALUE);   //  1.7976931348623157E308
        System.out.println(Double.MIN_VALUE);   //  4.9E-324
    }
}