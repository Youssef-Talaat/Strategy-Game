/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static strategygame.Unit.costGold;

/**
 *
 * @author Youssef
 */
public class Arrow extends AttackingUnit{
    private double xSpeed, ySpeed;
    
    public void Arrow(){
    
        name = "Arrow";
        width = 20;
        height = 20;
        shape = new JLabel();
        shape.setSize(width, height);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\arrow.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
    }
    
    public void move(Location l){};
}
