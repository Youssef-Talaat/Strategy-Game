/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

import javax.swing.JLabel;

/**
 *
 * @author Youssef
 */
public abstract class Unit extends MyObject{
    public JLabel defense = new JLabel();
    public JLabel upgradeLevel = new JLabel();
    
    public Unit(){
        super();
        defense.setBounds(health.getBounds().x, health.getBounds().y + 50, 180, 30);
        upgradeLevel.setBounds(health.getBounds().x, defense.getBounds().y + 50, 180, 30);
        
        add(defense);
        add(upgradeLevel);
    }
}
