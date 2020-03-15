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
public class Archer extends MovingAttackingUnit implements Serializable{
    private static int archersCreated = 0, archersKilled = 0;

    //Constructor : 
    public Archer(int Civilization_no){
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
        name = "Archer";
        width = 27;
        height = 45;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Archer.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    //Getters : 
    public static int getArchersCreated() {
        return archersCreated;
    }

    public static int getArchersKilled() {
        return archersKilled;
    }
    
    //Functions : 
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        GUI.Forms.MyFrame.U.game.myArchers.add(this);
        archersCreated++;
    }
    
//    public void attack(Unit u){
////        isAttacking = true;
////        while(u.getCurrentHealth() > 0 && isAttacking == true && u.civilizationID != User.UnitsID)
////        {
////            checkRange(u);
////            Arrow a = new Arrow();
////            fireArrow(a, u);
////            Thread.sleep(attackingRate);
////            u.damage(this);
////            if(u.getCurrentHealth() <= 0)
////            {
////                Thread.sleep(1500);
////                u.remove(u);    //to remove the object from the map when killed or destroyed
////            }
////        }
//    }
    
//    public void checkRange(Unit u){
//       int rounds;
//        rounds = L.yPosition - u.L.yPosition;
//        if(rounds < 0)
//            rounds *= -1;
//        isMoving = true;
//        for(int i=0;i<rounds;i++)
//        {
//            while(isMoving == true)
//            {
//                if(L.yPosition < u.L.yPosition)
//                {
//                    L.yPosition++;
//                }
//                else if(L.yPosition > u.L.yPosition)
//                {
//                    L.yPosition--;
//                }
//            }
//        }
//        attack(u);
//    }
    
    public void fireArrow(Arrow a, Unit u){
        a.move(u.L);
        //u.damage(this);
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        archersKilled++;
        GUI.Forms.MyFrame.U.game.myArchers.remove(this);
    }
}
