package sub;

public class Var02 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 자료형 (Data Type)
         * ===============================
         *
         * 변수를 선언할 때 저장할 값의 종류를 지정하는 것
         *
         * 크게 두 가지로 나뉜다
         *  - 기본 자료형 (Primitive Type) : 값 자체를 저장 (8가지)
         *  - 참조 자료형 (Reference Type) : 객체의 주소를 저장
         *
         * ===============================
         * 기본 자료형 8가지
         * ===============================
         *
         * 논리형  boolean  : true / false
         *
         * 정수형  byte     : 1byte  (-128 ~ 127)
         *         short    : 2byte  (-32,768 ~ 32,767)
         *         int      : 4byte  (-21억 ~ 21억) ← 정수 기본 타입
         *         long     : 8byte  (21억 초과)
         *
         * 실수형  float    : 4byte  (소수점 약 7자리)
         *         double   : 8byte  (소수점 약 15자리) ← 실수 기본 타입
         *
         * 문자형  char     : 2byte  (유니코드 문자 1개)
         *
         * ===============================
         * 참조 자료형
         * ===============================
         * String, 배열, 클래스 등
         * 기본 자료형이 아닌 모든 타입
         */


        // ===============================
        // 1. 논리형
        // ===============================
        boolean isLogin  = true;
        boolean hasCoupon = false;

        System.out.println(isLogin);   // true
        System.out.println(hasCoupon); // false


        // ===============================
        // 2. 정수형
        // ===============================
        byte  byteNum  = 127;       // 최대값 127, 초과 시 컴파일 에러
        short shortNum = 30000;
        int   intNum   = 2_100_000_000;  // 언더스코어로 자릿수 구분 가능
        long  longNum  = 10_000_000_000L; // 21억 초과 시 L 접미사 필수

        System.out.println(byteNum);
        System.out.println(shortNum);
        System.out.println(intNum);
        System.out.println(longNum);

        // byte 최대값 초과 시 오버플로우
        byte maxByte = 127;
        maxByte++;
        System.out.println(maxByte);  // -128 (오버플로우 발생)

        // byte 최소값 미만 시 언더플로우
        byte minByte = -128;
        minByte--;
        System.out.println(minByte);  // 127 (언더플로우 발생)


        // ===============================
        // 3. 정수 리터럴 - 진법 표현
        // ===============================
        // 접두사로 진법을 표현할 수 있다
//        0206(8)
//                = 2×8² + 0×8¹ + 6×8⁰
//                = 2×64 + 0×8 + 6×1
//                = 128 + 0 + 6
//                = 134

//        0xB3(16)
//                = B×16¹ + 3×16⁰
//                = 11×16 + 3×1
//                = 176 + 3
//                = 179
        int binary  = 0b1011;  // 2진수  (0b 접두사)
        int octal   = 0206;    // 8진수  (0  접두사)
        int decimal = 365;     // 10진수 (접두사 없음)
        int hex     = 0xB3;    // 16진수 (0x 접두사)

        System.out.println(binary);   // 11
        System.out.println(octal);    // 134
        System.out.println(decimal);  // 365
        System.out.println(hex);      // 179


        // ===============================
        // 4. 실수형
        // ===============================
        float  floatNum  = 3.14f;   // float 는 f 또는 F 접미사 필수
        double doubleNum = 3.14;    // double 은 접미사 없음 (기본 타입)

        System.out.println(floatNum);   // 3.14
        System.out.println(doubleNum);  // 3.14

        // 정밀도 차이
        float  f = 0.1234567890123456789f;
        double d = 0.1234567890123456789;
        System.out.println(f);  // 0.12345679   (약 7자리)
        System.out.println(d);  // 0.12345678901234568  (약 15자리)

        // 지수 표기법 (e = 10의 거듭제곱)
        double exp1 = 3e6;   // 3 × 10^6 = 3,000,000.0
        double exp2 = 2e-3;  // 2 × 10^-3 = 0.002
        System.out.println(exp1);  // 3000000.0
        System.out.println(exp2);  // 0.002


        // ===============================
        // 5. 문자형
        // ===============================
        // 작은따옴표 사용, 반드시 1글자만 저장 가능
        char ch1 = 'A';      // 문자 저장
        char ch2 = 65;       // 유니코드 직접 저장 ('A'의 유니코드 = 65)
        char ch3 = '가';
        char ch4 = 44032;    // '가'의 유니코드 = 44032

        System.out.println(ch1);  // A
        System.out.println(ch2);  // A
        System.out.println(ch3);  // 가
        System.out.println(ch4);  // 가


        // ===============================
        // 6. 문자열 (String - 참조 자료형)
        // ===============================
        // 큰따옴표 사용, 글자 수 제한 없음
        String name = "홍길동";
        String job  = "개발자";

        System.out.println(name);
        System.out.println(job);
    }
}