package test;

public class array1 {
    public static void main(String[] args) {
        System.out.println("안녕");
        int[] jumsu = new int[10];
        System.out.println(jumsu[0]);
        System.out.println(jumsu.length);
        System.out.println(jumsu[jumsu.length-1]);

        jumsu[0] = 200;
        jumsu[1] = 200;
        System.out.println(jumsu[0]+" "+jumsu[1]);


        int[] jumsu2 = {100,200,300};
        System.out.println(jumsu2[0]);
        System.out.println(jumsu2[1]);

        for(int i=0;i<=2;i++){
            System.out.println(jumsu2[i]);

        }
        //iterator(반복자)
        //for-each 문
        for(int x :jumsu2){
            System.out.println(x);
        }
        String[] names = {"홍길동", "김길동", "박길동", "송길동", "정길동"};
        for (String z : names) {
            System.out.print(z);
        }
    }
}
