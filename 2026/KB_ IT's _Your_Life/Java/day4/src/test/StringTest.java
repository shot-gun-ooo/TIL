package test;

public class StringTest {
    public static void main(String[] args) {
        String str = "  Hello Java World  ";
        String str2 = "  Hello Java World  ";
        System.out.println(str == str2);

        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.substring(2));
          System.out.println(str.substring(2,5));
        System.out.println(str.trim());
        System.out.println(str.concat("java"));
        System.out.println(str.contains("java"));
    }
}
