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
public abstract class Unit extends MyObject{
    protected static int costGold, costStone, costWood, costFood;
    protected int currentHealth, mainHealth;
    protected double defense;
    public int civilization_no;
    
    public void Constructor(int Civilization_no){
        super.Constructor(Civilization_no);
        action = "attackable";
        currentHealth = mainHealth;
        civilization_no = Civilization_no;
    }
    
    //Setters :
    public void setCurrentHealth(int currentHealth) {
        if(currentHealth < 0)
        {
            this.currentHealth = 0;
        }
        else if(currentHealth > mainHealth)
        {
            this.currentHealth = mainHealth;
        }
        else
        {
            this.currentHealth = currentHealth;
        }
    }
    
    
    //Getters : 
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public static int getCostGold() {
        return costGold;
    }

    public static int getCostStone() {
        return costStone;
    }

    public static int getCostWood() {
        return costWood;
    }

    public static int getCostFood() {
        return costFood;
    }

    public double getMainHealth() {
        return mainHealth;
    }

    public double getDefense() {
        return defense;
    }

    public Location getL() {
        return L;
    }

    
    //Functions : 
    public void create(){
        //Reduce the cost of this unit from the resources of the logged-in User : 
        GUI.Forms.MyFrame.U.game.setMyFood(GUI.Forms.MyFrame.U.game.getMyFood() - getCostFood());
        GUI.Forms.MyFrame.U.game.setMyGold(GUI.Forms.MyFrame.U.game.getMyGold() - getCostGold());
        GUI.Forms.MyFrame.U.game.setMyStone(GUI.Forms.MyFrame.U.game.getMyStone() - getCostStone());
        GUI.Forms.MyFrame.U.game.setMyWood(GUI.Forms.MyFrame.U.game.getMyWood() - getCostWood());
        
        //Update the Resources in the status bar : 
        GUI.Map.statusBar.update();
    }
    
    public void createByMap(){
        GUI.Forms.MyFrame.MAP.ADD(this, L);
    }
    
    abstract public void upgrade();
    
    
}
