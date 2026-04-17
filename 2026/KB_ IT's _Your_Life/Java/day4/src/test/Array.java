package test;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
       //1. 배열 생성시 값들을 알고 있을 때
        int[] age2 = {10,20,30};
        //2. 배열 생성시 값들을 모르고 있다가 나중에 넣을 때
        int[] age = new int[3]; //{0,0,0}
        //배열은 초기화도 자동으로

        //읽기,쓰기 가능

        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);

        }
        //읽기만 가능
        for (int x : age){
            System.out.println(x);
        }

        age2[0] = 10;
        age2[1] = 20;
        age2[2]=30;
        System.out.println(Arrays.toString(age2));

        //기본형 복사
        byte b = 100;
        int i = b;
        //i == b; 값은 동일함.
        //작 --> 큰, 자동으로 큰 타입으로 타입이 변환이 됨 (자동 형변환)

        byte b2 = (byte)i;
        //큰 --> 작, 강제로 타입을 변환해서 넣어주어야함 (강제 형변환)

        //참조형 복사
        //변수(주소) --> 값들
        //주소를 복사 : 얕은 복사
        int[] age3 = age2;
        System.out.println(Arrays.toString(age2));
    }
}
