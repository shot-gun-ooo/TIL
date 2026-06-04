package sub.file;

import java.io.*;

/*
 * ============================================================
 * 문자 입출력 기본 + 문자 변환 보조 스트림
 * ============================================================
 *
 * 문자 스트림이란?
 *  - char 단위로 텍스트를 읽고 쓰는 스트림이다.
 *  - 텍스트 파일 처리에 적합하다.
 *
 * 대표 클래스
 *  - Reader / Writer
 *  - FileReader / FileWriter
 *
 * 바이트 스트림 vs 문자 스트림
 *  - 바이트 스트림: byte 단위, 모든 파일 처리 가능
 *  - 문자 스트림: char 단위, 텍스트 파일에 적합
 *
 * 문자 변환 보조 스트림
 *  - OutputStreamWriter: byte 출력 스트림을 문자 출력 스트림처럼 사용
 *  - InputStreamReader: byte 입력 스트림을 문자 입력 스트림처럼 사용
 *
 * 필요한 이유
 *  - 한글은 여러 바이트로 저장된다.
 *  - 인코딩을 명확히 지정하지 않으면 한글이 깨질 수 있다.
 */
public class CharacterStreamPractice {

    public static void main(String[] args) throws Exception {
        writeText();      // 파일에 문자 쓰기 실행
        readText();       // 파일에서 문자 읽기 실행
        convertStream();  // 인코딩 변환 스트림 테스트
    }

    // ============================================================
    // 1. Writer로 텍스트 쓰기
    // ============================================================
    public static void writeText() {
        System.out.println("==== Writer로 텍스트 쓰기 ====");

        try (Writer writer = new FileWriter("C:/Temp/test.txt")) { // 문자 기반 파일 출력 스트림 생성

            writer.write('A');          // 1문자 쓰기 (char 하나 출력)
            writer.write('B');          // 1문자 쓰기

            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);          // 문자 배열 전체 출력

            writer.write("FGH");        // 문자열 출력

            writer.flush();             // 버퍼에 남은 데이터 강제 출력

            System.out.println("C:/Temp/test.txt 저장 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // 2. Reader로 텍스트 읽기
    // ============================================================
    public static void readText() {
        System.out.println("==== Reader로 텍스트 읽기 ====");

        /*
         * read()
         *  - 1문자를 읽는다.
         *  - 반환 타입은 int이다.
         *  - 파일 끝이면 -1을 반환한다.
         *  - 실제 문자로 출력할 때는 char로 형변환한다.
         */
        try (Reader reader = new FileReader("C:/Temp/test.txt")) { // 문자 기반 파일 입력 스트림 생성

            while (true) {
                int data = reader.read(); // 한 문자 읽기 (int로 반환)

                if (data == -1) {         // 더 이상 읽을 데이터가 없으면 종료
                    break;
                }

                System.out.print((char) data); // int -> char 변환 후 출력
            }

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 문자 배열로 읽기
         *  - 여러 문자를 한 번에 읽을 수 있어 더 효율적이다.
         */
        try (Reader reader = new FileReader("C:/Temp/test.txt")) {

            char[] data = new char[100];   // 최대 100개 문자 저장 가능한 버퍼
//            reader.read(data)     배열에 채우고 몇 개 채웠는지 알려주는 메서드
//            파일에서 데이터를 읽는다
//            읽은 문자를 data 배열에 넣는다
//            실제로 읽은 개수를 반환한다
            while (true) {
                int num = reader.read(data);

                if (num == -1) {            // 파일 끝이면 종료
                    break;
                }

                for (int i = 0; i < num; i++) { // 읽은 개수(num) 만큼만 출력
                    System.out.print(data[i]);  // 버퍼에 저장된 문자 출력
                }
            }

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // 3. 문자 변환 보조 스트림
    // ============================================================
    public static void convertStream() throws Exception {
        System.out.println("==== 문자 변환 보조 스트림 ====");

        writeWithEncoding("문자 변환 스트림을 사용합니다."); // UTF-8로 파일 저장
        String data = readWithEncoding();                // UTF-8로 파일 읽기

        System.out.println(data);
    }

    public static void writeWithEncoding(String str) throws Exception {
        try (
                OutputStream os = new FileOutputStream("C:/Temp/encoding-test.txt"); // 바이트 기반 출력 스트림
                Writer writer = new OutputStreamWriter(os, "UTF-8") // 바이트 -> 문자 변환 + UTF-8 인코딩 적용
        ) {
            writer.write(str);   // 문자열을 문자 스트림으로 출력
            writer.flush();      // 버퍼 비우기
        }
    }

    public static String readWithEncoding() throws Exception {
        try (
                InputStream is = new FileInputStream("C:/Temp/encoding-test.txt"); // 바이트 기반 입력 스트림
                Reader reader = new InputStreamReader(is, "UTF-8") // 바이트 -> 문자 변환 + UTF-8 디코딩
        ) {
            char[] data = new char[100];     // 읽은 데이터를 담을 문자 배열(버퍼)
            int num = reader.read(data);     // 배열에 데이터 채움 + 실제 읽은 문자 개수 반환



            return new String(data, 0, num); // 0부터 num개 만큼만 문자열 생성 (유효 데이터만 사용)
        }
    }
}