/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Youssef
 */
public class NewGame extends JPanel{
    public JLabel Background = new JLabel();
    public JButton StartGame = new JButton("Start a Game");
    public JButton JoinGame = new JButton("Join a Game");
    
    public NewGame(){
        setSize(1370 ,768);
        
        setLayout(null);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1367, 767);
        
        StartGame.setBounds(458, 283, 200, 60);
        JoinGame.setBounds(708, 283, 200, 60);
        
        StartGame.setFont(new Font("Serif",Font.BOLD,20));
        JoinGame.setFont(new Font("Serif",Font.BOLD,20));
        
        add(StartGame);
        add(JoinGame);
        add(Background);
        
        StartGame.addActionListener(new ButtonWatcher());
        JoinGame.addActionListener(new ButtonWatcher());
    }
    private class ButtonWatcher implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(StartGame)){
                MyFrame.form_NewGame.setVisible(false);
                MyFrame.form_StartGame.setVisible(true);
            }
            else if(e.getSource().equals(JoinGame)){
                MyFrame.form_NewGame.setVisible(false);
                MyFrame.form_JoinGame.setVisible(true);
            }
        }
    }
}
