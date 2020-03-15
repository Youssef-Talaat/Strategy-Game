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
public class StoneBlock extends Resource{
    private int stoneCollected, stoneSpent;
    
    public StoneBlock(Location loc) {
        mainQuantity = 100;
        name = "StoneBlock";
        width = 71;
        height = 38;
        super.Constructor(loc);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\StoneBlock.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        dot.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Dot\\StoneBlock.png").getImage().getScaledInstance(7, 7, Image.SCALE_SMOOTH)));
    }
    
    public void collect(Worker w){
        this.currentQuantity -= w.getCollectingPower();
        GUI.Forms.MyFrame.U.game.setMyStone(GUI.Forms.MyFrame.U.game.getMyStone() + w.getCollectingPower());
        GUI.Map.statusBar.currentStone.setText("" + GUI.Forms.MyFrame.U.game.getMyStone());
    }

    public int getStoneCollected() {
        return stoneCollected;
    }

    public void setStoneCollected(int stoneCollected) {
        this.stoneCollected = stoneCollected;
    }

    public int getStoneSpent() {
        return stoneSpent;
    }

    public void setStoneSpent(int stoneSpent) {
        this.stoneSpent = stoneSpent;
    }
    public void addToStoneCollected() {
        stoneCollected++;
    }
    public void addToStoneSpent() {
        stoneSpent++;
    }

}
