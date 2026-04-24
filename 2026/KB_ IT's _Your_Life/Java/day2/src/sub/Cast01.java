package sub;

public class Cast01 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 자동 형변환 (Promotion)
         * ===============================
         *
         * 작은 자료형 → 큰 자료형으로 대입할 때
         * 자바가 자동으로 타입을 변환해준다
         * 데이터 손실 위험이 없기 때문에 자동으로 처리된다
         *
         * 변환 방향 (작은 → 큰 순서)
         * byte → short → int → long → float → double
         *                char ↗
         */


        // ===============================
        // 1. 기본 자동 형변환
        // ===============================
//        Local variable 'doubleValue' is redundant
//        변수에 담지 않고 바로 출력해도 동작은 같기 때문에 "굳이 변수 필요하냐" 고 알려주는 것이다.
//        에러는 아니고 IntelliJ 의 코드 품질 경고

        byte byteValue = 10;
        int  intValue  = byteValue;  // byte → int 자동 변환
        System.out.println("intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;        // char → int (유니코드 값으로 변환)
        System.out.println("가의 유니코드: " + intValue);

        intValue = 50;
        long longValue = intValue;   // int → long 자동 변환
        System.out.println("longValue: " + longValue);

        float floatValue = longValue; // long → float 자동 변환
        System.out.println("floatValue: " + floatValue);

        double doubleValue = floatValue; // float → double 자동 변환
        System.out.println("doubleValue: " + doubleValue);


        // ===============================
        // 2. 연산 시 자동 형변환
        // ===============================
        // 서로 다른 타입끼리 연산하면
        // 더 큰 타입으로 자동 변환된 후 연산된다
        //
        // 규칙
        //  - byte, short, char 끼리 연산 → 결과는 int
        //  - int + long 연산              → 결과는 long
        //  - long + float 연산            → 결과는 float
        //  - float + double 연산          → 결과는 double

        // byte + byte → int
        byte v1 = 10;
        byte v2 = 20;
        int result1 = v1 + v2;  // byte끼리 연산해도 결과는 int
        System.out.println("result1: " + result1);

        // byte + int + long → long
        byte  v3 = 10;
        int   v4 = 100;
        long  v5 = 1000L;
        long result2 = v3 + v4 + v5;  // 가장 큰 타입인 long으로 변환 후 연산
        System.out.println("result2: " + result2);

        // char + char → int
        char v6 = 'A';  // 유니코드 65
        char v7 = 1;
        int result3 = v6 + v7;  // 65 + 1 = 66
        System.out.println("result3: " + result3);
        System.out.println("result3 char: " + (char) result3);  // 'B'

        // 컴파일 단계에서 연산되는 경우 (리터럴끼리 연산)
        // 변수가 없고 리터럴끼리만 연산하면 컴파일러가 미리 계산해서 저장
        byte result4 = 10 + 20;  // 컴파일 시 이미 30으로 계산됨 → byte에 저장 가능
        System.out.println("result4: " + result4);


        // ===============================
        // 3. 정수 나눗셈 주의
        // ===============================
        // 정수 ÷ 정수 = 정수 (소수점 버림)
        int val = 10;
        int resultS = val % 4;
        System.out.println(resultS);

        // 실수 결과가 필요하면 피연산자 중 하나를 double로 만들어야 한다

        // 방법 1 : 한쪽을 실수 리터럴로 작성
        double result7 = val / 4.0;
        System.out.println(result7);


        // 방법 2 : 강제 형변환으로 double로 변환

        int val2 = 10;
        double result8 = (double)val / val2;
        System.out.println(result8);

    }
}