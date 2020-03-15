/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author mahmo
 */
public class MiniMap extends JPanel{
    
    public static JLabel mini = new JLabel();
    public static JLabel dot = new JLabel();
    
    public MiniMap(String type){
        setLayout(null);
        setBounds((1365/3), 0, 1365/3, 240);
        mini.setBounds(5, 6, 444, 227);
        mini.setIcon(new ImageIcon(new ImageIcon("Pics\\Maps\\" + type + ".png").getImage().getScaledInstance(444, 227, Image.SCALE_DEFAULT)));
        add(mini);
        
    }
    
    public void addDots(int xLoc, int yLoc, strategygame.MyObject O){        //Adds a dot on the miniMap to represent this unit.
        O.dot.setBounds(xLoc/9, yLoc/11, 10, 10);
        mini.add(O.dot);
    }
}
