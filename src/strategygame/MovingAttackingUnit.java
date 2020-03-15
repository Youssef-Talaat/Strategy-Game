/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public abstract class MovingAttackingUnit extends AttackingUnit{
    public static int slowSpeed = 18;
    public static int normalSpeed = 14;
    public static int highSpeed = 10;
    protected int speed;
    protected boolean isMoving = true;
    private Thread moving;
    
    public MovingAttackingUnit(){
        
    }
    
    public MovingAttackingUnit(int Civilization_no){
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.AttackingUnit(this);
        }
        else{
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        
    }
    
    public void Constructor(int Civilization_no){
        super.Constructor(Civilization_no);
        canMove = true;
    }
    
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        
        L = new Location();
        
        //Create new Location "loc" : 
        Location loc = new Location();
        
        //Then we make loc = setMarker of the cbu
        loc.setxPosition(cbu.setMarker.getxPosition());
        loc.setyPosition(cbu.setMarker.getyPosition());
        
        //Then we made a while loop to decide where to put this unit :
        while(GUI.Forms.MyFrame.MAP.Map[loc.getxPosition()][loc.getyPosition()] != null)
        {
            loc.setxPosition(loc.getxPosition() + width, this);
        }
        
        //Then we make the location "L" of this unit equals "loc" : 
        L.setxPosition(loc.getxPosition(), this);
        L.setyPosition(loc.getyPosition(), this);
        GUI.Forms.MyFrame.MAP.ADD(this, L);
    }
    
    
    public boolean isIsMoving() {
        return isMoving;
    }
    
    public void move(Location l){
        int x1 , x2 , y1 , y2;
        x1 = L.getxPosition();
        y1 = L.getyPosition();
        x2 = l.getxPosition();
        y2 = l.getyPosition();
        
        double theta , r;
        
        theta = Math.atan2((y2 - y1) , (x2 - x1));
        r = Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));

//        System.out.println(x1 + " , " + y1);
//        System.out.println(x2 + " , " + y2);
//        System.out.println(r);
//        System.out.println("Theta = " + theta);
        
        moving = new Thread(){
            int x , y;
            int i = 0;
            public void run(){
                doing = GUI.AU_Actions.moving;
                while(i < r && MovingAttackingUnit.this.doing.equals(GUI.AU_Actions.moving)){
                    x = (int)(i * Math.cos(theta));
                    y = (int)(i * Math.sin(theta));
                    
                    L.setxPosition(x1 + x , MovingAttackingUnit.this);
                    L.setyPosition(y1 + y , MovingAttackingUnit.this);
                    
                    GUI.Forms.MyFrame.MAP.reLocate(MovingAttackingUnit.this, L);
                    //System.out.println("" + L.getxPosition() + " , " + L.getyPosition());
                    
                    try {
                        sleep(speed);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MovingAttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        moving.start();
        doing = GUI.AU_Actions.nothing;
    }
    
    
    
//    public void collide(Location a , Location l) throws InterruptedException
//    {
//        if(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width + 1][a.yPosition + shape.getBounds().height - 20] != null)
//        {
//            stopMove();
//            while(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width + 1][a.yPosition + shape.getBounds().height - 20] != null)
//            {
//                a.yPosition--;
//
//                for(int j = shape.getBounds().x ; j < shape.getBounds().x + shape.getBounds().width ; j++)
//                {
//                    for(int z = shape.getBounds().y ; z < shape.getBounds().y + shape.getBounds().height ; z++)
//                    {
//                        GUI.Forms.MyFrame.MAP.Map[j][z] = null;
//                    }
//                }
//
//                L.xPosition = a.xPosition;
//                L.yPosition = a.yPosition;
//
//                GUI.Forms.MyFrame.MAP.ADD(this, a);
//                try {
//                    Thread.sleep(10);
//
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MovingAttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                move(l);
//            }
//        }
//        else if(GUI.Forms.MyFrame.MAP.Map[a.xPosition - 1][a.yPosition + shape.getBounds().height - 20] != null)
//        {
//            stopMove();
//            while(GUI.Forms.MyFrame.MAP.Map[a.xPosition - 1][a.yPosition + shape.getBounds().height - 20] != null)
//            {
//                a.yPosition--;
//
//                for(int j = shape.getBounds().x ; j < shape.getBounds().x + shape.getBounds().width ; j++)
//                {
//                    for(int z = shape.getBounds().y ; z < shape.getBounds().y + shape.getBounds().height ; z++)
//                    {
//                        GUI.Forms.MyFrame.MAP.Map[j][z] = null;
//                    }
//                }
//
//                L.xPosition = a.xPosition;
//                L.yPosition = a.yPosition;
//
//                GUI.Forms.MyFrame.MAP.ADD(this, a);
//                try {
//                    Thread.sleep(10);
//
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MovingAttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                move(l);
//            }
//        }
//        else if(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width][a.yPosition - 1] != null)
//        {
//            stopMove();
//            while(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width][a.yPosition - 1] != null)
//            {
//                a.xPosition--;
//
//                for(int j = shape.getBounds().x ; j < shape.getBounds().x + shape.getBounds().width ; j++)
//                {
//                    for(int z = shape.getBounds().y ; z < shape.getBounds().y + shape.getBounds().height ; z++)
//                    {
//                        GUI.Forms.MyFrame.MAP.Map[j][z] = null;
//                    }
//                }
//
//                L.xPosition = a.xPosition;
//                L.yPosition = a.yPosition;
//
//                GUI.Forms.MyFrame.MAP.ADD(this, a);
//                try {
//                    Thread.sleep(10);
//
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MovingAttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                move(l);
//            }
//        }
//        else if(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width][a.yPosition + shape.getBounds().height + 1] != null)
//        {
//            stopMove();
//            while(GUI.Forms.MyFrame.MAP.Map[a.xPosition + shape.getBounds().width][a.yPosition + shape.getBounds().height + 1] != null)
//            {
//                a.xPosition--;
//
//                for(int j = shape.getBounds().x ; j < shape.getBounds().x + shape.getBounds().width ; j++)
//                {
//                    for(int z = shape.getBounds().y ; z < shape.getBounds().y + shape.getBounds().height ; z++)
//                    {
//                        GUI.Forms.MyFrame.MAP.Map[j][z] = null;
//                    }
//                }
//
//                L.xPosition = a.xPosition;
//                L.yPosition = a.yPosition;
//
//                GUI.Forms.MyFrame.MAP.ADD(this, a);
//                try {
//                    Thread.sleep(10);
//
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MovingAttackingUnit.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                move(l);
//            }
//        }
//    }
    
    public void stopMove(){
        isMoving = false;
    }
}
    
