//package sub.object.b_memeber;
//
//public class Run {
//    public static void main(String[] args) {
//
//        // public → 다른 패키지에서도 접근 가능
//        System.out.println("public 상수: " + Earth.PUBLIC_TEST);
//
//// default → 다른 패키지에서는 접근 불가
//        System.out.println("default 상수: " + Earth.DEFAULT_TEST); // 컴파일 에러
//
//// protected → 다른 패키지 + 상속 아님 → 접근 불가
//        System.out.println("protected 상수: " + Earth.PROTECTED_TEST); // 컴파일 에러
//
//// private → 다른 패키지에서 직접 접근 불가
//// System.out.println("private 상수: " + Earth.PRIVATE_TEST); // 컴파일 에러
//
//// private 상수는 public 메서드로 간접 접근 가능
//        System.out.println("private 상수(간접 접근): " + Earth.getPrivateTest());
//
//        Car c1 = new Car("test1 car",10);
//        c1.run();
//
//        Car.simulate();
//
//        System.out.println("----------------------------");
//
//        double result1 = 10 * 10 * Calculator.pie;
//
//        int result2 = Calculator.plus(10,5);
//        int result3=Calculator.minus(10,40);
//
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);
//
//
//        Korean k1 = new Korean("홍길동","12345-34233");
//
//        System.out.println(k1);
//        k1.setName("제니");
////        k1.setSsn("11111-22222");
//
//
//
//
//    }
//
//
//
//
//}
