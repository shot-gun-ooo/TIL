package test;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        int[] num3 = {100,200,300};
        int[] num4 = num3;
        System.out.println("num3주소" + num3);
        System.out.println("num4주소" + num4);
        num3[0] = 999;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num4));

        int[] num5 = num3.clone();
        num3[0]= 555;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num5));

        System.out.println(num3);
        System.out.println(num5);

    }
}
