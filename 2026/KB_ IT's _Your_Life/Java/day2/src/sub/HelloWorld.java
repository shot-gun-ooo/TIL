package sub;

/**
 * ===============================
 * Java 네이밍 규칙 (관례)
 * ===============================
 *
 * 1. 클래스명  : 대문자로 시작 (PascalCase)
 *    예) MethodPrinter, HelloWorld
 *
 * 2. 패키지명  : 소문자만 사용, 언더스코어(_) 사용 비권장
 *    예) com.study.basic
 *
 * 3. 메소드명  : 소문자로 시작 (camelCase)
 *    예) testPrint, getUserName
 *
 * 4. 변수명    : 소문자로 시작 (camelCase)
 *    예) userName, totalScore
 *
 * 여러 단어로 구성될 경우 각 단어의 첫 글자를 대문자로 작성한다.
 * 식별자는 반드시 의미 있는 이름으로 작성한다.
 *
 *
 * ===============================
 * IDE 단축키 (IntelliJ 기준)
 * ===============================
 * 메소드나 클래스 바로 위에서 /** 입력하고 Enter 누르면 IntelliJ가 자동 /** 주석완성
 *
 * Ctrl + Z             : 실행 취소
 * Ctrl + Y             : 다시 실행
 * Ctrl + /             : 한 줄 주석
 * Ctrl + Shift + /     : 블록 주석
 * Ctrl + Space         : 자동 완성
 * Ctrl + Alt + L       : 코드 자동 정렬
 * Tab / Shift + Tab    : 들여쓰기 / 해제
 *
 * main + Tab           : main 메소드 자동 생성
 * sout + Tab           : System.out.println() 자동 생성
 * souf + Tab           : System.out.printf() 자동 생성
 *
 * macOS : Ctrl → Cmd,  Alt → Option
 *
 *
 * ===============================
 * 표준 입출력 (Standard I/O)
 * ===============================
 *
 * System.out : 콘솔 일반 출력
 * System.err : 콘솔 에러 출력 (IDE에서 빨간색으로 표시됨)
 * System.in  : 키보드 입력 → Scanner 파트에서 다룸
 *
 *
 * ===============================
 * Java 공식 API 문서
 * ===============================
 *
 * Java 17 : https://docs.oracle.com/en/java/javase/17/docs/api/index.html
 * Java 21 : https://docs.oracle.com/en/java/javase/21/docs/api/index.html
 */

public class HelloWorld {

    /*
     * ===============================
     * main 메소드
     * ===============================
     *
     * JVM이 프로그램을 시작할 때 가장 먼저 호출하는 진입점이다.
     * Java 프로그램은 반드시 main 메소드에서 시작된다.
     *
     * public static void main(String[] args)
     *  - public       : JVM이 외부에서 호출할 수 있도록 공개
     *  - static       : 객체 생성 없이 JVM이 직접 호출 가능
     *  - void         : 반환값 없음
     *  - String[] args: 프로그램 실행 시 외부에서 전달되는 값 (문자열 배열)
     *
     */

    public static void main(String[] args) {

        // 일반 출력
        System.out.println("Hello World");

        // 에러 출력 (기능은 같지만 에러 메시지 출력 용도로 구분)
        System.err.println("에러 메시지 출력");
    }
}