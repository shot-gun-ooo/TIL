package threads;

public class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println("감소: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("에러정보" + e);
            }
        }
    }
}
