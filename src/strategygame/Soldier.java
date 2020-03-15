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
public class Soldier extends MovingAttackingUnit implements Serializable{
    private static int soldiersCreated = 0, soldiersKilled = 0;
    
    public Soldier(int Civilization_no){
        super(Civilization_no);
        switch (GUI.Forms.MyFrame.U.game.getUpgradeLevel()) {
            case 0:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                break;
            case 1:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                break;
            case 2:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                break;
        }
        speed = normalSpeed;
        attackingRange = 20;
        name = "Soldier";
        width = 29;
        height = 37;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Soldier.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        GUI.Forms.MyFrame.U.game.mySoldiers.add(this);
        soldiersCreated++;
    }
    
    public void checkRange(Unit u){
        
        double distance;
        distance = Math.sqrt(Math.pow((u.L.getxPosition() - L.getxPosition()), 2) + Math.pow((u.L.getyPosition() - L.getyPosition()), 2));
        while(distance < 50)
        {
            move(u.L);
            attack(u);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        soldiersKilled++;
        GUI.Forms.MyFrame.U.game.mySoldiers.remove(this);
    }
}
