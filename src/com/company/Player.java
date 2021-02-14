package com.company;

import java.awt.*;

public class Player extends Rectangle {

    public Player(){

    }

    public void draw(Graphics g, int turn){

        g.setFont(new Font("Consolas",Font.PLAIN, 30));

        if(turn == 0){
            g.drawString("Player 1 please enter a number",130, 40);
        }else if(turn == 1){
            g.drawString("Player 2 please enter a number",130, 40);
        }else if(turn == 3){
            //g.setFont(new Font("Consolas",Font.PLAIN, 50));
            g.drawString("Draw",230, 40);
        }else if(turn == 4){
           // g.setFont(new Font("Consolas",Font.PLAIN, 40));
            g.drawString("Player 1 WON",200, 40);
        }else if(turn == 5){
           // g.setFont(new Font("Consolas",Font.PLAIN, 40));
            g.drawString("Player 2 WON",200, 40);
        }
    }
}
