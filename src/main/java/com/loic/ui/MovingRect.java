package com.loic.ui;

import javax.swing.*;
import java.awt.*;

public class MovingRect {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frameSettings();
            }
        });
    }

    private static void frameSettings(){
        //外观风格
        //JFrame.setDefaultLookAndFeelDecorated(false);

        JFrame frame = new JFrame("Hello World Swing");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        MovingPanel movingPanel = new MovingPanel();
        Thread thread = new Thread(movingPanel);
        thread.start();
        frame.add(movingPanel);
    }
}

class MovingPanel extends JPanel implements Runnable{
    private int x=0,y=0;

    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.setColor(Color.BLACK);
        graphics.fill3DRect(x,y,50,20,true);
    }

    public void run(){
        while(true){
            x++;
            y++;
            if (x>this.getWidth()){
                x=0;
                y=0;
            }
            try{
                Thread.sleep(30);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            repaint();
        }
    }

}

