/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public abstract class AttackingUnit extends Unit{
    protected int attackingPower, attackingRange, attackingRate;
    public GUI.AU_Actions doing;

    public void Constructor(int Civilization_no){
        super.Constructor(Civilization_no);
        IB = new GUI.InfoBox.AttackingUnit(this);
        doing = GUI.AU_Actions.nothing;
    }
    
    //Getters : 
    public int getAttackingPower() {
        return attackingPower;
    }

    public int getAttackingRange() {
        return attackingRange;
    }

    public int getAttackingRate() {
        return attackingRate;
    }

    
    
    
    public void create(CreatingBuildingUnit cbu)
    {
        //Increment the currentPopulation : 
        GUI.Forms.MyFrame.U.game.setPopulation(GUI.Forms.MyFrame.U.game.getPopulation() + 1);
        
        super.create();
    }
    
    public void attack(Unit u){
//        if(u.civilization_no != this.civilization_no)//to ensure that its attacking an enemy
//        {
            doing = GUI.AU_Actions.attacking;
            Thread attack = new Thread(){
                public void run(){
                    while(u.currentHealth > 0 && AttackingUnit.this.doing.equals(GUI.AU_Actions.attacking)) 
                    {
                        try {
                            this.sleep(attackingRate);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        u.setCurrentHealth(u.currentHealth - AttackingUnit.this.attackingPower);
                        ((GUI.InfoBox.Unit)(u.IB)).updateIB();
                    }
                    if(u.currentHealth == 0)
                    {
                        u.selfDestroy();
                    }
                    doing = GUI.AU_Actions.nothing;
                }
            };
            attack.start();
        
    }
    
    public void selfDestroy(){
        GUI.Forms.MyFrame.U.game.setPopulation(GUI.Forms.MyFrame.U.game.getPopulation() - 1);
        super.selfDestroy();
    }
    
    public void stopAttack(){
        doing = GUI.AU_Actions.nothing;
    }
    
    public void upgrade(){}
    
//    public void checkRange(Unit u){}
}
