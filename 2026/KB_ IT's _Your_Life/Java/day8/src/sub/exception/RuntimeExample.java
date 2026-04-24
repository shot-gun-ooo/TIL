package sub.exception;

public class RuntimeExample {
    public static void main(String[] args) {
        try{
        String str = null;
        int result = str.length();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());

    }finally{
        System.out.println("항상 실행");
    }
        System.out.println("프로그램 종료");}}
