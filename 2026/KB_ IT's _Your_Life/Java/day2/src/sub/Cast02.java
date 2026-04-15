package sub;

public class Cast02 {

    public static void main(String[] args) {

        /*
         * ===============================
         * 강제 형변환 (Casting)
         * ===============================
         *
         * 큰 자료형 → 작은 자료형으로 변환할 때
         * 데이터 손실 가능성이 있기 때문에
         * 개발자가 직접 명시해야 한다
         *
         * [형식]
         *   (변환할 자료형) 값
         *
         * 이때 (자료형) 을 캐스트 연산자라고 한다
         */


        // ===============================
        // 1. 기본 강제 형변환
        // ===============================
        int  var1 = 10;
        byte var2 = (byte) var1;  // int → byte 강제 변환
        System.out.println(var2); // 10 (범위 안이라 값 유지)

        long var3 = 300;
        int  var4 = (int) var3;   // long → int 강제 변환
        System.out.println(var4); // 300 (범위 안이라 값 유지)

        int  var5 = 65;
        char var6 = (char) var5;  // int → char 강제 변환
        System.out.println(var6); // 'A' (유니코드 65)

        double var7 = 3.14;
        int    var8 = (int) var7; // double → int 강제 변환 (소수점 버림)
        System.out.println(var8); // 3


        // ===============================
        // 2. 강제 형변환 시 데이터 손실
        // ===============================
        // 범위를 벗어난 값을 강제 변환하면 데이터가 손실된다

        int  large = 300;
        byte small = (byte) large; // byte 범위(-128 ~ 127)를 초과
        System.out.println(small); // 44 (예상치 못한 값 - 데이터 손실)

        // 오버플로우 : 자료형의 최대값을 초과하면 최소값으로 순환
        byte maxByte = 127;
        maxByte++;
        System.out.println(maxByte); // -128

        // 언더플로우 : 자료형의 최소값 미만이면 최대값으로 순환
        byte minByte = -128;
        minByte--;
        System.out.println(minByte); // 127


    }
}