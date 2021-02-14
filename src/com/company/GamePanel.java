package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class GamePanel extends JPanel implements Runnable {

    Graphics graphics;
    Image image;
    TicTacToeBoard b;
    Player p;
    XandO a;
    int[][] board = { {0,0,0}, {0,0,0}, {0,0,0} };
    UserPanel user;
    Thread v;
    int turn;

    public GamePanel(){
        this.setLayout(null);
        b = new TicTacToeBoard(600,600);
        a = new XandO();
        p = new Player();

        turn = 0;

        user = new UserPanel();
        user.setBounds(20,10, 100,40);
        user.setVisible(true);

        this.add(user);

        this.setFocusable(true);


        v = new Thread(this);
        v.start();

    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
        user.revalidate();
        user.repaint();
    }

    public void draw(Graphics g){
        b.draw(g);
        a.draw(g,board,turn);
        p.draw(g,turn);
    }

    public int getMove(){
        String s = "";
        boolean isNumber = false;
        boolean is = false;
        int move = 0;

        try{
            move =  Integer.parseInt(user.getCommand());
            is  = true;
        }catch (NumberFormatException ex){
            is = false;
        }

        while(!s.isEmpty() && !is){
            try{
                move =  Integer.parseInt(user.getCommand());
                is  = true;
                break;
            }catch (NumberFormatException ex){
                is = false;
            }
        }

        return move;

    }

    @Override
    public void run() {
        boolean winner = false;
        int winnerResult = 0;

        System.out.println("lool");

        repaint();

        System.out.println("lool2");

        while(true){
            if(turn == 0){

                System.out.println("Player 1 enter the position please: ");

                int move = getMove();//Integer.parseInt(user.getCommand());


                if(validMove(board,move)){
                   board = enter(board, move, 1);
                    if(isFull(board)){
                        winner = false;
                        winnerResult = 0;
                        break;
                    }
                }else{
                    while (validMove(board,move) == false){
                        System.out.println("was not a valid move enter agin please player 1: ");
                        move = getMove();//Integer.parseInt(user.getCommand());
                    }

                    board = enter(board,move,1);
                    if(isFull(board)){
                        winner = false;
                        winnerResult = 0;
                        break;
                    }
                }

                repaint();

                if(checkWinner(board) == 0){
                    turn = 1;
                }else if(checkWinner(board) == 1){
                    winnerResult = 1;
                    break;
                }else{
                    winnerResult = 2;
                    break;
                }

            }else{

                System.out.println("Player 2 enter the position please: ");
                int move = getMove();//Integer.parseInt(user.getCommand());

                if(validMove(board,move)){
                    board = enter(board,move,2);
                    if(isFull(board)){
                        winner = false;
                        winnerResult = 0;
                        break;
                    }
                }else{
                    while (validMove(board,move) == false){
                        System.out.println("was not a valid move enter agin please player 2: ");
                        move = getMove();//Integer.parseInt(user.getCommand());
                    }
                    board = enter(board,move,2);
                    if(isFull(board)){
                        winner = false;
                        winnerResult = 0;
                        break;
                    }
                }

                repaint();

                if(checkWinner(board) == 0){
                    turn = 0;
                }else if(checkWinner(board) == 1){
                    winnerResult = 1;
                    break;
                }else{
                    winnerResult = 2;
                    break;
                }

            }
        }

        if(winnerResult == 0){
            turn = 3;//draw
        }else if(winnerResult == 1){
            turn = 4;//player one won
        }else{
            turn = 5;// player two won
        }
    }

    public static int[][] enter(int[][] a, int n, int m){
        int cout = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(cout == n ){
                    a[i][j] = m;
                }
                cout++;
            }

        }

        return a;
    }

    public static boolean validMove(int[][] a, int n){
        boolean isValid = false;
        int cout = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(cout == n && a[i][j] == 0){
                    isValid = true;
                }
                cout++;
            }

        }

        return isValid;
    }

    public static int checkWinner(int[][]a){
        // 0=empty, 1 = x, 2 = o
        int winnerYet = 0;
        if((a[0][0] == 1 && a[0][1] == 1 && a[0][2] == 1) || (a[1][0] == 1 && a[1][1] == 1 && a[1][2] == 1) || (a[2][0] == 1 && a[2][1] == 1 && a[2][2] == 1) || (a[0][0] == 1 && a[1][0] == 1 && a[2][0] == 1) || (a[0][1] == 1 && a[1][1] == 1 && a[2][1] == 1) || (a[0][2] == 1 && a[1][2] == 1 && a[2][2] == 1) || (a[0][0] == 1 && a[1][1] == 1 && a[2][2] == 1)){
            winnerYet = 1;
        }else if((a[0][0] == 2 && a[0][1] == 2 && a[0][2] == 2) || (a[1][0] == 2 && a[1][1] == 2 && a[1][2] == 2) || (a[2][0] == 2 && a[2][1] == 2 && a[2][2] == 2) || (a[0][0] == 2 && a[1][0] == 2 && a[2][0] == 2) || (a[0][1] == 2 && a[1][1] == 2 && a[2][1] == 2) || (a[0][2] == 2 && a[1][2] == 2 && a[2][2] == 2) || (a[0][0] == 2 && a[1][1] == 2 && a[2][2] == 2)){
            winnerYet = 2;
        }

        return winnerYet;
    }

    public static boolean isFull(int[][] a){
        int cout = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(a[i][j] != 0){
                    cout++;
                }
            }

        }

        return cout == 9;
    }

}


