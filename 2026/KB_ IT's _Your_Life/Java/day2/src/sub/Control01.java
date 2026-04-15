package sub;

import java.util.Scanner;

/*
 * ===============================
 * 제어문 - 조건문 (if)
 * ===============================
 *
 * 조건문은 주어진 조건의 결과(true / false)에 따라
 * 실행할 코드 블록을 선택하는 제어문이다.
 *
 * Java의 조건문 종류
 * - if
 * - if-else
 * - if-else if-else
 * - 중첩 if
 */
public class Control01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===============================
        // 1. if 문
        // ===============================
        /*
         * 조건식이 true일 때만 블록을 실행한다.
         * 조건식이 false이면 블록을 건너뛴다.
         *
         * if (조건식) {
         *     // 조건이 true일 때 실행
         * }
         *
         * 아래 예제에서 score = 93 이므로
         * 첫 번째 if 블록은 실행되고
         * 두 번째 if 블록은 건너뛴다.
         * 단, 중괄호가 없는 두 번째 println은
         * 조건과 관계없이 항상 실행된다.
         */

        int score = 93;

        if (score >= 90) {
            System.out.println("점수가 90 이상입니다.");
            System.out.println("등급은 A입니다.");
        }

        // 중괄호 생략 시 주의
        // if 블록은 바로 아래 한 줄만 포함된다.
        // 두 번째 println은 조건과 무관하게 항상 실행된다.
        if (score < 90)
            System.out.println("점수가 90 미만입니다.");
        System.out.println("(이 줄은 항상 출력됩니다 - 중괄호 생략 주의)");

        System.out.println("--------------------------------");

        // ===============================
        // 2. if-else 문
        // ===============================
        /*
         * 조건이 true이면 if 블록을,
         * 조건이 false이면 else 블록을 실행한다.
         * 두 블록 중 반드시 하나만 실행된다.
         *
         * if (조건식) {
         *     // true일 때 실행
         * } else {
         *     // false일 때 실행
         * }
         */



        System.out.println("--------------------------------");

        // ===============================
        // 3. if-else if-else 문
        // ===============================
        /*
         * 여러 조건 중 하나를 선택해서 실행한다.
         * 조건은 위에서 아래로 순서대로 검사하며
         * 하나의 조건이 true가 되면
         * 나머지 조건은 더 이상 검사하지 않는다.
         *
         * if (조건1) {
         *     // 조건1이 true일 때
         * } else if (조건2) {
         *     // 조건2가 true일 때
         * } else {
         *     // 모두 false일 때
         * }
         */

        System.out.print("점수를 입력하세요 (0~100): ");
        int inputScore = sc.nextInt();

        // 입력값 검증 - 유효하지 않으면 바로 종료
        if (inputScore < 0 || inputScore > 100) {
            System.out.println("잘못된 점수입니다. 프로그램을 종료합니다.");
            sc.close();
            return;
        }


        // ===============================
        // 4. 중첩 if 문
        // ===============================
        /*
         * if 블록 안에 또 다른 if 문을 넣을 수 있다.
         * 바깥 조건을 먼저 통과한 후
         * 안쪽 조건을 추가로 검사한다.
         *
         * 아래 예제는 81~100 사이의 난수로 점수를 정하고
         * A+ / A / B+ / B 등급을 세분화한다.
         * (Math.random() 자세한 내용은 Control08 참고)
         */

        int randomScore = (int) (Math.random() * 20) + 81;
        System.out.println("점수: " + randomScore);

        String detailGrade;

        if (randomScore >= 90) {
            if (randomScore >= 95) {
                detailGrade = "A+";
            } else {
                detailGrade = "A";
            }
        } else {
            if (randomScore >= 85) {
                detailGrade = "B+";
            } else {
                detailGrade = "B";
            }
        }

        System.out.println("학점: " + detailGrade);

        System.out.println("--------------------------------");


        sc.close();
    }
}