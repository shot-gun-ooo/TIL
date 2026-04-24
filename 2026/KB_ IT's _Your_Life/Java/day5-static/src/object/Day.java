package object;

public class Day {
    //인스턴스 변수
    //객체생성시 힙영역에 복사
    String doing;
    int time;
    String location;
    //정적 변수, static변수
    //메모리 원본 영역에 한 개만 존재
    static int count;


    public Day(String doing, int time, String location) {
        //this는 이 클래스로 만든 객체
        this.doing = doing;
        this.time = time;
        this.location = location;
        count++;
    } //생성자

    public int getCount(){
        return count;
    }

    //toString()을 수정해서 재정의하자

    @Override
    public String toString() {
        return "Day{" +
                "doing='" + doing + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
}
