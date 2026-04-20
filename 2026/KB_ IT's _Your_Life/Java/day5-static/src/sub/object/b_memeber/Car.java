package sub.object.b_memeber;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void run(){
        this.setSpeed(100);
        System.out.println(this.model + "가 달립니다" + this.speed);
    }

    public static void simulate(){
//        System.out.println(speed); //컴파일 에러, 어느 객체의 speed인지 알 수가 없다.
        Car myCar = new Car("test car",100);
        myCar.run();
    }


}
