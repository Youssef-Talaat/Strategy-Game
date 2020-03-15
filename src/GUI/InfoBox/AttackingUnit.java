/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

import GUI.Forms.MyFrame;
import javax.swing.JLabel;

/**
 *
 * @author Youssef
 */
public class AttackingUnit extends Unit{
    public JLabel attack = new JLabel();
    
    public strategygame.AttackingUnit au;
    
    public AttackingUnit(strategygame.AttackingUnit AU){
        super();
        au = AU;
        attack.setBounds(health.getBounds().x, upgradeLevel.getBounds().y + 50, 180, 30);
        
        name.setText(""+au.name);
        health.setText("Health:            "+au.getCurrentHealth());
        attack.setText("Attack: :          "+au.getAttackingPower());
        defense.setText("Defence:          "+au.getDefense());
        upgradeLevel.setText("Upgrade Level:     "+MyFrame.U.game.getUpgradeLevel());
        
        add(attack);
        addImg();
    }
    
    public void updateIB(){
        health.setText("Health:            "+au.getCurrentHealth());
        attack.setText("Attack: :          "+au.getAttackingPower());
        defense.setText("Defence:          "+au.getDefense());
        upgradeLevel.setText("Upgrade Level:     "+MyFrame.U.game.getUpgradeLevel());
    }
}
