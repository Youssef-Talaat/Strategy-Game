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
public class Stable extends CreatingBuildingUnit implements Serializable{
    private static int stablesCreated = 0, stablesDestroyed = 0;
    
    public Stable(int Civilization_no) {

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
        name = "Stable";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.Stable(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 298;
        height = 224;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Stable.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myStables.add(this);
        stablesCreated++;
    }

    public static int getStablesCreated() {
        return stablesCreated;
    }

    public static void setStablesCreated(int stablesCreated) {
        Stable.stablesCreated = stablesCreated;
    }

    public static int getStablesDestroyed() {
        return stablesDestroyed;
    }

    public static void setStablesDestroyed(int stablesDestroyed) {
        Stable.stablesDestroyed = stablesDestroyed;
    }
    
    public void createHorseman() throws InterruptedException {
        if(checkPopulation()){
            if (GUI.Forms.MyFrame.U.game.getMyGold() >= Horseman.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= Horseman.getCostFood())
            {
                Horseman h = new Horseman(GUI.Map.myCivilization_no);
                Thread.sleep(1000);
                h.create(this);
                GUI.Forms.MyFrame.myClient.sendCreate(h.name, h.L);
                JOptionPane.showMessageDialog(null, "Horsman Created.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You need to build more houses.");
        }
    }
    
    public void createCharacter() {
        try {
            createHorseman();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        stablesDestroyed++;
        GUI.Forms.MyFrame.U.game.myStables.remove(this);
    }
}
