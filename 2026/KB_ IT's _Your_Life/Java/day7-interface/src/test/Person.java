package test;

public class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("먹다");
    }
    public void sleep(){
        System.out.println("자다");
    }


}
