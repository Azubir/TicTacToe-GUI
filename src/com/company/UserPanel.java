package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class UserPanel extends JPanel {

    private JTextField commandField = new JTextField();
    private LinkedList<String> commandBuffer = new LinkedList<String>();

    public UserPanel(){
        class AddActionListener implements ActionListener {
            public void actionPerformed(ActionEvent event)	{
                synchronized (commandBuffer) {
                    commandBuffer.add(commandField.getText());
                    commandField.setText("");
                    commandBuffer.notify();
                }
                return;
            }
        }

        Border logBorder = BorderFactory.createLineBorder(Color.GREEN);
        this.setBorder(logBorder);

        this.setLayout(null);

        ActionListener listener = new AddActionListener();
        commandField.addActionListener(listener);

        this.commandField.setBounds(0,0, 100,40);
        this.add(commandField);
    }

    public String getCommand() {
        String command;
        synchronized (commandBuffer) {
            while (commandBuffer.isEmpty()) {
                try {
                    commandBuffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            command = commandBuffer.pop();
        }
        return command;
    }
}
