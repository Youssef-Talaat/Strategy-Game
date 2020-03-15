/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

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
public class SignUp extends JPanel{
    public JButton signup = new JButton("SignUp");
    public JButton back = new JButton("Back");
    public JTextField name_text = new JTextField();
    public JTextField username_text = new JTextField();
    public JPasswordField password_text = new JPasswordField();
    public JPasswordField renterPassword_text = new JPasswordField();
    public JLabel name_label = new JLabel("Name:");
    public JLabel username_label = new JLabel("Username:");
    public JLabel password_label = new JLabel("Password:");
    public JLabel renterPassword_label = new JLabel("Renter Password:");
    public JLabel Background = new JLabel();
    
    public SignUp(){
        setSize(1370 ,1536);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1365, 767);
        
        name_label.setBounds(510, 200, 100, 25);
        username_label.setBounds(name_label.getBounds().x, name_label.getBounds().y + 40, 100, 25);
        password_label.setBounds(username_label.getBounds().x, username_label.getBounds().y + 40, 100, 25);
        renterPassword_label.setBounds(password_label.getBounds().x, password_label.getBounds().y + 40, 160, 25);
        
        name_label.setFont(new Font("Serif", Font.PLAIN, 20));
        username_label.setFont(new Font("Serif", Font.PLAIN, 20));
        password_label.setFont(new Font("Serif", Font.PLAIN, 20));
        renterPassword_label.setFont(new Font("Serif", Font.PLAIN, 20));
        name_label.setForeground(Color.WHITE);
        username_label.setForeground(Color.WHITE);
        password_label.setForeground(Color.WHITE);
        renterPassword_label.setForeground(Color.WHITE);
        
        add(name_label);
        add(username_label);
        add(password_label);
        add(renterPassword_label);
        
        
        name_text.setBounds(renterPassword_label.getBounds().x + renterPassword_label.getSize().width, name_label.getBounds().y, 150, 25);
        username_text.setBounds(renterPassword_label.getBounds().x + renterPassword_label.getSize().width, username_label.getBounds().y, 150, 25);
        password_text.setBounds(renterPassword_label.getBounds().x + renterPassword_label.getSize().width, password_label.getBounds().y, 150, 25);
        renterPassword_text.setBounds(renterPassword_label.getBounds().x + renterPassword_label.getSize().width, renterPassword_label.getBounds().y, 150, 25);
        
        add(name_text);
        add(username_text);
        add(password_text);
        add(renterPassword_text);
        
        signup.setBounds(renterPassword_label.getBounds().x + 35, renterPassword_label.getBounds().y + 50, 80, 30);
        back.setBounds(signup.getBounds().x + 150, signup.getBounds().y, 80, 30);
        add(signup);
        add(back);
        add(Background);
        
        signup.addActionListener(new ButtonWatcher());
        back.addActionListener(new ButtonWatcher());
    }
    private class ButtonWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(signup))
            {
                if(!"".equals(name_text.getText()) && !"".equals(username_text.getText()) && !"".equals(password_text.getText()) && password_text.getText().equals(renterPassword_text.getText()))
                {
                    MyFrame.U = new strategygame.User();
                    MyFrame.U.setName(name_text.getText());
                    MyFrame.U.setUsername(username_text.getText());
                    MyFrame.U.setPassword(password_text.getText());
                    
                    if(MyFrame.U.signUp()){
                        try {
                            strategygame.User.saveUsers();
                        } catch (IOException ex) {
                            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        MyFrame.form_SignUp.setVisible(false);
                        MyFrame.form_NewGame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "This username is taken, please try again");
                    }
                    
                    MyFrame.form_SignUp.username_text.setText(null);
                    MyFrame.form_SignUp.name_text.setText(null);
                    MyFrame.form_SignUp.password_text.setText(null);
                    MyFrame.form_SignUp.renterPassword_text.setText(null);
                }
                else
                {
                    if(password_text.getText().equals(renterPassword_text.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill all the required fields...");
                        password_text.setText(null);
                        renterPassword_text.setText(null);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The 2 passwords doesnot match");
                        password_text.setText(null);
                        renterPassword_text.setText(null);
                    }
                }
            }
            else if(buttonPressed.equals(back))
            {
                MyFrame.form_SignUp.setVisible(false);
                MyFrame.form_HomePage.setVisible(true);
            }
        }
    }
}
