package collection;

import java.util.concurrent.CountDownLatch;

public class LambdaTest {
    public static void main(String[] args) {
        Person3 person = new Person3();
        person.action((double x, double y) -> x+y);
        person.action(Computer :: staticMethod);
        Computer com = new Computer();
        person.action(com :: instanceMethod);
    }
}
