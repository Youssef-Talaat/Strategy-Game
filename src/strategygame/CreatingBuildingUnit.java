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
public abstract class CreatingBuildingUnit extends BuildingUnit{
    protected int creatingRate, creatingPower;
    public Location setMarker;

    public void Constructor(int Civilization_no){
        super.Constructor(Civilization_no);
    }
    
    public void create(Location loc){
        super.create(loc);
        
        //Create Location "setMarker" where this unit will create its warriors : 
        setMarker = new Location();
        setMarker.setxPosition(L.getxPosition() + width + 50, this);
        setMarker.setyPosition(L.getyPosition() + height + 50, this);
    }
//    
//    public void setMarker(Location l){}
    
    public abstract void createCharacter(); 
    
    public boolean checkPopulation(){
        return(GUI.Forms.MyFrame.U.game.getMaxPopulation() > GUI.Forms.MyFrame.U.game.getPopulation());
    }
}
