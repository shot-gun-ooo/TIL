package object;

import javax.swing.*;
import java.awt.*;

public class Graphic {
    public static void main(String[] args) {
        //필요한 부품들을 생각해보자.
        //틀 ---> JFrame
        //배치 --> FlowLayout
        //버튼 --> JButton
        //글자 --> Font

        JFrame frame = new JFrame("나의 첫 자바 프로그램"); //힙영역에 멤버변수들을 복사
        FlowLayout layout = new FlowLayout();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        Font font = new Font("Arial", Font.BOLD, 30);

        frame.setSize(400,400);
        frame.setVisible(true);
//        frame.setTitle("나의 첫 자바 프로그램");
        //프레임에 레이아웃 설정
        frame.setLayout(layout);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        button1.setText("버튼1");
        button2.setText("버튼2");
        button3.setText("버튼3");
        button4.setText("버튼4");

        //맥 user만 넣어주세요.!! ---------
        button1.setOpaque(true);
        button2.setOpaque(true);
        button3.setOpaque(true);
        button4.setOpaque(true);
        //맥 user만 넣어주세요.!! ---------

        button1.setBackground(Color.blue);
        button2.setBackground(Color.orange);
        button3.setBackground(Color.red);
        button4.setBackground(Color.pink);

        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        frame.setVisible(true);



    }
}
