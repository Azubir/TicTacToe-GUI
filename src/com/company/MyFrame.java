package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        GamePanel g = new GamePanel();

        this.add(g);
        this.setSize(600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
