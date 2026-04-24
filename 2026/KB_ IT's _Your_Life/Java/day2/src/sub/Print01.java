package sub;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Print01 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 출력 메소드 종류
         * ===============================
         *
         * System.out.println(값)  : 값 출력 후 줄바꿈
         * System.out.print(값)    : 값 출력 (줄바꿈 없음)
         * System.out.printf(포맷) : 형식 지정 출력 (Print02 참고)
         *
         * IDE 단축키
         * sout + Tab → System.out.println()
         */

        // ===============================
        // 1. 기본 출력
        // ===============================
        System.out.println(123);        // 정수
        System.out.println(1.23);       // 실수
        System.out.println('a');        // 문자
        System.out.println("안녕하세요"); // 문자열
        System.out.println(true);       // 논리값


        // ===============================
        // 2. 연산 결과 출력
        // ===============================
        System.out.println(123 + 456);  // 579


        // ===============================
        // 3. 부동소수점 오차
        // ===============================
        // 실수는 2진수로 근사 저장하기 때문에 오차가 발생할 수 있다
        System.out.println(1.23 - 0.12);            // 1.1099999999999999 (오차 발생)
        System.out.printf("%.2f%n", 1.23 - 0.12);  // 1.11 (출력 형식으로 제어)
        /*
         * double / float
         *  - 2진수 기반 부동소수점 방식
         *  - 일부 소수를 정확히 표현하지 못해 오차 발생
         *
         * BigDecimal
         *  - 10진수 기반
         *  - 문자열(String)로 값을 받아 정확한 값 저장
         *  - 연산자(+, -, * 등) 사용 불가 → 메소드로 연산
         *  - 연산 결과는 새로운 객체로 반환
         *
         * 생성 시 주의사항
         *  - 반드시 문자열로 생성해야 정확한 값이 저장된다
         *  - new BigDecimal("0.1")  → 정확
         *  - new BigDecimal(0.1)    → 부동소수점 오차 포함 (주의)
         */

        // BigDecimal 사칙연산 (메소드로 처리)
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");
        BigDecimal b1 = new BigDecimal(0.3);
        System.out.println(b1);
        System.out.println(a.add(b));       // 13  (덧셈)
        System.out.println(a.subtract(b));  // 7   (뺄셈)
        System.out.println(a.multiply(b));  // 30  (곱셈)

        // 나눗셈 - 소수점 자리수와 반올림 방식 지정 필수
        //
        // a.divide(b) 만 쓰면 아래 에러 발생
        //   ArithmeticException: Non-terminating decimal expansion;
        //                        no exact representable decimal result.
        //
        //   ArithmeticException        : 산술 연산 중 문제가 발생했다는 에러
        //   Non-terminating decimal    : 소수점이 끝나지 않는다 (무한소수)
        //   no exact representable     : 정확하게 표현할 수 있는
        //   decimal result             : 10진수 결과값이 없다
        //   └ 즉, 10 ÷ 3 = 3.333... 처럼 나누어 떨어지지 않는 경우
        //     어디서 끊을지 알 수 없어 예외를 던진다
        //
        // a.divide(b, 2, RoundingMode.HALF_UP) 각 인자 의미
        //   b                    : 나눌 값 (제수)
        //   2                    : 소수점 아래 몇 자리까지 표현할지
        //   RoundingMode.HALF_UP : 반올림 방식 (5 이상이면 올림)
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));  // 3.33

        // 부동소수점 오차 비교
        BigDecimal c = new BigDecimal("1.23");
        BigDecimal d = new BigDecimal("0.12");
        System.out.println(c.subtract(d));  // 1.11 (정확)

//        https://docs.oracle.com/javase/17/docs/api/java.base/java/math/BigDecimal.html

        // ===============================
        // 4. 이스케이프 문자
        // ===============================
        // \" : 큰따옴표 출력
        // \' : 작은따옴표 출력
        // \t : 탭(tab)
        // \n : 줄바꿈
        // \\ : 역슬래시 출력

        System.out.println("나는 \"자바\"를 배웁니다.");  // 나는 "자바"를 배웁니다.
        System.out.println("번호\t이름\t직업");           // 탭으로 구분

        System.out.print("나는\n");
        System.out.print("자바를\n");
        System.out.print("배웁니다.");


        // ===============================
        // 5. 문자열 결합 (+)
        // ===============================
        // + 연산에서 하나라도 String이 있으면 문자열 결합으로 처리
        // 왼쪽에서 오른쪽 방향으로 순서대로 계산

        System.out.println(9 + 9);          // 18   숫자 + 숫자 = 숫자 연산
        System.out.println("9" + 9);        // 99   문자열 + 숫자 = 문자열 결합
        System.out.println(9 + "9");        // 99   숫자 + 문자열 = 문자열 결합
        System.out.println("9" + "9");      // 99   문자열 + 문자열 = 문자열 결합

        System.out.println(9 + 9 + "9");    // 189  먼저 9+9=18, 그 다음 18+"9"="189"
        System.out.println(9 + "9" + 9);    // 999  먼저 9+"9"="99", 그 다음 "99"+9="999"
        System.out.println("9" + 9 + 9);    // 999  먼저 "9"+9="99", 그 다음 "99"+9="999"

        // char는 숫자(유니코드)로 처리된다
        System.out.println('a' + 1);        // 98  (유니코드 97 + 1)
        System.out.println("하이" + 'a');   // 하이a (문자열 결합)


        // ===============================
        // 6. 텍스트 블록 (Java 15 이상)
        // ===============================
        // 큰따옴표 세 개(""")로 여러 줄 문자열을 간편하게 작성
        // 이스케이프 문자 없이 그대로 작성 가능

        // 기존 방식
        String str1 =
                "{\n" +
                        "\t\"id\":\"winter\",\n" +
                        "\t\"name\":\"눈송이\"\n" +
                        "}";

        // 텍스트 블록 방식
        String str2 = """
                {
                    "id":"winter",
                    "name":"눈송이"
                }
                """;

        System.out.println(str1);
        System.out.println("------------------------------------");
        System.out.println(str2);

        // formatted()로 값 삽입
        String str3 = """
                {
                  "id": %d,
                  "name": "%s"
                }
                """.formatted(1, "홍길동");

        System.out.println(str3);

    }
}