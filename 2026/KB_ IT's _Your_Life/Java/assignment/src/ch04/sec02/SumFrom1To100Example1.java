package ch04.sec02;

public class SumFrom1To100Example1 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while(i<=100){
            sum += i;
            i++;
        }
        System.out.println("1~100 합 : " + sum);
    }
}
