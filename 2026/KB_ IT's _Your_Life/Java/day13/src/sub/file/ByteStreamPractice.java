package sub.file;

import java.io.*;

/*
 * ============================================================
 * 바이트 입출력 기본
 * ============================================================
 *
 * 입출력 스트림이란?
 *  - 프로그램과 파일 사이에서 데이터를 주고받는 통로이다.
 *  - 데이터가 흐르는 방향에 따라 입력 / 출력으로 나뉜다.
 *
 * 입력 스트림(InputStream)
 *  - 파일, 네트워크 등에서 프로그램으로 데이터를 읽어오는 통로
 *
 * 출력 스트림(OutputStream)
 *  - 프로그램에서 파일, 네트워크 등으로 데이터를 내보내는 통로
 *
 * 바이트 스트림
 *  - byte 단위로 데이터를 처리한다.
 *  - 이미지, 동영상, 텍스트 등 모든 파일을 처리할 수 있다.
 *
 * 대표 클래스
 *  - InputStream / OutputStream
 *  - FileInputStream / FileOutputStream
 *
 * 실행 전 준비
 *  - C:/Temp 폴더가 있어야 한다.
 */
public class ByteStreamPractice {

    public static void main(String[] args) throws Exception {
        writeOneByte();
        writeByteArray();

        readOneByte();
        readByteArray();

        // C:/Temp/test.jpg 파일이 있을 때만 실행
        // copyFile();
    }

    // ============================================================
    // 1. 1바이트씩 쓰기
    // ============================================================
    public static void writeOneByte() {
        System.out.println("==== 1바이트씩 쓰기 ====");

        /*
         * FileOutputStream
         *  - 파일에 byte 데이터를 저장할 때 사용한다.
         *
         * try-with-resources
         *  - try (...) 안에 스트림을 생성하면
         *    작업이 끝난 뒤 자동으로 close() 된다.
         */
        try (OutputStream os = new FileOutputStream("C:/Temp/test1.db")) {

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);   // 10을 1바이트로 저장
            os.write(b);   // 20을 1바이트로 저장
            os.write(c);   // 30을 1바이트로 저장

            os.flush();    // 버퍼에 남은 데이터를 강제로 내보냄

            System.out.println("C:/Temp/test1.db 저장 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // 2. byte 배열 전체 쓰기
    // ============================================================
    public static void writeByteArray() {
        System.out.println("==== byte 배열 전체 쓰기 ====");

        try (OutputStream os = new FileOutputStream("C:/Temp/test2.db")) {

            byte[] array =  {10, 20, 30, 40, 50};

            /*
             * write(byte[] b)
             *  - byte 배열 전체를 한 번에 저장한다.
             */

            /*
             * write(byte[] b, int off, int len)
             *  - 배열의 off 인덱스부터 len개만 저장한다.
             *
             * array = {10, 20, 30, 40, 50}
             * os.write(array, 1, 3)
             * -> 20, 30, 40 저장
             */
            os.write(array);
//            os.write(array, 1, 3);
            os.flush();

            System.out.println("C:/Temp/test2.db 저장 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // ============================================================
    // 3. 1바이트씩 읽기
    // ============================================================
    public static void readOneByte() {
        System.out.println("==== 1바이트씩 읽기 ====");

        /*
         * read()
         *  - 1바이트를 읽는다.
         *  - 파일 끝에 도달하면 -1을 반환한다.
         */
        try (InputStream is = new FileInputStream("C:/Temp/test1.db")) {

            while (true) {
                int data = is.read();// 1byte씩 읽기

                if (data == -1) {// 파일 끝에도달했을경우
                    break;
                }

                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // ============================================================
    // 4. byte 배열로 읽기
    // ============================================================
    public static void readByteArray() {
        System.out.println("==== byte 배열로 읽기 ====");

        /*
         * read(byte[] b)
         *  - data 배열에 읽은 바이트를 채운다
         *  - 배열 크기만큼 한 번에 읽는다.
         *  - 실제로 읽은 바이트 수를 반환한다.
         *  - 파일 끝이면 -1을 반환한다.
         */
        try (InputStream is = new FileInputStream("C:/Temp/test2.db")) {

            byte[] data = new byte[100];

            while (true) {
                int num = is.read(data);

                if (num == -1) {
                    break;
                }

                /*
                 * 배열 전체가 아니라 실제 읽은 개수(num)만큼만 사용한다.
                 */
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // ============================================================
    // 6. 파일 복사
    // ============================================================
    public static void copyFile() throws Exception {
        System.out.println("==== 파일 복사 ====");

        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        /*
         * 파일 복사 원리
         *  1. 원본 파일을 InputStream으로 읽는다.
         *  2. 읽은 데이터를 OutputStream으로 쓴다.
         *  3. 파일 끝(-1)까지 반복한다.
         */
        try (
                InputStream is = new FileInputStream(originalFileName);
                OutputStream os = new FileOutputStream(targetFileName)
        ) {
            byte[] data = new byte[1024];

            while (true) {
                int num = is.read(data);// 최대 1024바이트읽기

                if (num == -1) {// 파일을 다읽으면while 문종료
                    break;
                }

                os.write(data, 0, num);// 읽은 데이터 파일에쓰기
            }

            os.flush();// 내부 버퍼잔류바이트를출력하고버퍼를비움
        }

        System.out.println("복사가 잘 되었습니다.");
    }
}
