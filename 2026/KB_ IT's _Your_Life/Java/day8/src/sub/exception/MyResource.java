//package sub.exception;
//
//public class MyResource {
//
//    private String name;
//
//    public MyResource(String name) {
//        this.name = name;
//        System.out.println("[MyResource(" + name + ") 열기]");
//    }
//
//    // 정상 데이터 반환
//    public String read1() {
//        System.out.println("[MyResource(" + name + ") 읽기]");
//        return "100";   // Integer.parseInt() 정상 처리 가능
//    }
//
//    // 파싱 불가 데이터 반환
//    public String read2() {
//        System.out.println("[MyResource(" + name + ") 읽기]");
//        return "abc";   // Integer.parseInt() 시 NumberFormatException 발생
//    }
//
//    // try-with-resources 종료 시 자동 호출
//    @Override
//    public void close() throws Exception {
//        System.out.println("[MyResource(" + name + ") 닫기]");
//    }
//}
