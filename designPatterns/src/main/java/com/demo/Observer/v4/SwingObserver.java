package com.demo.Observer.v4;
//the observer pattern in java  are used in Swing ,JavaBeans, JavaFX
//so in this example we will see how to use observer pattern in Swing
//we will create a simple GUI application using Swing
//we will create a button and when the button is clicked, we will notify the observers



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserver {
    JFrame jFrame;
    public static void main(String[] args) {

        SwingObserver swingObserver = new SwingObserver();
        swingObserver.go();
    }

    public void go() {
        jFrame = new JFrame();
        JButton jButton = new JButton("Click me");
        jButton.addActionListener(new AngelListener());
        jButton.addActionListener(new DevilListener());

        jButton.addActionListener(e-> {
            System.out.println("Lambda expression is listening");
        });
    }
}

class AngelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Angel is listening");
    }
}

class DevilListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Devil is listening");
    }
}