package com.company;


import java.awt.*;

public class TicTacToeBoard extends Rectangle {
     int BOARD_WIDTH;
     int BOARD_HEIGHT;

    public TicTacToeBoard(int width, int height){
        this.BOARD_HEIGHT = height;
        this.BOARD_WIDTH = width;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);

        g.drawLine(0,BOARD_HEIGHT/3,BOARD_WIDTH,BOARD_HEIGHT/3);
        g.drawLine(0,BOARD_HEIGHT/3 + BOARD_HEIGHT/3,BOARD_WIDTH,BOARD_HEIGHT/3 + BOARD_HEIGHT/3);

        g.drawLine(BOARD_WIDTH/3, BOARD_HEIGHT,BOARD_WIDTH/3,0);
        g.drawLine(BOARD_WIDTH/3 + BOARD_WIDTH/3, BOARD_HEIGHT, BOARD_WIDTH/3+ BOARD_WIDTH/3, 0);
    }



}
