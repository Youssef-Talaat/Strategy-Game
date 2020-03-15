/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Youssef
 */
public class Wood extends Resource{
    private int woodCollected, woodSpent;
    
    public Wood(Location loc) {
        mainQuantity = 100;
        name = "Wood";
        width = 86;
        height = 118;
        super.Constructor(loc);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Wood.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        dot.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Dot\\Wood.png").getImage().getScaledInstance(7, 7, Image.SCALE_SMOOTH)));
    }
    
    public void collect(Worker w){
        this.currentQuantity -= w.getCollectingPower();
        GUI.Forms.MyFrame.U.game.setMyWood(GUI.Forms.MyFrame.U.game.getMyWood() + w.getCollectingPower());
        GUI.Map.statusBar.currentWood.setText("" + GUI.Forms.MyFrame.U.game.getMyWood());
    }

    public int getWoodsCollected() {
        return woodCollected;
    }

    public void setWoodsCollected(int woodCollected) {
        this.woodCollected = woodCollected;
    }

    public int getWoodsSpent() {
        return woodSpent;
    }

    public void setWoodsSpent(int woodSpent) {
        this.woodSpent = woodSpent;
    }
    
    public void addToWoodsCollected()
    {
        woodCollected++;
    }
    public void addToWoodsSpent()
    {
        woodSpent++;
    }

}
