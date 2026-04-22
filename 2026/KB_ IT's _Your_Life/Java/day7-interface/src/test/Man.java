package test;

public class Man extends Person{

    int power;

    public Man(String name, int age, int power) {
        super(name, age);
        this.power = power;
    }

    public void run(){
        System.out.println("빨리 달리다.");
    }
}
