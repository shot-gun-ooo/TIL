package sub;

public class Oper05 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 삼항 연산자 (Conditional Operator)
         * ===============================
         *
         * 조건식의 결과(true / false)에 따라
         * 서로 다른 값을 선택하는 연산자
         *
         * [형식]
         *   결과값 = 조건식 ? 참일 때 값 : 거짓일 때 값;
         *
         * - 조건식의 결과는 반드시 boolean 이어야 한다
         * - 삼항 연산자는 if문을 간결하게 표현할 때 사용한다
         * - 조건이 복잡해지면 if문을 사용하는 것이 가독성에 좋다
         */


        // ===============================
        // 1. 기본 삼항 연산자
        // ===============================
        int num1 = 15;
        int num2 = -20;

        String check1 = (num1 >= 0) ? "양수 또는 0" : "음수";
        String check2 = (num2 >= 0) ? "양수 또는 0" : "음수";

        System.out.println(check1);  // 양수 또는 0
        System.out.println(check2);  // 음수

        // if문과 비교
        // 삼항 연산자
        String result1 = (num1 > 0) ? "양수" : "음수 또는 0";

        // 동일한 if문
        String result2;
        if (num1 > 0) {
            result2 = "양수";
        } else {
            result2 = "음수 또는 0";
        }

        System.out.println(result1);  // 양수
        System.out.println(result2);  // 양수


        // ===============================
        // 2. 중첩 삼항 연산자
        // ===============================
        // 삼항 연산자는 중첩해서 사용할 수 있다
        // 단, 가독성이 떨어지므로 조건이 복잡하면 if-else 사용 권장

        int num3 = 0;

        String check3 =
                (num3 > 0) ? "양수"
              : (num3 == 0) ? "0"
              : "음수";

        System.out.println(check3);  // 0

        // 점수에 따른 등급 판별
        int score = 85;
        char grade = (score > 90) ? 'A'
                   : (score > 80) ? 'B'
                   : 'C';

        System.out.println(score + "점은 " + grade + "등급");  // 85점은 B등급
    }
}