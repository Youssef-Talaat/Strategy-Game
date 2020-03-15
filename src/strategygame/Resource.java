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
public abstract class Resource extends MyObject{
    protected int currentQuantity, mainQuantity;
    
    public void Constructor(Location loc){
        super.Constructor();
        currentQuantity = mainQuantity;
        action = "collectable";
        AB = new GUI.ActionBox.ActionBox();
        IB = new GUI.InfoBox.Resource(this);
        AB.setVisible(false);
        IB.setVisible(false);
        L = new Location();
        L.setxPosition(loc.getxPosition(), this);
        L.setyPosition(loc.getyPosition(), this);
        GUI.Forms.MyFrame.MAP.ADD(this, L);
    }
    
    public int getMainQuantity() {
        return mainQuantity;
    }

    public void setMainQuantity(int mainQuantity) {
        this.mainQuantity = mainQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Location getL() {
        return L;
    }

    public void setL(Location L) {
        this.L = L;
    }
    
    public abstract void collect(Worker w);
    
//    public Worker collect(Worker W)//Not sure why will this function return object Worker
//    {
//        Worker W = new Worker();
//        W.collectResourses();
//        while(currentQuantity>0)
//        {
//            currentQuantity -= W.collectingPower;//This loop is to reduce the amount taken by the worker from the block until it reaches zero
//        }
//        //Call the destructor to remove the empty block from the map
//    }
}
