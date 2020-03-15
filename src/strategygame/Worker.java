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
public class Worker extends MovingAttackingUnit implements Serializable{
    private int collectingPower, buildingPower, repairingPower;
    private int collectingRate, buildingRate, repairingRate;
    private static int workersCreated = 0, workersKilled = 0;
        
    public Worker(int Civilization_no){
        switch (GUI.Forms.MyFrame.U.game.getUpgradeLevel()) {
            case 0:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                collectingPower = 5;
                collectingRate = 500;
                buildingPower = 20;
                buildingRate = 5;
                repairingPower = 50;
                repairingRate = 10;
                break;
            case 1:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                collectingPower = 5;
                collectingRate = 4;
                buildingPower = 20;
                buildingRate = 5;
                repairingPower = 50;
                repairingRate = 10;
                break;
            case 2:
                mainHealth = 100;
                defense = 0.15;
                attackingPower = 30;
                attackingRate = 3000;
                collectingPower = 5;
                collectingRate = 4;
                buildingPower = 20;
                buildingRate = 5;
                repairingPower = 50;
                repairingRate = 10;
                break;
        }
        speed = normalSpeed;
        attackingRange = 20;
        name = "Worker";
        if(Civilization_no == GUI.Map.myCivilization_no){
            AB = new GUI.ActionBox.Worker(this);
        }
        else{   
            AB = new GUI.ActionBox.EnemyActionBox();
        }
        width = 17;
        height = 35;
        costGold = 20;
        costFood = 10;
        costWood = 0;
        costStone = 0;
        super.Constructor(Civilization_no);
        shape.setIcon(new ImageIcon(new ImageIcon("Pics\\Civilizations\\" + Civilization_no + "\\Worker.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    
    public void create(CreatingBuildingUnit cbu){
        super.create(cbu);
        GUI.Forms.MyFrame.U.game.myWorkers.add(this);
        workersCreated++;
    }
    
    public int getCollectingPower() {
        return collectingPower;
    }

    public int getBuildingPower() {
        return buildingPower;
    }

    public int getRepairingPower() {
        return repairingPower;
    }

    public int getCollectingRate() {
        return collectingRate;
    }

    public int getBuildingRate() {
        return buildingRate;
    }

    public int getRepairingRate() {
        return repairingRate;
    }
    
    public void collectResource(Resource r) throws InterruptedException{
        doing = GUI.AU_Actions.collecting;
        Thread collect = new Thread(){
            public void run(){
                while(r.currentQuantity > 0 && doing.equals(GUI.AU_Actions.collecting))
                {
                    r.collect(Worker.this);
                    ((GUI.InfoBox.Resource)(r.IB)).updateIB();
                    try {
                        this.sleep(collectingRate);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                doing = GUI.AU_Actions.nothing;
                if(r.currentQuantity == 0){
                    r.selfDestroy();
                }
            }
        };
        collect.start();
    }
    
    public void build(BuildingUnit bu) throws InterruptedException{
        if(checkPlacetoBuild(bu)){
            if(checkPopulation()){
                if(GUI.Forms.MyFrame.U.game.getMyGold() >= bu.getCostGold() &&
                   GUI.Forms.MyFrame.U.game.getMyWood() >= bu.getCostWood())
                {
                    doing = GUI.AU_Actions.building;
                    myBuild(bu);
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
        else{
            JOptionPane.showMessageDialog(null, "No Enough space.");
        }
    }
    
    
    private void myBuild(BuildingUnit bu) throws InterruptedException{
        Thread b = new Thread(){
            public void run(){
                while(doing == GUI.AU_Actions.building){
                    try {
                        sleep((long)(bu.mainHealth / Worker.this.buildingPower) * buildingRate);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //Create new Location "x" :
                    Location x = new Location();

                    //Make "x" equals worker's Location "L" :
                    x.setxPosition(L.getxPosition() + Worker.this.width, bu);
                    x.setyPosition(L.getyPosition(), bu);

                    //Then Create the bu in the Location of the worker :
                    bu.create(x);

                    JOptionPane.showMessageDialog(null, "" + bu.name + " Built.");
                    doing = GUI.AU_Actions.nothing;
                }
            }
        };
        b.start();
    }
   
//    public void buildArcheryRange() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildBarrack() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildHouse() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildGate() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildMarket() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildMonstary() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildSiegeWorkshop() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildStable() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildTower() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildTownCenter() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
//    
//    public void buildWall() throws InterruptedException{
//        if(checkPopulation()){
//            if(GUI.Forms.MyFrame.U.getMyGold() >= ArcheryRange.getCostGold() &&
//               GUI.Forms.MyFrame.U.getMyWood() >= ArcheryRange.getCostWood())
//            {
//                ArcheryRange bu = new ArcheryRange(civilization_no_toBuild);
//                build(bu);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Not Enough Resources.");
//            }
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "You need to build more houses.");
//        }
//    }
      
    public void repair(BuildingUnit bu) throws InterruptedException{
        if(bu.currentHealth < bu.mainHealth)
        {
            Thread repair = new Thread(){
                public void run(){
                    while(bu.currentHealth < bu.mainHealth){
                        bu.setCurrentHealth(bu.currentHealth + Worker.this.buildingPower);
                        ((GUI.InfoBox.BuildingUnit)(bu.IB)).updateIB();
                        try {
                            this.sleep(buildingRate);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            repair.start();
        }
    }
    
    public void selfDestroy(){
        super.selfDestroy();
        workersKilled++;
        GUI.Forms.MyFrame.U.game.myWorkers.remove(this);
    }
    
    private boolean checkPopulation(){
        return(GUI.Forms.MyFrame.U.game.getMaxPopulation() > GUI.Forms.MyFrame.U.game.getPopulation());
    }
    
//    public void move(Location l){
//        int x1 , x2 , y1 , y2;
//        x1 = L.getxPosition();
//        y1 = L.getyPosition();
//        x2 = l.getxPosition();
//        y2 = l.getyPosition();
//        
//        double theta , r;
//        
//        theta = Math.atan2((y2 - y1) , (x2 - x1));
//        r = Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
//        
////        System.out.println(x1 + " , " + y1);
////        System.out.println(x2 + " , " + y2);
////        System.out.println(r);
////        System.out.println("Theta = " + theta);
//        
//        moving = new Thread(){
//            int x , y , i;
//            public void run(){
//                while(i < r && MovingAttackingUnit.this)
//                for(i = 0 ; i < r ; i++){
//                    x = (int)(i * Math.cos(theta));
//                    y = (int)(i * Math.sin(theta));
//                    
//                    L.setxPosition(x1 + x);
//                    L.setyPosition(y1 + y);
//                    
//                    GUI.Forms.MyFrame.MAP.reLocate(Worker.this, L);
//                    //System.out.println("" + L.getxPosition() + " , " + L.getyPosition());
//                    
//                    try {
//                        sleep(15);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        };
//        moving.start();
//    }
    
    private boolean checkPlacetoBuild(BuildingUnit bu){
        int counter = 0;
        for(int i = this.shape.getX() + width ; i < this.shape.getX() + width + bu.width ; i++){
            for(int j = this.shape.getY() ; j < this.shape.getY() + bu.height ; j++){
                if(GUI.Forms.MyFrame.MAP.Map[i][j] == null)
                    counter++;
            }
        }
        if(counter == (bu.width * bu.height))
            return true;
        else
            return false;
    }
}
