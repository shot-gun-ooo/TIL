package anonymous;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student implements Comparable<Student>{
    // compareTo() 반환값 규칙:
//   - 음수 반환 : 현재 객체(this) 가 매개변수 객체보다 작다
//   - 0 반환   : 두 객체가 같다
//   - 양수 반환 : 현재 객체(this) 가 매개변수 객체보다 크다

    private String name;
    private int    score;


    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }
}
