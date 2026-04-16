package test;

import java.util.Arrays;
import java.util.Collections;

public class Array07 {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20 ;

        System.out.println(num1 +" " + num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println(num1 +" " + num2);


        int[] arr = {2,1,3};
        int temp1 = arr[0];
        arr[0]=arr[1];
        arr[1] = temp1;

        System.out.println(Arrays.toString(arr));



        /*
         * ===============================

         * 1. 값 교환 (Swap)
         * 2. 최소값 / 최대값 탐색
         * 3. 최대값 위치(인덱스) 찾기
         * 4. 오름차순 정렬 (Arrays.sort)
         * 5. 내림차순 정렬 (직접 구현)
         */

        int[] numbers = {55,22,11,99,33};

        int min = numbers[0];
        for(int i = 1; i<numbers.length;i++){
            if(numbers[i] < min){
                min=numbers[i];


            }
        }
        System.out.println("min :" + min);

        int max = numbers[0];

        for(int i = 1; i<numbers.length;i++){
            if(numbers[i] > max){
                max=numbers[i];


            }
        }
        System.out.println("max :" + max);

        for(int i = 1; i<numbers.length;i++){
            if(numbers[i] == max){ System.out.println("max :" + i);



            }
        }

        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < numbers.length/2 ; i++) {
            int temp2 = numbers[i];
            numbers[i] = numbers[numbers.length-1-i];
            numbers[numbers.length-1-i] = temp2;


        }
        System.out.println(Arrays.toString(numbers));


// ===============================
// 7. 내림차순 정렬 (컬렉션 사용)
// ===============================
        /*
         * Integer[] (래퍼 타입) 로 선언하면
         * Collections.sort() 에 전달해서
         * 내림차순을 한 번에 처리할 수 있다
         *
         * int[] (기본형) 는 Collections.sort() 사용 불가
         * → Integer[] 로 선언하거나 Arrays.stream() 으로 변환해야 한다
         *
         * Collections.reverseOrder() 는 Java 가 기본 제공
         */
        int[] sortTarget2 = {1, 2, 3, 4};

        // 반복문으로 int[] → Integer[] 직접 변환
        Integer[] boxed = new Integer[sortTarget2.length];
        for (int i = 0; i < sortTarget2.length; i++) {
            boxed[i] = sortTarget2[i];  // int → Integer 자동 박싱(Auto Boxing)
        }

        // Integer[] 에 reverseOrder() 적용
        Arrays.sort(boxed, Collections.reverseOrder());

        System.out.println("내림차순 정렬 : " + Arrays.toString(boxed));
        // 내림차순 정렬 : [4, 3, 2, 1]





    }
}
