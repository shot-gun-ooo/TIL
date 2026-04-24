package sub;

import java.util.Scanner;

public class Scanner01 {

    public static void main(String[] args) {

        /*
         * ===============================
         * Scanner 클래스 (키보드 입력)
         * ===============================
         *
         * java.util.Scanner 는 Java에서 기본으로 제공하는 입력 처리 클래스다
         * 키보드(System.in)로부터 값을 입력받아 프로그램에서 사용할 수 있도록 도와준다
         *
         * 다른 클래스의 기능(메소드)을 사용하려면
         * 반드시 객체를 생성한 후 메소드를 호출해야 한다
         *
         * [객체 생성]
         *   Scanner sc = new Scanner(System.in);
         *
         *
         * ===============================
         * 주요 입력 메소드
         * ===============================
         *
         * 문자열 입력
         *  - next()     : 공백(띄어쓰기) 전까지만 입력 받음
         *  - nextLine() : 한 줄 전체 입력 (엔터 전까지)
         *
         * 정수 입력
         *  - nextInt()  : int 값 입력
         *
         * 실수 입력
         *  - nextDouble() : double 값 입력
         *
         *
         * ===============================
         * next() vs nextLine() 차이 (중요)
         * ===============================
         *
         * next()
         *  - 값만 읽어오고 엔터(Enter)는 입력 버퍼에 남겨둔다
         *
         * nextLine()
         *  - 엔터(Enter)까지 포함해서 한 줄을 읽는다
         *
         * 주의
         *  next(), nextInt(), nextDouble() 사용 후
         *  바로 nextLine() 을 호출하면
         *  버퍼에 남아있는 엔터를 읽어버려 빈 문자열이 입력될 수 있다
         *
         * 해결 방법
         *  next(), nextInt(), nextDouble() 뒤에
         *  nextLine() 을 한 번 더 호출해서 버퍼에 남은 엔터를 제거한다
         *
         *  sc.nextInt();
         *  sc.nextLine(); // 엔터 제거
         *  sc.nextLine(); // 실제 문자열 입력
         */

        Scanner sc = new Scanner(System.in);

        sc.nextLine();


        // ===============================
        // 1. next() 입력
        // ===============================
        // 공백 전까지만 읽는다
        // "홍 길동" 입력 시 "홍" 만 저장됨
        System.out.println();
        String name = sc.next();
        System.out.println(name);
        // ===============================
        // 2. nextLine() 입력
        // ===============================
        // 엔터 전까지 한 줄 전체를 읽는다
        // "홍 길동" 입력 시 "홍 길동" 전체 저장됨
        System.out.println("이름입력");
        String name2 = sc.nextLine();
        System.out.println(name2);
        // ===============================
        // 3. nextInt() 입력
        // ===============================


        // ===============================
        // 4. nextInt() 후 nextLine() 버퍼 문제
        // ===============================
        // nextInt() 는 숫자만 읽고 엔터를 버퍼에 남긴다
        // 바로 nextLine() 을 호출하면 엔터를 읽어버려 빈 문자열이 입력됨
        // 위에서 sc.nextLine() 으로 엔터를 제거했기 때문에 정상 입력 가능


        // ===============================
        // 5. nextDouble() 입력
        // ===============================

    }
}