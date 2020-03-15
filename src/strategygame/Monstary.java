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
public class Monstary extends CreatingBuildingUnit implements Serializable{
    private int monstariesCreated = 0, monstariesDestroyed = 0;
    
    public Monstary(int Civilization_no){
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
        name = "Monstary";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.Monstary(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 318;
        height = 277;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Monstary.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(Location loc) {
        super.create(loc);
        GUI.Forms.MyFrame.U.game.myMonstarys.add(this);
        monstariesCreated++;
    }
    
    public void createPriest() throws InterruptedException{
        if(checkPopulation()){
            if(GUI.Forms.MyFrame.U.game.getMyGold()>= Priest.getCostGold() && GUI.Forms.MyFrame.U.game.getMyFood() >= Priest.getCostFood()) // added by revisor.
            {
                Priest p = new Priest(GUI.Map.myCivilization_no);
                Thread.sleep(1000);
                p.create(this);
                GUI.Forms.MyFrame.myClient.sendCreate(p.name, p.L);
                JOptionPane.showMessageDialog(null, "Priest Created.");
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
            createPriest();
        } catch (InterruptedException ex) {
            Logger.getLogger(Monstary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        monstariesDestroyed++;
        GUI.Forms.MyFrame.U.game.myMonstarys.remove(this);
    }
}
