//package sub; // 패키지 경로 확인!
//
//public class SumThread extends Thread {
//    private long sum;
//
//    // 롬복 대신 직접 생성자를 만듭니다 (이게 제일 확실해요)
//    public SumThread() {
//    }
//
//    public long getSum() {
//        return sum;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 100; i++) {
//            sum += i;
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}