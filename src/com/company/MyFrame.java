package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        GamePanel g = new GamePanel();

        this.add(g);
        this.setSize(600,750);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(new Color(60, 60, 60));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
