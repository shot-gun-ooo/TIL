package sub;

import java.awt.*;

public class practice {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i=0; i<5; i++) {
                    toolkit.beep(); // 0.5초 간격 비프음 [cite: 1337]
                    try { Thread.sleep(500); } catch(Exception e) {}
                }
            }
        });
        thread.start(); // 조수 작업 시작!
        for(int i=0; i<5; i++) {
        System.out.println("띵"); // [cite: 1339]
            try { Thread.sleep(500); } catch(Exception e) {}

}}};
