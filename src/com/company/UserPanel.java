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
    public JButton resume, save, reset;

    public UserPanel(){
        resume = new JButton();
        resume.setBounds(120,0, 70,40);
        resume.setText("Resume");

        save = new JButton();
        save.setBounds(190,0, 60,40);
        save.setText("Save");

        reset = new JButton();
        reset.setBounds(250,0, 60,40);
        reset.setText("Reset");

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
        this.add(resume);
        this.add(save);
        this.add(reset);
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
