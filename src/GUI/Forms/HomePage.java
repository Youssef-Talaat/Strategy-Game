/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import static GUI.Map.firstX;
import static GUI.Map.firstY;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Youssef
 */
public class HomePage extends JPanel{
    public JButton LogIn =new JButton(" LogIn ");
    public JButton SignUp =new JButton(" SignUp ");
    public JLabel Background = new JLabel();
    
    public HomePage(){
        setSize(1370 ,1536);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1365, 767);
        
        LogIn.setBounds(550,250,200,100);
        SignUp.setBounds(LogIn.getBounds().x,400,200,100);
        LogIn.setFont(new Font("Calibri",Font.BOLD,38));
        SignUp.setFont(new Font("Calibri",Font.BOLD,38));

        LogIn.setBackground(Color.BLACK);
        SignUp.setForeground(Color.RED);
        SignUp.setBackground(Color.BLACK);
        LogIn.setForeground(Color.GREEN);
    
        add(LogIn);
        add(SignUp);
        add(Background);
        
        LogIn.addActionListener(new ButtonWatcher());
        SignUp.addActionListener(new ButtonWatcher());
    }
    
    private class ButtonWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(LogIn))
            {
                MyFrame.form_HomePage.setVisible(false);
                MyFrame.form_LogIn.setVisible(true);
            }
            else if(buttonPressed.equals(SignUp))
            {
                MyFrame.form_HomePage.setVisible(false);
                MyFrame.form_SignUp.setVisible(true);
            }
        }
    }
}
