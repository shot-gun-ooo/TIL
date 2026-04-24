package test1;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("1. 나는 프린트될 예정");
        try{
            System.out.println("2. 실행에러 있는 예정" + 10 / 0);


        }catch(Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        System.out.println("3. 나는 프린트가 될까요?");

    }
}
