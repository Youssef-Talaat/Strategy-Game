/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Youssef
 */
public class Priest extends MovingAttackingUnit implements Serializable{
    private static int priestsCreated = 0, priestsKilled = 0;
    private int healingRate, healingPower;
 
    public Priest(int Civilization_no){
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
        speed = normalSpeed;
        attackingRange = 20;
        name = "Priest";
        width = 24;
        height = 42;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Priest.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public int getHealingRate() {
        return healingRate;
    }

    public int getHealingPower() {
        return healingPower;
    }
    
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        GUI.Forms.MyFrame.U.game.myPriests.add(this);
        priestsCreated++;
    }
    
    public static int getPriestsCreated() {
        return priestsCreated;
    }

    public static int getPriestsKilled() {
        return priestsKilled;
    }
    
    public void heal(Unit u) throws InterruptedException{
        if(true)//chech if this unit is from my army and if this unit is injured.
        {
            Thread heal = new Thread(){
                public void run(){
                    while(u.currentHealth < u.mainHealth){
                        u.setCurrentHealth(u.currentHealth + Priest.this.healingPower);
                        try {
                            this.sleep(Priest.this.healingRate);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Priest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            heal.start();
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        priestsKilled++;
        GUI.Forms.MyFrame.U.game.myPriests.remove(this);
    }
}
