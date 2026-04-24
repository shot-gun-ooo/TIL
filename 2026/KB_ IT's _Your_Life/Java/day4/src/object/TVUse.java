package object;

public class TVUse {
    public static void main(String[] args) {
       Television tv = new Television(); //멤버변수가 생성됨.
        //size, price 변수가 만들어짐.
        //tv는 참조형 변수이고,
        //힙영역에 만들어진 size,price가 저장된 주소가 저장
        System.out.println(tv); //주소
        System.out.println(tv.price); //0
        System.out.println(tv.size); //null

        tv.price = 100000;
        tv.size = "big";
        System.out.println(tv.price + tv.size);
        tv.powerOn();
        tv.powerOff();

        Television tv2 = new Television();
        System.out.println(tv2.price + " "+ tv2.size);
        tv2.price = 20000;
        tv2.size = "small";
        System.out.println(tv2);

        //리턴이 있는 매서드는 리턴받을 값을 가지고 어떤 처리를 해야한다.
     System.out.println(tv2.getPrice());

     // 변수에 리턴값을 넣어두고 다른 처리들을 이어서 해도 된다.
     int price2 = tv.getPrice();
     System.out.println(price2 - 10000);



    }
}
