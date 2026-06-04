package sub.file;

import java.io.*;

/*
 * ============================================================
 *보조 스트림
 * ============================================================
 *
 * 보조 스트림이란?
 *  - 기존 스트림에 추가 기능을 붙여주는 스트림이다.
 *  - 단독으로 사용할 수 없고, 기본 스트림에 연결해서 사용한다.
 *
 * 사용 형태
 *  보조스트림 변수 = new 보조스트림(기본스트림);
 *
 *  1. BufferedInputStream / BufferedOutputStream
 *  2. BufferedReader
 *  3. DataInputStream / DataOutputStream
 *  4. PrintStream
 */
public class SubStreamPractice {

    public static void main(String[] args) throws Exception {
        bufferedCopy();   // 버퍼 기반 파일 복사
        readLine();       // 한 줄씩 읽기
        dataInputOutput();// 기본 타입 입출력
        printStream();    // 출력 스트림
    }

    // ============================================================
    // 1. BufferedInputStream / BufferedOutputStream
    // ============================================================
    public static void bufferedCopy() throws Exception {
        System.out.println("==== BufferedStream 복사 ====");

        /*
         * 버퍼(Buffer)
         *  - 데이터를 임시로 모아두는 메모리 공간
         *  - 디스크 접근 횟수를 줄여 성능을 높인다.
         */
        String originalFile = "C:/Temp/test2.jpg";
        String targetFile = "C:/Temp/test3.jpg";

        File file = new File(originalFile);
        if (!file.exists()) {
            System.out.println("C:/Temp/test.jpg 파일이 없어 bufferedCopy()를 건너뜁니다.");
            System.out.println();
            return;
        }

        long start = System.nanoTime(); // 실행 시간 측정 시작

        try (
                InputStream fis = new FileInputStream(originalFile); // 기본 입력 스트림
                OutputStream fos = new FileOutputStream(targetFile); // 기본 출력 스트림
                BufferedInputStream bis = new BufferedInputStream(fis); // 입력 버퍼 스트림
                BufferedOutputStream bos = new BufferedOutputStream(fos) // 출력 버퍼 스트림
        ) {
            int data;

            while ((data = bis.read()) != -1) { // 1바이트씩 읽기 (버퍼가 내부적으로 처리)
                bos.write(data); // 읽은 데이터 출력
            }

            bos.flush(); // 버퍼에 남은 데이터 강제 출력
        }

        long end = System.nanoTime(); // 실행 시간 측정 종료

        System.out.println("버퍼 복사 완료");
        System.out.println("소요 시간(ns): " + (end - start)); // 성능 확인
        System.out.println();
    }

    // ============================================================
    // 2. BufferedReader - 한 줄씩 읽기
    // ============================================================
    public static void readLine() throws Exception {
        System.out.println("==== BufferedReader readLine() ====");

        /*
         * readLine()
         *  - 한 줄을 읽어 String으로 반환한다.
         *  - 파일 끝이면 null을 반환한다.
         */

        System.out.println("user.dir = " + System.getProperty("user.dir")); // 현재 실행 경로 확인

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:/Temp/encoding-test.txt")
        )) { // FileReader + 버퍼 기능 추가

            int lineNo = 1;

            while (true) {
                String line = br.readLine(); // 한 줄 읽기

                if (line == null) { // EOF(파일 끝)
                    break;
                }

                System.out.println(lineNo + "\t" + line); // 줄 번호 + 내용 출력
                lineNo++;
            }
        }
    }

    // ============================================================
    // 3. DataInputStream / DataOutputStream
    // ============================================================
    public static void dataInputOutput() throws Exception {
        System.out.println("==== DataInputStream / DataOutputStream ====");

        /*
         * 기본 타입을 타입 그대로 저장하고 읽는다.
         * 저장 순서와 읽는 순서가 반드시 같아야 한다.
         */
        try (
                FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.db"); // 파일 출력
                DataOutputStream dos = new DataOutputStream(fos) // 기본 타입 출력 스트림
        ) {
            dos.writeUTF("홍길동");   // 문자열 저장
            dos.writeDouble(95.5);   // double 저장
            dos.writeInt(1);         // int 저장

            dos.writeUTF("감자바");
            dos.writeDouble(90.3);
            dos.writeInt(2);

            dos.flush(); // 버퍼 비우기
        }

        try (
                FileInputStream fis = new FileInputStream("C:/Temp/primitive.db"); // 파일 입력
                DataInputStream dis = new DataInputStream(fis) // 기본 타입 입력 스트림
        ) {
            for (int i = 0; i < 2; i++) {
                String name = dis.readUTF();     // 저장한 순서 그대로 읽기
                double score = dis.readDouble();
                int order = dis.readInt();

                System.out.println(name + " : " + score + " : " + order);
            }
        }

        System.out.println();
    }

    // ============================================================
    // 4. PrintStream
    // ============================================================
    public static void printStream() throws Exception {
        System.out.println("==== PrintStream ====");

        /*
         * PrintStream
         *  - System.out의 타입이다.
         *  - print(), println(), printf()를 사용할 수 있다.
         */
        try (
                FileOutputStream fos = new FileOutputStream("C:/Temp/printStream.txt"); // 파일 출력 스트림
                PrintStream ps = new PrintStream(fos) // 출력 편의 기능 제공
        ) {
            ps.print("마치 ");                 // 줄바꿈 없이 출력
            ps.println("프린터가 출력하는 것처럼"); // 줄바꿈 포함 출력
            ps.println("데이터를 출력합니다.");

            ps.printf("| %6d | %-10s | %10s | %n", 1, "홍길동", "도적"); // 포맷 출력
            ps.printf("| %6d | %-10s | %10s | %n", 2, "감자바", "학생");
        }

        System.out.println("C:/Temp/printStream.txt 저장 완료");
        System.out.println();
    }
}