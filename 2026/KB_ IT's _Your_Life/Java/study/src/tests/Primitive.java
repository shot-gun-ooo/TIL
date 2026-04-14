package tests;

//파일 하나 == class
// class명은 파일이름과 동일
//파일 이름은 무조건 대문자로 시작
//낙타 표기법
//클래스 첫줄은 무조건 패키지 이름
//문장의 끝은 무조건 ;을 붙여야한다.
public class Primitive {
    public static void main(String[] args) {
        //기본형 4가지
        //정수, 실수, 문자1, 논리
        // 변수 하나에 값 하나 저장됨.
        //정수
        int age = 100; //정적타이핑, 정수 말고는 다른 것 못 넣는다
        //실수
        double height = 122.2;
        //문자1
        char gender = '남'; //무조건 ''
        //논리
        boolean food = true;

        //주의점
        //정수는 byte --> short --> int --> long
        long money = 3333333333L; //long은 무조건 마지막에 L
        //실수는 float --> double
        float weight = 88.8F; //컴파일러가 88.800000000000 이렇게 인식 -> 마지막에 F 적기


        //추가
        //사람은 문자1글자보다 문자를 여러개를 많이 씀(문자열)
        String name = "홍길동"; //이중따옴표를 써야함.

        System.out.println("나이는"+ age + "세");
        System.out.println("성별은" + gender + "임");
    }
}
