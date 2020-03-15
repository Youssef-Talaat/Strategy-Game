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
public class SiegeRam extends MovingAttackingUnit implements Serializable{
    private static int siegeRamCreated = 0, siegeRamDestroyed = 0;
    
    public SiegeRam(int Civilization_no){
        super(Civilization_no);
        switch (GUI.Forms.MyFrame.U.game.getUpgradeLevel()) {
            case 0:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 60;
                attackingRate = 2;
                break;
            case 1:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 60;
                attackingRate = 2;
                break;
            case 2:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 60;
                attackingRate = 2;
                break;
        }
        speed = slowSpeed;
        attackingRange = 20;
        name = "SiegeRam";
        width = 92;
        height = 78;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\SiegeRam.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        GUI.Forms.MyFrame.U.game.mySiegeRams.add(this);
        siegeRamCreated++;
    }
    
    public static int getSiegeRamCreated() {
        return siegeRamCreated;
    }

    public static int getSiegeRamsDestroyed() {
        return siegeRamDestroyed;
    }
//   
//    public void checkRange(Unit u){
//        
//        double distance;
//        distance = Math.sqrt(Math.pow((u.L.xPosition - L.xPosition), 2) + Math.pow((u.L.yPosition - L.yPosition), 2));
//        while(distance < 50)
//        {
//            move(u.L);
//            attack(u);
//        }
//    }
    
    public void selfDestroy(){
        super.selfDestroy();
        siegeRamDestroyed++;
        GUI.Forms.MyFrame.U.game.mySiegeRams.remove(this);
    }
}
