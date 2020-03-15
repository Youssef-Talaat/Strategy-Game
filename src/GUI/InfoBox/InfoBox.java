/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public class InfoBox extends JPanel{
    public JLabel img = new JLabel();
    
    public InfoBox(){
        setLayout(null);
//        setBackground(Color.LIGHT_GRAY);
        setBounds(0, 0, 1365/3, 240);
        img.setIcon(new ImageIcon(new ImageIcon("Pics\\ActionBox.png").getImage().getScaledInstance(456, 240, Image.SCALE_SMOOTH)));
        img.setBounds(0, 0, 455, 240);
        addImg();
    }
    
    public void addImg(){
        add(img);
    }
    
}
