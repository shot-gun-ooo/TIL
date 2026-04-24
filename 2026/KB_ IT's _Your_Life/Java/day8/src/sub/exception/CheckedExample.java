package sub.exception;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            Class.forName("ga");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            Class.forName("ga");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
