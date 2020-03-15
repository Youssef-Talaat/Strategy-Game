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
public class House extends BuildingUnit implements Serializable{
    private static int housesCreated = 0, housesDestroyed = 0;
    
    public House(int Civilization_no){
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
        name = "House";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.ActionBox();
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 199;
        height = 146;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\House.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myHouses.add(this);
        housesCreated++;
        
        //Increase the population : 
        GUI.Forms.MyFrame.U.game.setMaxPopulation(GUI.Forms.MyFrame.U.game.getMaxPopulation() + 10);
        
        //Update the population in the status bar : 
        GUI.Map.statusBar.maxPopulation.setText("" + GUI.Forms.MyFrame.U.game.getMaxPopulation());
    }
    
    public static int getHousesCreated() {
        return housesCreated;
    }

    public static void setHousesCreated(int housesCreated) {
        House.housesCreated = housesCreated;
    }

    public static int getHousesDestroyed() {
        return housesDestroyed;
    }

    public static void setHousesDestroyed(int housesDestroyed) {
        House.housesDestroyed = housesDestroyed;
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        housesDestroyed++;
        GUI.Forms.MyFrame.U.game.myHouses.remove(this);
    }
}
