/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

/**
 *
 * @author Youssef
 */
public abstract class BuildingUnit extends Unit{
    
    public void Constructor(int Civilization_no){
        super.Constructor(Civilization_no);
        IB = new GUI.InfoBox.BuildingUnit(this);
        canMove = false;
    }
    
    public void create(Location loc){
        super.create();
        
        //Create location "L" of this unit and give it values of the given Location "loc" from the worker : 
        L = new Location();
        L.setxPosition(loc.getxPosition(), this);
        L.setyPosition(loc.getyPosition(), this);
        GUI.Forms.MyFrame.MAP.ADD(this, L);
    }
    
    public void upgrade(){}
}
