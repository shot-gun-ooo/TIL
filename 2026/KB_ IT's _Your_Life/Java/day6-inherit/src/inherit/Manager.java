package inherit;

public class Manager extends Employee{
    //필드 4개
    //메서드
    //Object가 상속한 메서드들
    //Employee가 상속한 메서드들


    public Manager(String name, String address, int salary, String rrn, int bonus) {
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    private int bonus;

    public void test(){
        System.out.println("관리 감독하다.");
    }



    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
