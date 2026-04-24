package sub.exception;

public class ThrowRun {
    public static void main(String[] args) throws ClassNotFoundException {
        findC();
    }

    private static void findC() throws ClassNotFoundException {

        Class.forName("java.lang.String2");
}}
