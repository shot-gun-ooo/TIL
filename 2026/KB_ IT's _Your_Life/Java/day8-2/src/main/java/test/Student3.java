package test;

public class Student3 {

    private String id;
    private String name;


    public Student3(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}