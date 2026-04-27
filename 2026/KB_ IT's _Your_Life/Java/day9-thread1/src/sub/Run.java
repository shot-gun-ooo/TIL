//package sub;
//
//public class Run {
//    public static void main(String[] args) {
//
//        Count count = new Count();
//
//        Thread t1 = new Thread(()->{
//            for (int i=0;i<100000;i++){
//                count.increment();
//            }
//        });
//
//
//        Thread t2 = new Thread(()->{
//            for (int i=0;i<100000;i++){
//                count.increment();
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println(count.getCount());
//    }
//}
