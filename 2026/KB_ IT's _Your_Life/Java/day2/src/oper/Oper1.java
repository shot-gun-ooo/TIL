package oper;

import java.sql.SQLOutput;

public class Oper1 {
    //변수
//    int x = 10;
    //매서드(함수)
    //시작되는 매서드 반드시 정해져있음.
    //JVM(자바를 실행시킬 수 있는 프로그램)
    public static void main(String[] args) {
//        int y = 20;
        int x = 200;
        int y = 100;

        System.out.println("x값 : " + x);
        System.out.println("y값 : " + y);
        System.out.println("값 출력해보았음");

        int sum = x+y;
        //자바에선 int,int 계산결과는 무조건 int

        double div = y/x;
        System.out.println(div);

        //자바에서 계산결과를 실수로 얻고 싶으면 최소한 하나가
        //실수가 되어야 한다.
        //변수의 타입 변경 불가능
        //cpu가 변수의 값을 가져다가 강제로 값을 타입으로 변경해주어야함.
        //강제 형변화(캐스팅)

        double div2 = (double)y / x;
        System.out.println(div2);

        double div3 = (double)(y / x);
        System.out.println(div3);




    }

}

