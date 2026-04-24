package test1;

import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args)  {
        //파일을 만들어서 글자들을 쓰고 싶다.

        try {
            FileWriter file = null;
            file = new FileWriter("test.txt");
            file.write("오늘은 목요일 \n");
            file.write("오늘은 f \n");
            file.write("오늘은 s\n");
            file.close();
            System.out.println(10/0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("예외 발생 여부와 상관없이 무조건 실행");

        }


    }
}
