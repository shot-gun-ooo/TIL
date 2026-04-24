package check;

public class Run {

    public static void personInfo(Person person){
        System.out.println(person.getName());

        person.walk();

        if(person instanceof Student student){
            System.out.println(student.getStudentNo());
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person("제니");
    }
}
