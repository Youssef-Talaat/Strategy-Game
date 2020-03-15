/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategygame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Youssef
 */
public class Game implements Serializable{
    private String mapType;
    private int myGold, myStone, myFood, myWood;
    private int population, maxPopulation;
    private int upgradeLevel;
    private int civilization_no;
    private User u;
    
    public ArrayList<Archer> myArchers;
    public ArrayList<ArcheryRange> myArcheryRanges;
    public ArrayList<Barrack> myBarracks;
    public ArrayList<Horseman> myHorsemen;
    public ArrayList<House> myHouses;
    public ArrayList<Market> myMarkets;
    public ArrayList<Monstary> myMonstarys;
    public ArrayList<Priest> myPriests;
    public ArrayList<SiegeRam> mySiegeRams;
    public ArrayList<SiegeWorkshop> mySiegeWorkshops;
    public ArrayList<Soldier> mySoldiers;
    public ArrayList<Stable> myStables;
    public ArrayList<TownCenter> myTownCenters;
    public ArrayList<Worker> myWorkers;
    public ArrayList<Resource> resourcesOnTheMap;
    
    public Game(){
        myArchers = new ArrayList<>();
        myArcheryRanges = new ArrayList<>();
        myBarracks = new ArrayList<>();
        myHorsemen = new ArrayList<>();
        myHouses = new ArrayList<>();
        myMarkets = new ArrayList<>();
        myMonstarys = new ArrayList<>();
        myPriests = new ArrayList<>();
        mySiegeRams = new ArrayList<>();
        mySiegeWorkshops = new ArrayList<>();
        mySoldiers = new ArrayList<>();
        myStables = new ArrayList<>();
        myTownCenters = new ArrayList<>();
        myWorkers = new ArrayList<>();
        
        myGold = 5000;
        myFood = 10000;
        myStone = 2000;
        myWood = 20000;
        
        maxPopulation = 5;
        population = 0;
        
        u = GUI.Forms.MyFrame.U;
    }
    
    //Setters :
    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public void setMyGold(int myGold) {
        this.myGold = myGold;
    }

    public void setMyStone(int myStone) {
        this.myStone = myStone;
    }

    public void setMyFood(int myFood) {
        this.myFood = myFood;
    }

