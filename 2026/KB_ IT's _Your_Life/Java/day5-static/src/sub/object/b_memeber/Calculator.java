package sub.object.b_memeber;

public class Calculator {
    public static double pie = 3.14159;


    private static int count = 0;

    public Calculator(){
        count++;


    }
    public static int getCound(){
        return count;
    }

    public static int plus(int x, int y){
        return x+y;
    }
    public static int minus(int x, int y){
        return x-y;
    }
}
