/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Youssef
 */
public class Credits extends JPanel{
    public JLabel madeBy = new JLabel(" Made By : ");
    public JLabel name1 = new JLabel(" FOAD OSAMA");
    public JLabel name2 = new JLabel(" MAHMOUD HAZEM ");
    public JLabel name3 = new JLabel(" MOHAMED ALAA ");
    public JLabel name4 = new JLabel(" YOUSSEF TALAAT ");
    public JButton Back =new JButton(" Back ");
    public JLabel Background = new JLabel();
    
    public Credits(){
        Back.setFont(new Font("Calibri",Font.BOLD,38));

        setSize(1370 ,1536);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1365, 767);
        
        Back.setBounds(400,650,300,60);
        Back.setBackground(Color.DARK_GRAY);
        Back.setForeground(Color.yellow);

        madeBy.setBounds(400,100,300,300);
        name1.setBounds(400,200,300,300);
        name2.setBounds(400,250,300,300);
        name3.setBounds(400,300,300,300);
        name4.setBounds(400,350,300,300);
        name1.setForeground(Color.BLUE);
        name2.setForeground(Color.BLUE);
        name3.setForeground(Color.BLUE);
        name4.setForeground(Color.BLUE);

        madeBy.setFont(new Font("Serif",Font.BOLD,38));
        name1.setFont(new Font("Calibri",Font.PLAIN,28));
        name2.setFont(new Font("Calibri",Font.PLAIN,28));
        name3.setFont(new Font("Calibri",Font.PLAIN,28));
        name4.setFont(new Font("Calibri",Font.PLAIN,28));

        add(madeBy);
        add(name1);
        add(name2);
        add(name3);
        add(name4);
        add(Back);
        add(Background);
        
        Back.addActionListener(new ButtonWatcher());
    }
    
    private class ButtonWatcher implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MyFrame.form_Credits.setVisible(false);
            MyFrame.form_MainMenu.setVisible(true);
        }
    }
}
