/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Youssef
 */
public abstract class MyObject {
    public JPanel AB;
    public JPanel IB;
    public JLabel shape;
    public JLabel dot;
    public int width,height;
    public String name;
    public Location L;
    public boolean canMove;
    public String action;
    
    public void Constructor(int Civilization_no){
        shape = new JLabel();
        shape.setSize(width, height);
        dot = new JLabel();
        dot.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Dot.png").getImage().getScaledInstance(7, 7, Image.SCALE_DEFAULT)));
    }
    
    public void Constructor(){
        shape = new JLabel();
        shape.setSize(width, height);
        dot = new JLabel();
    }
    
    public void selfDestroy(){
        GUI.Forms.MyFrame.MAP.remove(this);
        GUI.Forms.MyFrame.MAP.select(null);
        GUI.Forms.MyFrame.MAP.realMap.remove(this.shape);
        GUI.Forms.MyFrame.MAP.boxesPanel.remove(this.AB);
        GUI.Forms.MyFrame.MAP.boxesPanel.remove(this.IB);
        GUI.Forms.MyFrame.MAP.miniMap.remove(this.dot);
        GUI.Forms.MyFrame.MAP.repaint();
        GUI.Forms.MyFrame.MAP.statusBar.update();
    }
}
