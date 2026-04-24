package sub;

public class Oper01 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 연산자 우선순위 (높음 → 낮음)
         * ===============================
         *
         * 1. ()                  : 괄호
         * 2. ++, --              : 증감 연산자
         * 3. *, /, %             : 곱셈/나눗셈/나머지
         * 4. +, -                : 덧셈/뺄셈
         * 5. <, <=, >, >=        : 비교 연산자
         * 6. ==, !=              : 동등 비교
         * 7. &&                  : 논리 AND
         * 8. ||                  : 논리 OR
         * 9. ? :                 : 삼항 연산자
         * 10. =, +=, -=, *= ...  : 대입 연산자
         *
         * 우선순위가 헷갈리면 괄호로 명확하게 표현하는 것을 권장한다
         */


        // ===============================
        // 1. 산술 연산자
        // ===============================
        // +  : 덧셈
        // -  : 뺄셈
        // *  : 곱셈
        // /  : 나눗셈 (몫)
        // %  : 나머지

        int n1 = 100;
        int n2 = 200;

        System.out.println(n1 + n2);  // 300
        System.out.println(n2 - n1);  // 100
        System.out.println(n1 * n2);  // 20000
        System.out.println(n2 / n1);  // 2
        System.out.println(n2 % n1);  // 0

        // 나머지 연산자 활용
        // % 는 홀수/짝수 판별, 순환 처리 등에 자주 사용된다
        System.out.println(10 % 3);  // 1  (10 ÷ 3 = 3 ... 나머지 1)
        System.out.println(10 % 2);  // 0  (나머지가 0 이면 짝수)


        // ===============================
        // 2. 부호 연산자
        // ===============================
        // + : 양수 유지 (거의 사용하지 않음)
        // - : 부호 반전

        int x = -100;
        x = -x;               // 부호 반전
        System.out.println(x); // 100

        // 주의: byte 에 부호 연산자 적용 시 int 로 자동 승격된다
        byte b = 100;
        int y = -b;            // byte → int 로 자동 변환 후 부호 반전
        System.out.println(y); // -100


        // ===============================
        // 3. 실수 연산 오차
        // ===============================
        // 실수 타입(float, double)은 2진수로 근사 저장하기 때문에
        // 연산 결과에 오차가 발생할 수 있다

        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double result = apple - number * pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result);
        // 기대값: 0.3  실제값: 0.29999999999999998 (오차 발생)

        // 해결 방법: 정수로 변환해서 연산 후 필요할 때 실수로 변환
        int totalPieces = apple * 10;  // 1개를 10조각으로 표현
        int pieceResult = totalPieces - number;
        System.out.println("10조각에서 남은 조각: " + pieceResult);       // 3
        System.out.println("사과 1개에서 남은 양: " + pieceResult / 10.0); // 0.3 (정확)


        // ===============================
        // 4. 정수를 0으로 나누기 → ArithmeticException
        // ===============================
        // 정수 / 0 또는 정수 % 0 은 ArithmeticException 예외 발생
        // int z = 5 / 0;  // ArithmeticException: / by zero

        // 실수를 0.0으로 나누면 예외 대신 Infinity 또는 NaN 반환
        double z = 5 / 0.0;
        System.out.println(z);       // Infinity (무한대)

        double nan = 0.0 / 0.0;
        System.out.println(nan);     // NaN (Not a Number)

        // Infinity 또는 NaN 상태에서 계속 연산하면 안 된다
        System.out.println(z + 2);   // Infinity (잘못된 결과)

        // 반드시 확인 후 연산해야 한다
        if (Double.isInfinite(z) || Double.isNaN(z)) {
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z + 2);
        }
    }
}