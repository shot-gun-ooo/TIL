package study;

public class Blackpink {
    // 인스턴스 변수 (객체마다 개별적으로 가짐)

    //String id 필수
    //String pw 비밀번호는 6자리 이상이어야한다
    //String name 필수 값입니다
    //int age  나이는 0 이상이어야합니다
    //double salary 급여는 0 이상이어야한다
    //char gender 성별은 'M' 또는 'F'만 가능

    //필드 정의
    private String id;
    private String pw;
    private String name;
    private int age;
    private double salary;
    private char gender;


//    public Blackpink(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("id는 필수");
            return;
        }
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        if (pw.length() >= 6){
            this.pw = pw;
        }
        else{
            System.out.println("오류");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("오류");
    }}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("오류");
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F' ) {
            this.gender = gender;
        } else {
            System.out.println("오류");
        }
    }

    @Override
    public String toString() {
        return "Blackpink{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';


    }

    //setter getter
    //setter에서 값 체크
    //toString()

    //직원은 2명, 리사, 제니

}

