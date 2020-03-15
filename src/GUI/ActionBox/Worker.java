/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ActionBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Youssef
 */
public class Worker extends AttackingUnit{
    public JButton buildTownCenter = new JButton("TownCenter");
    public JButton buildHouse = new JButton("House");
    public JButton buildArcheryRange = new JButton("ArcheryRange");
    public JButton buildBarrack = new JButton("Barrack");
    public JButton buildStable = new JButton("Stable");
    public JButton buildSiegeWorkshop = new JButton("SiegeWorkshop");
    public JButton buildMonstary = new JButton("Monstary");
    public JButton buildMarket = new JButton("Market");
//    public JButton buildTower = new JButton("T");
//    public JButton buildGate = new JButton("G");
//    public JButton buildWall = new JButton("W");
    
    public strategygame.Worker w;
    
    public Worker(strategygame.Worker W){
        super(W);
        w = W;
        
        buildTownCenter.setBounds(60, 84, 140, 25);
        buildHouse.setBounds(208, 84, 80, 25);
        buildMarket.setBounds(297, 84, 80, 25);
        
        buildBarrack.setBounds(60, 117, 100, 25);
        buildStable.setBounds(168, 117, 100, 25);
        buildMonstary.setBounds(276, 117, 100, 25);
        
        buildArcheryRange.setBounds(60, 150, 140, 25);
        buildSiegeWorkshop.setBounds(208, 150, 140, 25);
        
//        buildHouse.setBounds(buildTownCenter.getX()+buildTownCenter.getWidth() + 8, buildTownCenter.getY(), buildTownCenter.getWidth(), buildTownCenter.getHeight());
//        buildArcheryRange.setBounds(buildHouse.getX()+buildHouse.getWidth() + 8, buildHouse.getY(), buildHouse.getWidth(), buildHouse.getHeight());
//        buildBarrack.setBounds(buildArcheryRange.getX()+buildArcheryRange.getWidth() + 8, buildArcheryRange.getY(), buildArcheryRange.getWidth(), buildArcheryRange.getHeight());
//        buildStable.setBounds(buildBarrack.getX()+buildBarrack.getWidth() + 8, buildBarrack.getY(), buildBarrack.getWidth(), buildBarrack.getHeight());
//        
//        
//        
//        buildSiegeWorkshop.setBounds(buildTownCenter.getX(), buildTownCenter.getY()+buildTownCenter.getWidth()+21, buildTownCenter.getWidth(), buildTownCenter.getHeight());
//        buildMonstary.setBounds(buildSiegeWorkshop.getX()+buildSiegeWorkshop.getWidth()+25, buildSiegeWorkshop.getY(), buildSiegeWorkshop.getWidth(), buildSiegeWorkshop.getHeight());
//        buildMarket.setBounds(buildMonstary.getX()+buildMonstary.getWidth()+25, buildMonstary.getY(), buildMonstary.getWidth(), buildMonstary.getHeight());
//        buildGate.setBounds(buildMarket.getX()+buildMarket.getWidth()+25, buildMarket.getY(), buildMarket.getWidth(), buildMarket.getHeight());
//        buildWall.setBounds(buildGate.getX()+buildGate.getWidth()+25, buildGate.getY(), buildGate.getWidth(), buildGate.getHeight());

        add(buildTownCenter);
        add(buildHouse);
        add(buildArcheryRange);
        add(buildBarrack);
        add(buildStable);
        add(buildSiegeWorkshop);
        add(buildMonstary);
        add(buildMarket);
//        add(buildGate);
//        add(buildWall);
//        
//        buildTower.setBounds(buildSiegeWorkshop.getX(), buildSiegeWorkshop.getY()+buildSiegeWorkshop.getWidth()+21, buildSiegeWorkshop.getWidth(), buildSiegeWorkshop.getHeight());
//
//        add(buildTower);
        addImg();
        
        buildTownCenter.addActionListener(new Build());
        buildHouse.addActionListener(new Build());
        buildArcheryRange.addActionListener(new Build());
        buildBarrack.addActionListener(new Build());
        buildStable.addActionListener(new Build());
        buildSiegeWorkshop.addActionListener(new Build());
        buildMonstary.addActionListener(new Build());
        buildMarket.addActionListener(new Build());
//        buildGate.addActionListener(new Build());
//        buildWall.addActionListener(new Build());
//        buildTower.addActionListener(new Build());
    }
    
    private class Build implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                if(e.getSource() == buildTownCenter)
                {
                    strategygame.TownCenter bu = new strategygame.TownCenter(w.civilization_no);
                    w.build(bu);
                    GUI.Forms.MyFrame.myClient.sendBuild("TownCenter", w.L);
                }
                else if(e.getSource() == buildHouse)
                {
                    strategygame.House bu = new strategygame.House(w.civilization_no);
                    w.build(bu);
                    GUI.Forms.MyFrame.myClient.sendBuild("House", w.L);
                }
                else if(e.getSource() == buildArcheryRange)
                {
                    strategygame.ArcheryRange bu = new strategygame.ArcheryRange(w.civilization_no);
                    w.build(bu);
                    GUI.Forms.MyFrame.myClient.sendBuild("ArcheryRange", w.L);
                }
                else if(e.getSource() == buildBarrack)
                {
                    strategygame.Barrack bu = new strategygame.Barrack(w.civilization_no);
                    w.build(bu);   
                    GUI.Forms.MyFrame.myClient.sendBuild("Barrack", w.L);
                }
                else if(e.getSource() == buildStable)
                {
                    strategygame.Stable bu = new strategygame.Stable(w.civilization_no);
                    w.build(bu);   
                    GUI.Forms.MyFrame.myClient.sendBuild("Stable", w.L);
                }
                else if(e.getSource() == buildSiegeWorkshop)
                {
                    strategygame.SiegeWorkshop bu = new strategygame.SiegeWorkshop(w.civilization_no);
                    w.build(bu);   
                    GUI.Forms.MyFrame.myClient.sendBuild("SiegeWorkshop", w.L);
                }
                else if(e.getSource() == buildMonstary)
                {
                    strategygame.Monstary bu = new strategygame.Monstary(w.civilization_no);
                    w.build(bu); 
                    GUI.Forms.MyFrame.myClient.sendBuild("Monstary", w.L);
                }
                else if(e.getSource() == buildMarket)
                {
                    strategygame.Market bu = new strategygame.Market(w.civilization_no);
                    w.build(bu);   
                    GUI.Forms.MyFrame.myClient.sendBuild("Market", w.L);
                }   
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
}
