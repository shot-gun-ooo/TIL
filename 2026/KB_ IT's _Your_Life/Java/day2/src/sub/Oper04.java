package sub;

public class Oper04 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 논리 연산자 (Logical Operators)
         * ===============================
         *
         * 조건식을 결합하여 boolean 결과를 반환한다
         *
         * &&  : 논리 AND - 두 조건이 모두 true 일 때만 true
         * ||  : 논리 OR  - 둘 중 하나라도 true 이면 true
         * !   : 논리 NOT - true ↔ false 반전
         *
         * ===============================
         * 단락 평가 (Short-Circuit Evaluation)
         * ===============================
         *
         * &&  : 앞의 조건이 false 이면 뒤는 실행하지 않는다
         *       → 이미 전체 결과가 false 로 확정되기 때문
         *
         * ||  : 앞의 조건이 true 이면 뒤는 실행하지 않는다
         *       → 이미 전체 결과가 true 로 확정되기 때문
         */


        // ===============================
        // 1. AND 연산자 (&&)
        // ===============================
        // true  && true  → true
        // true  && false → false
        // false && true  → false
        // false && false → false

        System.out.println(true  && true);   // true
        System.out.println(true  && false);  // false
        System.out.println(false && true);   // false


        // ===============================
        // 2. OR 연산자 (||)
        // ===============================
        // true  || true  → true
        // true  || false → true
        // false || true  → true
        // false || false → false

        System.out.println(true  || false);  // true
        System.out.println(false || false);  // false


        // ===============================
        // 3. NOT 연산자 (!)
        // ===============================
        boolean isLogin = true;

        System.out.println(isLogin);   // true
        System.out.println(!isLogin);  // false

        int age = 15;
        boolean isAdult = age >= 20;

        System.out.println(isAdult);   // false
        System.out.println(!isAdult);  // true

        boolean hasPermission = false;
        if (!hasPermission) {
            System.out.println("권한이 없습니다.");
        }


        // ===============================
        // 4. 단락 평가 확인
        // ===============================
        int num = 10;

        // && : 앞이 false → 뒤의 ++num 실행되지 않음
        boolean result1 = (num < 5) && (++num > 0);
        System.out.println("result1: " + result1);  // false
        System.out.println("num: "    + num);        // 10 (증가 안 됨)

        // || : 앞이 true → 뒤의 ++num 실행되지 않음
        boolean result2 = (num < 20) || (++num > 0);
        System.out.println("result2: " + result2);  // true
        System.out.println("num: "    + num);        // 10 (증가 안 됨)


        // ===============================
        // 5. 논리 연산자 우선순위
        // ===============================
        // && 가 || 보다 우선순위가 높다
        // 가독성을 위해 괄호 사용을 권장한다

        int x = 3;
        int y = 10;

        // && 먼저 계산: (x < 0 && x > 2) → false
        // 그 다음 ||:  y >= 5 || false   → true
        System.out.println(y >= 5 || x < 0 && x > 2);  // true

        // 괄호로 명확하게 표현 (권장)
        System.out.println((y >= 5) || (x < 0 && x > 2));  // true


        // ===============================
        // 6. 활용 예제
        // ===============================

        // 범위 확인 (1 이상 100 이하)
        int num1 = 55;
        System.out.println(num1 >= 1 && num1 <= 100);  // true

        // 영어 대문자 확인
        char ch1 = 'G';
        System.out.println(ch1 >= 'A' && ch1 <= 'Z');  // true

        char ch2 = 'g';
        System.out.println(ch2 >= 'A' && ch2 <= 'Z');  // false

        // 대소문자 구분 없이 'y' 확인
        char ch3 = 'Y';
        System.out.println(ch3 == 'y' || ch3 == 'Y');  // true

        // 영문자 여부 확인 (대문자 또는 소문자)
        char ch4 = 'f';
        System.out.println((ch4 >= 'A' && ch4 <= 'Z') || (ch4 >= 'a' && ch4 <= 'z'));  // true

        // 2 또는 3의 배수 확인
        int value = 6;
        System.out.println(value % 2 == 0 || value % 3 == 0);  // true
    }
}