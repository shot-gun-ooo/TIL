package object;

public class Television {
    //우리 클래스 하나 만들어보자.
    //특성을 찾아서 클래스를 만들어야 함.
    //특성
    //정적인 성질(속성)
    //사이즈, 가격, 제조회사, 색,
    //변수로 만들어 놓으면 된다.
    //맴버변수라고 한다.
    //추상화
    //컴파일 할 때 멤버변수는 자동 초기화됨.
    String size;
    int price;


    //동적인 기능(동작)
    //끄다, 켜다, 채널바꾸다, 유튜브 연결하다, 볼륨
    //메서드로 만들어 놓으면 됨.
    //맴버메서드라고 한다.
    //끄다, 켜다만 선택함.
    public void powerOn(){
        int bonus = 10000;
        System.out.println(bonus);
        System.out.println("tv를 켜다");
    }
    public void powerOff(){
        System.out.println("tv를 끄다");
    }

    public int getPrice(){
        return price;
    }

}
