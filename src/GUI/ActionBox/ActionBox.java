/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ActionBox;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public class ActionBox extends JPanel{
    public JLabel img = new JLabel();
    
    public ActionBox(){
        setLayout(null);
        setBounds((1365/3)*2, 0, (1365/3) + 1, 240);
        img.setIcon(new ImageIcon(new ImageIcon("Pics\\ActionBox.png").getImage().getScaledInstance(456, 240, Image.SCALE_SMOOTH)));
        img.setBounds(0, 0, 456, 240);
//        setBackground(Color.DARK_GRAY);
        addImg();
    }
    
    public void addImg(){
        add(img);
    }
}
