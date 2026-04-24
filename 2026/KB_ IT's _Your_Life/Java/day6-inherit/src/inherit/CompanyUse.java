package inherit;

public class CompanyUse {
    public static void main(String[] args) {
        Employee e = new Employee("홍길동", "광진구", 10000000, "04033030");
        System.out.println(e);

        System.out.println(e.name);
        System.out.println(e.salary);
        System.out.println(e.address);
//        System.out.println(e.rrn);

        System.out.println(e.getRrn());

        Manager manager = new Manager("가나다","ㄷㄷㄷ",33,"04000",3333);
        System.out.println(manager);


    }
}
