package anonymous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 85));
        students.add(new Student("김길동", 92));
        students.add(new Student("이길동", 78));
        students.add(new Student("박길동", 95));
        students.add(new Student("최길동", 88));


        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students);
        System.out.println("------");

        for (Student s : students) {
            System.out.println(s);
        }

    }
}
