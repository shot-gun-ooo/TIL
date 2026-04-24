package study;

public class Run {
    public static void main(String[] args) {
        Blackpink lisa = new Blackpink("lisa_01", "리사");
        lisa.setPw("123456");
        lisa.setAge(27);
        lisa.setSalary(5000);
        lisa.setGender('F');

        Blackpink jennie = new Blackpink("jennie_02", "제니");
        jennie.setPw("jen12");
        jennie.setAge(-5);
        jennie.setSalary(6000);
        jennie.setGender('F');
        System.out.println(lisa);
        System.out.println(jennie);

    }

}
