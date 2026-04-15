package sub;

public class Var04 {

    public static void main(String[] args) {

        /*
         * ===============================
         * var (지역 변수 타입 추론)
         * ===============================
         *
         * Java 10부터 도입된 기능
         * 컴파일러가 초기화 값을 보고 타입을 자동으로 추론한다
         * 동적 타입이 아니며, 컴파일 시점에 타입이 확정된다
         *
         * 주의사항
         *  - 반드시 선언과 동시에 초기화해야 한다
         *  - 한 번 추론된 타입은 변경할 수 없다
         *  - 지역 변수에서만 사용 가능하다
         *  - 타입이 불명확한 경우 명시적 타입 사용 권장
         */


        // ===============================
        // 1. 기본 사용
        // ===============================
        var message = "Hello";  // String 으로 추론
        var num     = 10;       // int 로 추론
        var pi      = 3.14;     // double 로 추론

        System.out.println(message);
        System.out.println(num);
        System.out.println(pi);


        // ===============================
        // 2. 연산 결과 타입 추론
        // ===============================
        var result1 = num * pi;      // int * double → double 로 추론
        var result2 = num + message; // int + String → String 으로 추론

        System.out.println(result1);  // 31.400000000000002
        System.out.println(result2);  // 10Hello


        // ===============================
        // 3. var vs 명시적 타입
        // ===============================
        // var 를 쓰면 타입이 코드에 드러나지 않아 가독성이 떨어질 수 있다
        // 연산 결과의 타입이 불명확한 경우 명시적 타입 사용 권장

        var result3    = num * pi;      // 이 변수의 타입이 뭔지 바로 알기 어렵다
        double result4 = num * pi;      // 타입이 명확하게 드러남 (권장)

        var result5    = num + message; // 이 변수의 타입이 뭔지 바로 알기 어렵다
        String result6 = num + message; // 타입이 명확하게 드러남 (권장)

        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
}