    public void setMyWood(int myWood) {
        this.myWood = myWood;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setMaxPopulation(int maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    public void setUpgradeLevel(int upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

    public void setCivilization_no(int civilization_no) {
        this.civilization_no = civilization_no;
    }
    
    //Getters : 
    public String getMapType() {
        return mapType;
    }

    public int getMyGold() {
        return myGold;
    }

    public int getMyStone() {
        return myStone;
    }

    public int getMyFood() {
        return myFood;
    }

    public int getMyWood() {
        return myWood;
    }

    public int getPopulation() {
        return population;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public int getCivilization_no() {
        return civilization_no;
    }
    
    //Functions : 
    public void saveGame() throws FileNotFoundException, IOException {
        JOptionPane.showMessageDialog(null, "saveGame() Entered");
        if(!myArchers.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Archers.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myArchers);
            F.close();
        }
        if(!myHorsemen.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Horsemen.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myHorsemen);
            F.close();
        }
        if(!myPriests.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Priests.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myPriests);
            F.close();
        }
        if(!mySiegeRams.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\SiegeRams.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(mySiegeRams);
            F.close();
        }
        if(!mySoldiers.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Soldiers.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(mySoldiers);
            F.close();
        }
        if(!myWorkers.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Workers.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myWorkers);
            F.close();
        }
        ////////////////////////////////////////////////////////////////////////
        if(!myArcheryRanges.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\ArcheryRanges.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myArcheryRanges);
            F.close();
        }
        if(!myBarracks.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Barracks.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myBarracks);
            F.close();
        }
        if(!myMonstarys.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Monstarys.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myMonstarys);
            F.close();
        }
        if(!mySiegeWorkshops.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\SiegeWorkshops.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(mySiegeWorkshops);
            F.close();
        }
        if(!myStables.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Stables.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myStables);
            F.close();
        }
        if(!myTownCenters.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\TownCenters.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myTownCenters);
            F.close();
        }
        ///////////////////////////////////////////////////////////////////////////
        if(!myHouses.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Houses.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myHouses);
            F.close();
        }
        if(!myMarkets.isEmpty()){
            FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Markets.txt");
            ObjectOutputStream out = new ObjectOutputStream(F);
            out.writeObject(myMarkets);
            F.close();
        }
        
        FileOutputStream F = new FileOutputStream("DATA\\"+ u.getUsername() +"\\Game.txt");
        ObjectOutputStream out = new ObjectOutputStream(F);
        out.writeObject(this);
        F.close();
        
        JOptionPane.showMessageDialog(null, "Game Saved Succssefully.");
    }
    
    public void loadGame() throws IOException, ClassNotFoundException{
        File file = new File("DATA\\"+ u.getUsername() +"\\Archers.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myArchers = (ArrayList<Archer>)in.readObject();
            F.close();
            for(int j = 0; j < myArchers.size();j++){
                JOptionPane.showMessageDialog(null, myArchers.get(j).toString());
            }
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Horsemen.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myHorsemen = (ArrayList<Horseman>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Priests.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myPriests = (ArrayList<Priest>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\SiegeRams.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            mySiegeRams = (ArrayList<SiegeRam>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Soldiers.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            mySoldiers = (ArrayList<Soldier>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Workers.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myWorkers = (ArrayList<Worker>)in.readObject();
            F.close();
            for(int j = 0; j < myWorkers.size();j++){
                JOptionPane.showMessageDialog(null, myWorkers.get(j).toString());
            }
        }
        
        
        
        file = new File("DATA\\"+ u.getUsername() +"\\ArcheryRanges.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myArcheryRanges = (ArrayList<ArcheryRange>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Barracks.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myBarracks = (ArrayList<Barrack>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Monstarys.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myMonstarys = (ArrayList<Monstary>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\SiegeWorkshops.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            mySiegeWorkshops = (ArrayList<SiegeWorkshop>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Stables.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myStables = (ArrayList<Stable>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\TownCenters.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myTownCenters = (ArrayList<TownCenter>)in.readObject();
            F.close();
        }
        
        
        
        file = new File("DATA\\"+ u.getUsername() +"\\Houses.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myHouses = (ArrayList<House>)in.readObject();
            F.close();
        }
        
        file = new File("DATA\\"+ u.getUsername() +"\\Markets.txt");
        if(file.exists() && file.length() != 0){
            FileInputStream F = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(F);
            myMarkets = (ArrayList<Market>)in.readObject();
            F.close();
        }
        
        
                
//        for (Archer archer : myArchers) {
//            strategygame.StrategyGame.Frame.MAP.ADD(archer, archer.L);
////            JOptionPane.showMessageDialog(null, "" + myArchers.size());
//        }
//        for (Horseman horseman : myHorsemen) {
//            strategygame.StrategyGame.Frame.MAP.ADD(horseman, horseman.L);
//        }
//        for (Priest priest : myPriests) {
//            strategygame.StrategyGame.Frame.MAP.ADD(priest, priest.L);
//        }
//        for (SiegeRam siegeRam : mySiegeRams) {
//            strategygame.StrategyGame.Frame.MAP.ADD(siegeRam, siegeRam.L);
//        }
//        for (Soldier soldier : mySoldiers) {
//            strategygame.StrategyGame.Frame.MAP.ADD(soldier, soldier.L);
//        }
//        for (Worker worker : myWorkers) {
//            strategygame.StrategyGame.Frame.MAP.ADD(worker, worker.L);
//        }
//        
//        
//        for (ArcheryRange archeryRange : myArcheryRanges) {
//            strategygame.StrategyGame.Frame.MAP.ADD(archeryRange, archeryRange.L);
//        }
//        for (Barrack barrack : myBarracks) {
//            strategygame.StrategyGame.Frame.MAP.ADD(barrack, barrack.L);
//        }
//        for (Monstary monstary : myMonstarys) {
//            strategygame.StrategyGame.Frame.MAP.ADD(monstary, monstary.L);
//        }
//        for (SiegeWorkshop siegeWorkshop : mySiegeWorkshops) {
//            strategygame.StrategyGame.Frame.MAP.ADD(siegeWorkshop, siegeWorkshop.L);
//        }
//        for (Stable stable : myStables) {
//            strategygame.StrategyGame.Frame.MAP.ADD(stable, stable.L);
//        }
//        for (TownCenter townCenter : myTownCenters) {
//            strategygame.StrategyGame.Frame.MAP.ADD(townCenter, townCenter.L);
//        }
//        
//        
//        for (House house : myHouses) {
//            strategygame.StrategyGame.Frame.MAP.ADD(house, house.L);
//        }
//        for (Market market : myMarkets) {
//            strategygame.StrategyGame.Frame.MAP.ADD(market, market.L);
//        }
        
        //GUI.Forms.MyFrame.MAP.setVisible(true);
   }
    
}
