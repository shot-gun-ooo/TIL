package test;

public class SuperMan extends Man{

    boolean fly;


    public SuperMan(String name, int age, int power, boolean fly) {
        super(name, age, power);
        this.fly = fly;
    }

    public void space(){
        sleep();
        System.out.println("superman name is " + name);
        System.out.println("fly to the moon");
    }

    @Override
    public String toString() {
        return name + " " + age + " " + power + " " + fly;
    }

    @Override
    public void eat() {
        System.out.println("많이 먹다");
    }
}
