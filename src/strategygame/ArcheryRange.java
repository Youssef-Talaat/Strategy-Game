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
public class ArcheryRange extends CreatingBuildingUnit implements Serializable{
    private static int archeryRangesCreated = 0, archeryRangesDestroyed = 0;
    
    //Constructor : 
    public ArcheryRange(int Civilization_no){
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
        name = "Archery Range";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.ArcheryRange(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 319;
        height = 290;
        costGold = 100;
        costFood = 100;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\ArcheryRange.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }    
    //Getters :
    public static int getArcheryRangesCreated() {
        return archeryRangesCreated;
    }

    public static int getArcheryRangesDestroyed() {
        return archeryRangesDestroyed;
    }
    
    //Functions : 
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myArcheryRanges.add(this);
        archeryRangesCreated++;
    }
    
    public void createArcher() throws InterruptedException{
        if(checkPopulation()){
            if(GUI.Forms.MyFrame.U.game.getMyGold() >= Archer.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= Archer.getCostFood())
            {
                Archer a = new Archer(GUI.Map.myCivilization_no);
                Thread.sleep(1000);
                a.create(this);
                GUI.Forms.MyFrame.myClient.sendCreate(a.name, a.L);
                JOptionPane.showMessageDialog(null, "Archer Created.");
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
            createArcher();
        } catch (InterruptedException ex) {
            Logger.getLogger(ArcheryRange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        archeryRangesDestroyed++;
        GUI.Forms.MyFrame.U.game.myArcheryRanges.remove(this);
    }
}
