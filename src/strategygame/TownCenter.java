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
public class TownCenter extends CreatingBuildingUnit implements Serializable{
    private static int TownCentersCreated = 0, TownCentersDestroyed = 0;

    public TownCenter(int Civilization_no){
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
        name = "TownCenter";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.TownCenter(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 384;
        height = 256;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\TownCenter.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myTownCenters.add(this);
        TownCentersCreated++;
    }
    
    public void createWorker() throws InterruptedException{
        if(checkPopulation()){
            if(GUI.Forms.MyFrame.U.game.getMyGold() >= Worker.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= Worker.getCostFood())
            {
                Worker w = new Worker(GUI.Map.myCivilization_no);
                Thread.sleep(1000);
                w.create(this);
                GUI.Forms.MyFrame.myClient.sendCreate(w.name, w.L);

                JOptionPane.showMessageDialog(null, "Worker Created");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not enough Resources.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You need to build more houses.");
        }
    }
    
    public void createCharacter() {
        try {
            createWorker();
        } catch (InterruptedException ex) {
            Logger.getLogger(TownCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        TownCentersDestroyed++;
        GUI.Forms.MyFrame.U.game.myTownCenters.remove(this);
    }
     
    
}
