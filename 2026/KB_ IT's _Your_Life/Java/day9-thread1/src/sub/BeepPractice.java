package sub;

import java.awt.*;

public class BeepPractice {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep(); // 시스템 알림음 재생
                    System.out.println("소리 재생 중..."); // 확인용 로그
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }); // 괄호 닫기 확인!

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("삐");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        @Override
//        p
//    }Thread thread1 = new Thread(){

    }
}