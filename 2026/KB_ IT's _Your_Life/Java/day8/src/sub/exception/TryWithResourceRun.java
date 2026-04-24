//package sub.exception;
//
//public class TryWithResourceRun {
//    public static void main(String[] args) {
//        try(MyResource res = new MyResource("A") ){
//            String data = res.read1();
//            int value = Integer.parseInt(data);
//            System.out.println(value);
//        }catch(Exception e){
//            e.printStackTrace();
//            System.out.println("발생");
//        }
//    }
//}
