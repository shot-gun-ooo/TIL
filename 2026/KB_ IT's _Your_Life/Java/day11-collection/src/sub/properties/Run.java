package sub.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Run {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // getResourceAsStream은 파일이 없으면 null을 리턴합니다.
        try (InputStream is = Run.class.getResourceAsStream("database.properties")) {
            if (is == null) {
                System.out.println("설정 파일을 찾을 수 없습니다! 파일명을 확인해주세요.");
                return;
            }

            // 파일 로드 (IOException 처리가 필수입니다)
            properties.load(is);

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");

            System.out.println("Driver: " + driver);
            System.out.println("URL: " + url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}