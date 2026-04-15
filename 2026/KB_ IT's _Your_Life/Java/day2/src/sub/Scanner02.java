package sub;

import java.util.Scanner;

public class Scanner02 {

    public static void main(String[] args) {

        /*
         * ===============================
         * char 입력 방법
         * ===============================
         *
         * Scanner 에는 nextChar() 메소드가 존재하지 않는다
         * 따라서 문자열로 입력받은 후 charAt() 으로 문자 하나를 추출한다
         *
         * charAt(인덱스)
         *  - 문자열에서 특정 위치의 문자 1개를 반환
         *  - 인덱스는 0부터 시작
         *
         *  예) "Java"
         *       J  a  v  a
         *       0  1  2  3   ← 인덱스
         *
         *  "Java".charAt(0) → 'J'
         *  "Java".charAt(1) → 'a'
         */


        Scanner sc = new Scanner(System.in);


        // ===============================
        // 1. charAt() 으로 문자 추출
        // ===============================
        System.out.print("문자열 입력 (3글자 이상): ");
        String str = sc.nextLine();

        if (str.length() >= 3) {
            System.out.println("첫 번째 문자: " + str.charAt(0));
            System.out.println("두 번째 문자: " + str.charAt(1));
            System.out.println("세 번째 문자: " + str.charAt(2));
        } else {
            System.out.println("3글자 이상 입력해주세요.");
        }


        // ===============================
        // 2. while 반복 입력
        // ===============================
        // 특정 값을 입력할 때까지 계속 입력받는 패턴
        // "q" 입력 시 종료

        System.out.println("문자열을 입력하세요. 종료하려면 q 를 입력하세요.");

        while (true) {
            System.out.print("입력: ");
            String data = sc.nextLine();

            if (data.equals("q")) {  // "q" 입력 시 반복 종료
                break;
            }

            System.out.println("출력: " + data);
        }

        System.out.println("종료");


        // ===============================
        // 3. 정수 입력 후 문자열 입력 (버퍼 문제 해결)
        // ===============================
        System.out.print("x 값 입력: ");
        String strX = sc.nextLine();
        int x = Integer.parseInt(strX);  // 문자열 → 정수 변환

        System.out.print("y 값 입력: ");
        String strY = sc.nextLine();
        int y = Integer.parseInt(strY);  // 문자열 → 정수 변환

        System.out.println("x + y = " + (x + y));

        // 위 방식은 nextLine() 으로 받은 후 parseInt() 로 변환하기 때문에
        // 버퍼 문제가 발생하지 않는다
        // nextInt() 를 사용하면 버퍼 문제가 생길 수 있으므로
        // 정수 입력 후 문자열 입력이 이어지는 경우 위 방식으로도 가능
    }
}