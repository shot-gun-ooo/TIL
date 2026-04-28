package test;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class ThreadRun extends JFrame {
    JLabel top = new JLabel("1", SwingConstants.CENTER);
    JLabel center = new JLabel("2", SwingConstants.CENTER);
    JLabel sub = new JLabel("3", SwingConstants.CENTER);

    public ThreadRun() {
        getContentPane().setBackground(Color.GREEN);
        setTitle("나의 멀티스레드");
        setSize(875, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료

        top.setFont(new Font("Arial Narrow", Font.BOLD, 65));
        getContentPane().add(top, BorderLayout.NORTH);

        center.setFont(new Font("굴림", Font.PLAIN, 54));
        getContentPane().add(center, BorderLayout.CENTER);

        sub.setFont(new Font("Arial Narrow", Font.BOLD, 30));
        getContentPane().add(sub, BorderLayout.SOUTH);

        // 1. 카운트다운 스레드
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 500; i > 0; i--) {
                    top.setText("카운트다운: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }; // 세미콜론 잊지 마세요!

        // 2. 시계 스레드
        Thread timer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Date date = new Date();
                    sub.setText(date.toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // 3. 이미지 이름 변경 스레드
        Thread img = new Thread() {
            @Override
            public void run() {
                String[] images = {"1.png", "2.png", "3.png", "4.png", "5.png"};
                while (true) { // 무한 반복으로 변경
                    for (int i = 0; i < images.length; i++) {
                        center.setText("이미지: " + images[i]);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        // CPU 스케줄러에 등록 (실행)
        thread.start();
        timer.start();
        img.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new ThreadRun();
    }
}