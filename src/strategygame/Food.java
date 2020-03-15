/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Youssef
 */
public class Food extends Resource{
    private int foodCollected, foodSpent;
    private int regenerationTime; 
    
    //Constructor : 
    public Food(Location loc) {
        name = "Food";
        mainQuantity = 100;
        regenerationTime = 60000;
        width = 66;
        height = 48;
        super.Constructor(loc);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Food.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        dot.setIcon(new ImageIcon(new ImageIcon("Pics\\Resources\\Dot\\Food.png").getImage().getScaledInstance(7, 7, Image.SCALE_SMOOTH)));
    }

    //Setters :
    public void setRegenerationTime(int regenerationTime) {
        this.regenerationTime = regenerationTime;
    }
    
    public void setFoodCollected(int foodCollected) {
        this.foodCollected = foodCollected;
    }

    public void setFoodSpent(int foodSpent) {
        this.foodSpent = foodSpent;
    }

    //Getters :
    public int getFoodCollected() {
        return foodCollected;
    }

    public int getFoodSpent() {
        return foodSpent;
    }

    public int getRegenerationTime() {
        return regenerationTime;
    }
    
    //Functions :
    public void collect(Worker w){
        this.currentQuantity -= w.getCollectingPower();
        GUI.Forms.MyFrame.U.game.setMyFood(GUI.Forms.MyFrame.U.game.getMyFood() + w.getCollectingPower());
        GUI.Map.statusBar.currentFood.setText("" + GUI.Forms.MyFrame.U.game.getMyFood());
    }
    
    public void regenerate() throws InterruptedException {
        if(currentQuantity == 0)
        {
            Thread.sleep(regenerationTime);     //wait 60 seconds before food is generated again
            currentQuantity = mainQuantity;
        }
    }
    
    public void addToFoodCollected() {
        foodCollected++;
    }
    
    public void addToFoodSpent() {
        foodSpent++;
    }
}
