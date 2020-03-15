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
public class Barrack extends CreatingBuildingUnit implements Serializable{
    private static int barracksCreated = 0, barracksDestroyed = 0;
    
    //Constructor : 
    public Barrack(int Civilization_no){
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
        name = "Barrack";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.Barrack(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 325;
        height = 257;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Barrack.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    //Getters :
    public static int getBarracksCreated() {
        return barracksCreated;
    }

    public static int getBarracksDestroyed() {
        return barracksDestroyed;
    }
    
    
    //Functions : 
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myBarracks.add(this);
        barracksCreated++;
    }
    
    public void createSoldier() throws InterruptedException{
        if(checkPopulation()){
            if (GUI.Forms.MyFrame.U.game.getMyGold() >= Soldier.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= Soldier.getCostFood()) // (was missing) to check whether ai have enough resources or not. 
            {
                Soldier s = new Soldier(GUI.Map.myCivilization_no);
                Thread.sleep(1000);            
                s.create(this);
                GUI.Forms.MyFrame.myClient.sendCreate(s.name, s.L);
                JOptionPane.showMessageDialog(null, "Soldier Created.");
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
            createSoldier();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barrack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        barracksDestroyed++;
        GUI.Forms.MyFrame.U.game.myBarracks.remove(this);
    }
}
