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
public class Location {
    private int xPosition, yPosition;

    public Location(){
        
    }
    
    public Location(int x , int y){
        xPosition = x;
        yPosition = y;
    }
    
    //Setters :
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setxPosition(int xPosition, MyObject O) {
        if(xPosition < 0){
            this.xPosition = 0;
        }
        else if(xPosition > (GUI.Map.mapWidth - O.width)){
            this.xPosition = GUI.Map.mapWidth - O.width;
        }
        else{
            this.xPosition = xPosition;
        }
    }

    public void setyPosition(int yPosition , MyObject O) {
        if(yPosition < 0){
            this.yPosition = 0;
        }
        else if(yPosition > (GUI.Map.mapHeight - O.height)){
            this.yPosition = GUI.Map.mapHeight - O.height;
        }
        else{
            this.yPosition = yPosition;
        }
    }
    
    //Getters : 
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
    
    //Functions : 
    public void setLocation(Location l){}
}