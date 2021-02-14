package com.company;

import java.awt.*;

public class XandO {
    public XandO(){

    }

    public void draw(Graphics g,int[][] a, int turn){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN, 60));

        /*g.drawString("1", 100,100);//1,1
        g.drawString("2", 300,100);//1,2
        g.drawString("3", 500,100);//1,3

        g.drawString("4", 100,300);//2,1
        g.drawString("5", 300,300);//2,2
        g.drawString("6", 500,300);//2,3

        g.drawString("7", 100,500);//3,1
        g.drawString("8", 300,500);//3,2
        g.drawString("9", 500,500);//3,3*/


        int cout = 1;

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){


                if(a[i][j] == 0 && cout == 1){
                    g.drawString("1", 100,100);
                }else if(a[i][j] == 0 && cout == 2){
                    g.drawString("2", 300,100);
                }else if(a[i][j] == 0 && cout == 3){
                    g.drawString("3", 500,100);
                }else if(a[i][j] == 0 && cout == 4){
                    g.drawString("4", 100,300);
                }else if(a[i][j] == 0 && cout == 5){
                    g.drawString("5", 300,300);
                }else if(a[i][j] == 0 && cout == 6){
                    g.drawString("6", 500,300);
                }else if(a[i][j] == 0 && cout == 7){
                    g.drawString("7", 100,500);
                }else if(a[i][j] == 0 && cout == 8){
                    g.drawString("8", 300,500);
                }else if(a[i][j] == 0 && cout == 9){
                    g.drawString("9", 500,500);
                }

                if(a[i][j] == 1 && cout == 1){
                    g.drawString("X", 100,100);
                }else if(a[i][j] == 1 && cout == 2){
                    g.drawString("X", 300,100);
                }else if(a[i][j] == 1 && cout == 3){
                    g.drawString("X", 500,100);
                }else if(a[i][j] == 1 && cout == 4){
                    g.drawString("X", 100,300);
                }else if(a[i][j] == 1 && cout == 5){
                    g.drawString("X", 300,300);
                }else if(a[i][j] == 1 && cout == 6){
                    g.drawString("X", 500,300);
                }else if(a[i][j] == 1 && cout == 7){
                    g.drawString("X", 100,500);
                }else if(a[i][j] == 1 && cout == 8){
                    g.drawString("X", 300,500);
                }else if(a[i][j] == 1 && cout == 9){
                    g.drawString("X", 500,500);
                }

                if(a[i][j] == 2 && cout == 1){
                    g.drawString("O", 100,100);
                }else if(a[i][j] == 2 && cout == 2){
                    g.drawString("O", 300,100);
                }else if(a[i][j] == 2 && cout == 3){
                    g.drawString("O", 500,100);
                }else if(a[i][j] == 2 && cout == 4){
                    g.drawString("O", 100,300);
                }else if(a[i][j] == 2 && cout == 5){
                    g.drawString("O", 300,300);
                }else if(a[i][j] == 2 && cout == 6){
                    g.drawString("O", 500,300);
                }else if(a[i][j] == 2 && cout == 7){
                    g.drawString("O", 100,500);
                }else if(a[i][j] == 2 && cout == 8){
                    g.drawString("O", 300,500);
                }else if(a[i][j] == 2 && cout == 9){
                    g.drawString("O", 500,500);
                }

                cout++;
            }
        }


    }

}
