package sub;

public class Oper02 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 증감 연산자 (++, --)
         * ===============================
         *
         * 변수의 값을 1씩 증가 또는 감소시키는 연산자
         *
         * 전위 (++i) : 먼저 1 증가/감소 후 다른 연산 수행
         * 후위 (i++) : 다른 연산 먼저 수행 후 1 증가/감소
         *
         * 단독으로 사용할 때는 전위/후위 결과가 동일하다
         */


        // ===============================
        // 1. 단독 사용 (전위 = 후위)
        // ===============================
        int num = 20;

        num++;    // 후위 증가
        System.out.println(num);  // 21

        ++num;    // 전위 증가
        System.out.println(num);  // 22

        num--;    // 후위 감소
        System.out.println(num);  // 21

        --num;    // 전위 감소
        System.out.println(num);  // 20


        // ===============================
        // 2. 후위 연산자 (i++)
        // ===============================
        // 다른 연산을 먼저 수행한 후 1 증가

        int x = 10;
        int y = 10;
        int z;

        z = x++;              // z = 10 (먼저 대입), 그 다음 x = 11
        System.out.println("z: " + z);  // 10
        System.out.println("x: " + x);  // 11

        // 연산식에서 후위 사용
        int first  = 20;
        int result = first++ * 3;  // 20 * 3 = 60 먼저, 그 다음 first = 21
        System.out.println("result: " + result);  // 60
        System.out.println("first: "  + first);   // 21


        // ===============================
        // 3. 전위 연산자 (++i)
        // ===============================
        // 먼저 1 증가 후 다른 연산 수행

        z = ++x;              // 먼저 x = 12, 그 다음 z = 12
        System.out.println("z: " + z);  // 12
        System.out.println("x: " + x);  // 12

        // 연산식에서 전위 사용
        int first1  = 20;
        int result1 = ++first1 * 3;  // 먼저 first1 = 21, 그 다음 21 * 3 = 63
        System.out.println("result1: " + result1);  // 63
        System.out.println("first1: "  + first1);   // 21


        // ===============================
        // 4. 복합 연산 예제
        // ===============================
        z = ++x + y++;
        // 1) ++x  → x = 13
        // 2) y++  → y 는 현재 10 사용, 이후 y = 11
        // 3) z = 13 + 10 = 23
        System.out.println("z: " + z);  // 23
        System.out.println("x: " + x);  // 13
        System.out.println("y: " + y);  // 11


        // ===============================
        // 5. 복합 대입 연산자
        // ===============================
        // 산술 연산자와 대입 연산자를 합친 것
        // 코드를 간결하게 만들고 반복문에서 자주 사용된다
        //
        // +=  : score = score + 10
        // -=  : score = score - 5
        // *=  : score = score * 2
        // /=  : score = score / 5
        // %=  : score = score % 7

        int score = 50;
        System.out.println("초기: " + score);  // 50

        score += 10;
        System.out.println("+= 10: " + score);  // 60

        score -= 5;
        System.out.println("-= 5: "  + score);  // 55

        score *= 2;
        System.out.println("*= 2: "  + score);  // 110

        score /= 5;
        System.out.println("/= 5: "  + score);  // 22

        score %= 7;
        System.out.println("%= 7: "  + score);  // 1

        // 문자열에도 += 사용 가능
        String message = "Java";
        message += " Programming";
        System.out.println(message);  // Java Programming
    }
}