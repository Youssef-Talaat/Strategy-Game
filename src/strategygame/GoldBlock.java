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
public class GoldBlock extends Resource{
    private int goldCollected, goldSpent;
    
    public GoldBlock(Location loc) {
        mainQuantity = 100;//VALUE TO BE SET
        name = "GoldBlock";
        width = 77;
        height = 43;
        super.Constructor(loc);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\GoldBlock.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        dot.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Dot\\GoldBlock.png").getImage().getScaledInstance(7, 7, Image.SCALE_SMOOTH)));
    }
    
    public void collect(Worker w){
        this.currentQuantity -= w.getCollectingPower();
        GUI.Forms.MyFrame.U.game.setMyGold(GUI.Forms.MyFrame.U.game.getMyGold() + w.getCollectingPower());
        GUI.Map.statusBar.currentGold.setText("" + GUI.Forms.MyFrame.U.game.getMyGold());
    }

    public int getGoldCollected() {
        return goldCollected;
    }

    public void setGoldCollected(int GoldCollected) {
        this.goldCollected = GoldCollected;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int GoldSpent) {
        this.goldSpent = GoldSpent;
    }
    public void addToGoldCollected()
    {
        goldCollected++;
    }
    public void addToGoldSpent()
    {
        goldSpent++;
    }
}
