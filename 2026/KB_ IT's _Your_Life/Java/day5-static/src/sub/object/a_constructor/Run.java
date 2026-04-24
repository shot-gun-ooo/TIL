package sub.object.a_constructor;

public class Run {
    public static void main(String[] args) {
        //기본생성자 호출, set으로 값 변경, toString으로 확인
        // 매개변수 있는 생성자를 통해 생성, toString으로 확인

        Car c1 = new Car();

        c1.setColor("red");
        c1.setModel("그랜져");
        c1.setMaxSpeed(300);
        System.out.println(c1);

        Car c2 = new Car("black", "소나타");
    }
}
