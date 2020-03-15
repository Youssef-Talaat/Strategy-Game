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
import javax.swing.JOptionPane;

/**
 *
 * @author Youssef
 */
public class SiegeWorkshop extends CreatingBuildingUnit implements Serializable{
    private static int siegeWorkshopsCreated = 0, siegeWorkshopsDestroyed = 0;
    
    public SiegeWorkshop(int Civilization_no){
        switch (GUI.Forms.MyFrame.U.game.getUpgradeLevel()) {
            case 0:
                mainHealth = 100;
                defense = 0.15;
                creatingRate = 10;
                setMarker = null;
                break;
            case 1:
                mainHealth = 100;
                defense = 0.15;
                creatingRate = 10;
                setMarker = null;
                break;
            case 2:
                mainHealth = 100;
                defense = 0.15;
                creatingRate = 10;
                setMarker = null;
                break;
        }
        name = "SiegeWorkshop";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.SiegeWorkshop(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 380;
        height = 273;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\SiegeWorkshop.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.mySiegeWorkshops.add(this);
        siegeWorkshopsCreated++;
    }
    
    public void createSiegeRam() throws InterruptedException{
        if(checkPopulation()){
            if(GUI.Forms.MyFrame.U.game.getMyGold() >= SiegeRam.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= SiegeRam.getCostFood()) // added by revisor.
            {
                SiegeRam s = new SiegeRam(GUI.Map.myCivilization_no);
                Thread.sleep(1000);
                s.create(this); //added by revisor
                GUI.Forms.MyFrame.myClient.sendCreate(s.name, s.L);
                JOptionPane.showMessageDialog(null, "SiegeRam Created.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You need to build more houses.");
        }
    }
    
    public void createCharacter() {
        try {
            createSiegeRam();
        } catch (InterruptedException ex) {
            Logger.getLogger(SiegeWorkshop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        siegeWorkshopsDestroyed++;
        GUI.Forms.MyFrame.U.game.mySiegeWorkshops.remove(this);
    }
}
