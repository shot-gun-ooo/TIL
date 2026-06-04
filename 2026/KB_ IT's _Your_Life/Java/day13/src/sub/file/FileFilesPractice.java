package sub.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ============================================================
 * File 클래스 + Files 클래스
 * ============================================================
 *
 * File 클래스
 *  - 파일 또는 디렉토리 정보를 다루는 전통적인 클래스
 *  - 파일 생성, 삭제, 정보 조회, 목록 조회 등에 사용한다.
 *
 * Files 클래스
 *  - Java NIO 패키지의 파일 처리 유틸리티 클래스
 *  - 모든 메소드가 static이다.
 *  - Path 객체와 함께 사용한다.
 *
 * File vs Files
 *  - File: 전통적인 방식, File 객체 기반
 *  - Files: NIO 방식, Path 객체 기반
 */
public class FileFilesPractice {

    public static void main(String[] args) throws Exception {
        fileExample();   // File 클래스 예제 실행
        filesExample();  // Files 클래스 예제 실행
    }

    // ============================================================
    // 1. File 클래스
         // 주요 메소드:
        //   exists()         - 파일/디렉토리 존재 여부 반환
        //   mkdir()          - 디렉토리 생성
        //   createNewFile()  - 빈 파일 생성
        //   delete()         - 파일/디렉토리 삭제
        //   getName()        - 파일명 반환
        //   length()         - 파일 크기(바이트) 반환
        //   isDirectory()    - 디렉토리 여부 반환
        //   isFile()         - 파일 여부 반환
        //   listFiles()      - 디렉토리 안의 파일/폴더 목록을 File[] 로 반환
        //   lastModified()   - 마지막 수정 시간(밀리초) 반환
    // ============================================================
    public static void fileExample() throws Exception {
        System.out.println("==== File 클래스 ====");

        File dir = new File("C:/Temp/images"); // 디렉토리 객체 생성
        File file1 = new File("C:/Temp/file1.txt"); // 파일 객체 생성 (경로만 지정, 실제 생성 아님)
        File file2 = new File("C:/Temp/file2.txt");
        File file3 = new File("C:/Temp/file3.txt");

        if (!dir.exists()) {  // 디렉토리가 존재하지 않으면
            dir.mkdir();      // 디렉토리 생성
        }

        if (!file1.exists()) { // 파일 존재 여부 확인
            file1.createNewFile(); // 실제 파일 생성
        }

        if (!file2.exists()) {
            file2.createNewFile();
        }

        if (!file3.exists()) {
            file3.createNewFile();
        }

        File temp = new File("C:/Temp"); // 조회할 디렉토리
        File[] contents = temp.listFiles(); // 해당 디렉토리의 파일/폴더 목록 가져오기

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm"); // 날짜 포맷 설정

        if (contents != null) {
            for (File file : contents) {
                System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
                // 마지막 수정 시간 출력

                if (file.isDirectory()) { // 디렉토리인지 확인
                    System.out.printf("%-10s%-20s", "<DIR>", file.getName());
                    // 디렉토리는 <DIR> 표시 + 이름 출력
                } else {
                    System.out.printf("%-10s%-20s", file.length(), file.getName());
                    // 파일이면 크기(byte) + 이름 출력
                }

                System.out.println();
            }
        }

        System.out.println();
    }

    // ============================================================
    // 2. Files 클래스
        // Files 주요 메소드:
        //   writeString(Path, String, Charset) - 문자열을 파일에 저장 (Java 11+)
        //   readString(Path, Charset)          - 파일 전체를 문자열로 읽기 (Java 11+)
        //   probeContentType(Path)             - 파일의 MIME 타입 반환 (예: text/plain)
        //   size(Path)                         - 파일 크기(바이트) 반환
        //   exists(Path)                       - 파일 존재 여부 반환
        //   delete(Path)                       - 파일 삭제
        //   copy(Path, Path)                   - 파일 복사
    // ============================================================
    public static void filesExample() {
        System.out.println("==== Files 클래스 ====");

        try {
            String data = "" +
                    "id: winter\n" +
                    "email: winter@mycompany.com\n" +
                    "tel: 010-123-1234";
            // 파일에 저장할 문자열 데이터

            Path path = Paths.get("C:/Temp/user.txt");
            // Path 객체 생성 (NIO 방식의 경로 표현)

            Files.writeString(path, data, Charset.forName("UTF-8"));
            // 문자열을 파일로 저장 (UTF-8 인코딩)

            System.out.println("파일 유형: " + Files.probeContentType(path));
            // 파일의 MIME 타입 확인 (예: text/plain)

            System.out.println("파일 크기: " + Files.size(path) + " bytes");
            // 파일 크기(byte 단위) 조회

            String content = Files.readString(path, Charset.forName("UTF-8"));
            // 파일 내용을 문자열로 읽기 (UTF-8 디코딩)

            System.out.println(content); // 읽은 내용 출력

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}