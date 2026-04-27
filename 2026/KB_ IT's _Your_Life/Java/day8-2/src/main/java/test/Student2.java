package test;

public class Student2 {

    private String id;
    private String name;


    public Student2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}