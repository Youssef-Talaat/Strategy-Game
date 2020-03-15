/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

import GUI.Forms.MyFrame;

/**
 *
 * @author Youssef
 */
public class BuildingUnit extends Unit{
    public strategygame.BuildingUnit bu;
    
    public BuildingUnit(strategygame.BuildingUnit BU){
        super();
        bu = BU;
        
        name.setText(""+bu.name);
        health.setText("Health:            "+bu.getCurrentHealth());
        defense.setText("Defence:          "+bu.getDefense());
        upgradeLevel.setText("Upgrade Level:     "+MyFrame.U.game.getUpgradeLevel());
        addImg();
    }
    
    public void updateIB(){
        health.setText("Health:            "+bu.getCurrentHealth());
        defense.setText("Defence:          "+bu.getDefense());
        upgradeLevel.setText("Upgrade Level:     "+MyFrame.U.game.getUpgradeLevel());
    }
}
