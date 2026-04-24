package practice;

public class CarExample {
    public static void main(String[] args) {
        // 1. 기본 생성자 호출 (매개변수 없음) [cite: 98]
        Car car1 = new Car();
        System.out.println("car1.company : " + car1.company);
        System.out.println();
        // 2. 모델만 지정하는 생성자 호출 [cite: 99-100]
        Car car2 = new Car("자가용");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();
        // 3. 모델과 색상을 지정하는 생성자 호출 [cite: 101-102]
        Car car3 = new Car("자가용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();
// 4. 모델, 색상, 최고속도 모두 지정하는 생성자 호출 [cite: 103-105]
        Car car4 = new Car("택시", "검정", 200);
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
    }
}
