/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Youssef
 */
public class Market extends BuildingUnit implements Serializable{
    private int marketsCreated = 0, marketsDestroyed = 0;
    
    public Market(int Civilization_no){
        switch (GUI.Forms.MyFrame.U.game.getUpgradeLevel()) {
            case 0:
                mainHealth = 100;
                defense = 0.15;
                break;
            case 1:
                mainHealth = 100;
                defense = 0.15;
                break;
            case 2:
                mainHealth = 100;
                defense = 0.15;
                break;
        }
        name = "Market";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.Market(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 300;
        height = 300;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Market.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myMarkets.add(this);
        marketsCreated++;
    }
    
    public int localTrade(){
        return 0;
    }
    public void globalTrade(){
        
    }
    
    public void sellFood(){}
    public void sellStone(){}
    public void sellWood(){}
    public void buyFood(){}
    public void buyStone(){}
    public void buyWood(){}
    
    public void selfDestroy(){
        super.selfDestroy();
        marketsDestroyed++;
        GUI.Forms.MyFrame.U.game.myMarkets.remove(this);
    }
}
