package Cast;

public class Run {
    public static void main(String[] args) {

        Parent parent = new Child();

        parent.method1();
        parent.method2();

        Child child = (Child) parent;

        child.method3();


        // 부모 타입으로 변환해도 오버라이딩된 메소드는 자식 것이 호출된다.
// 정적 바인딩 (Static Binding)
// - 컴파일 시점에 호출할 메소드가 결정되는 것
// - static 메소드, private 메소드, final 메소드

// 동적 바인딩
// - 실행(런타임) 시점에 실제 객체 타입(Child)에 맞는 메소드가 호출된다.
// - 부모 타입으로 참조하더라도 오버라이딩된 메소드는 자식 것이 실행된다.

    }
}
