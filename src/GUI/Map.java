/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.ActionBox.ActionBox;
import GUI.InfoBox.InfoBox;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import strategygame.Location;
/**
 *
 * @author Youssef
 */
public class Map extends JPanel implements MouseListener, MouseMotionListener
{
    public static int mapWidth = 4000;
    public static int mapHeight = 2500;
    
    public strategygame.MyObject [][]Map = new strategygame.MyObject[4000][2500];
    public ArrayList<strategygame.Resource> Resources;
    
    public static int firstX = -2634, firstY = -2012;
    public static int intialX, intialY;
    
    public static StatusBar statusBar = new StatusBar();
    public static ActionBox DAB = new ActionBox();
    public static InfoBox DIB = new InfoBox();
    public static MiniMap miniMap;
    
    public JPanel CurrentActionBox = DAB;
    public JPanel CurrentInfoBox = DIB;
    
    public strategygame.MyObject SelectedObject = null;
    
    public static int myCivilization_no;
    public static int enemyCivilization_no;
    
    public JLabel realMap = new JLabel(); 
    
    public JPanel statusBarPanel = new JPanel();
    public JPanel mapPanel = new JPanel();
    public JPanel boxesPanel = new JPanel();
    
    public JLabel test = new JLabel("null");
    
    public Map(String type){
        setLayout(null);
        setVisible(true);
        setBounds(0, 0, 1366, 768);
        
        test.setBounds(10, 10, 120, 40);
        
        statusBarPanel.setLayout(null);
        statusBarPanel.setBounds(0, 0, 1366, 40);
        statusBarPanel.add(statusBar);
        
        realMap.setIcon(new ImageIcon(new ImageIcon("Pics\\Maps\\" + type + ".png").getImage().getScaledInstance(4000, 2500, Image.SCALE_DEFAULT)));
        realMap.setSize(mapWidth, mapHeight);
        realMap.setLocation(firstX, firstY);
        mapPanel.setLayout(null);
        mapPanel.setBounds(0, 40, 1366, 488);
        mapPanel.add(test);
        mapPanel.add(realMap);
        
        boxesPanel.setLayout(null);
        boxesPanel.setBounds(0, 528, 1366, 240);
        boxesPanel.add(DAB);
        boxesPanel.add(DIB);
        miniMap = new GUI.MiniMap(type);
        boxesPanel.add(miniMap);
        
        add(statusBarPanel);
        add(mapPanel);
        add(boxesPanel);
        
        realMap.addMouseListener(this);
        realMap.addMouseMotionListener(this);
        addMouseMotionListener(this);
        
    }
    
    public void beforePlaying(){
        Location l = new Location();
        if(myCivilization_no == 0){
            strategygame.TownCenter TW1 = new strategygame.TownCenter(myCivilization_no);
            Location x1 = new Location(200, 400);
            TW1.create(x1);
            l.setxPosition(500);
            l.setyPosition(200);
            strategygame.Wood w = new strategygame.Wood(l);
            l.setxPosition(l.getxPosition() + 200);
            strategygame.GoldBlock g = new strategygame.GoldBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.StoneBlock s = new strategygame.StoneBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.Food f = new strategygame.Food(l);

            strategygame.TownCenter TW2 = new strategygame.TownCenter(enemyCivilization_no);
            Location x2 = new Location(3000, 1500);
            TW2.create(x2);

            l.setxPosition(3000);
            l.setyPosition(1100);
            strategygame.Wood w2 = new strategygame.Wood(l);
            l.setxPosition(l.getxPosition() + 200);
            strategygame.GoldBlock g2 = new strategygame.GoldBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.StoneBlock s2 = new strategygame.StoneBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.Food f2 = new strategygame.Food(l);
            firstX = 0;
            firstY = 0;
            realMap.setLocation(firstX, firstY);
        }
        else if(myCivilization_no == 1){
            strategygame.TownCenter TW1 = new strategygame.TownCenter(enemyCivilization_no);
            Location x1 = new Location(200, 400);
            TW1.create(x1);
            l.setxPosition(500);
            l.setyPosition(200);
            strategygame.Wood w = new strategygame.Wood(l);
            l.setxPosition(l.getxPosition() + 200);
            strategygame.GoldBlock g = new strategygame.GoldBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.StoneBlock s = new strategygame.StoneBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.Food f = new strategygame.Food(l);

            strategygame.TownCenter TW2 = new strategygame.TownCenter(myCivilization_no);
            Location x2 = new Location(3000, 1500);
            TW2.create(x2);

            l.setxPosition(3000);
            l.setyPosition(1100);
            strategygame.Wood w2 = new strategygame.Wood(l);
            l.setxPosition(l.getxPosition() + 200);
            strategygame.GoldBlock g2 = new strategygame.GoldBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.StoneBlock s2 = new strategygame.StoneBlock(l);
            l.setxPosition(l.getxPosition() + 100);
            strategygame.Food f2 = new strategygame.Food(l);
            firstX = -2634;
            firstY = -2012;
            realMap.setLocation(firstX, firstY);
        }
        select(null);
    }
    
    public void ADD(strategygame.MyObject O , strategygame.Location l){
        locate(O, l);
        
        boxesPanel.add(O.AB);
        boxesPanel.add(O.IB);
        
        O.AB.setVisible(false);
        O.IB.setVisible(false);
        
        repaint();
    }
    
    public void remove(strategygame.MyObject O){
        for(int i = O.shape.getBounds().x ; i < O.shape.getBounds().x + O.shape.getBounds().width ; i++)
        {
            for(int j = O.shape.getBounds().y ; j < O.shape.getBounds().y + O.shape.getBounds().height ; j++)
            {
                if(Map[i][j] == O)
                    Map[i][j] = null;
            }
        }
    }
    
    public void reLocate(strategygame.MyObject O , strategygame.Location l){
        remove(O);
        locate(O, l);
    }
    
    public void locate(strategygame.MyObject O , strategygame.Location l){
        O.shape.setLocation(l.getxPosition(), l.getyPosition());
        realMap.add(O.shape);
        Map[O.shape.getBounds().x][O.shape.getBounds().y] = O;
        
        miniMap.addDots(l.getxPosition(), l.getyPosition(), O);
        
        for(int i = O.shape.getBounds().x ; i < O.shape.getBounds().x + O.shape.getBounds().width ; i++)
        {
            for(int j = O.shape.getBounds().y ; j < O.shape.getBounds().y + O.shape.getBounds().height ; j++)
            {
                if(Map[i][j] == null)
                    Map[i][j] = O;
            }
        }
        
        repaint();
    }
    

    public void select(strategygame.MyObject O){
        CurrentActionBox.setVisible(false);
        CurrentInfoBox.setVisible(false);
        if(O == null){
            SelectedObject = null;
            CurrentActionBox = DAB;
            CurrentInfoBox = DIB;
        }
        else{
            SelectedObject = O;
            CurrentActionBox = O.AB;
            CurrentInfoBox = O.IB;
        }
        CurrentActionBox.setVisible(true);
        CurrentInfoBox.setVisible(true);
    }
    
    public void attackCollectMoveRepair(MouseEvent e){
        Location l = new Location(e.getX(), e.getY());
        strategygame.MyObject obj = Map[e.getX()][e.getY()];
        
        if(obj == null)
        {
            JOptionPane.showMessageDialog(null, "Moving");
            //GUI.Forms.MyFrame.myClient.sendMove(((strategygame.MovingAttackingUnit)SelectedObject).L, l);
            l.setxPosition(l.getxPosition() - (SelectedObject.width/2));
            l.setyPosition(l.getyPosition() - (SelectedObject.height));
            ((strategygame.MovingAttackingUnit)SelectedObject).move(l);
        }
        else if (SelectedObject.name.equals("Worker") && ((obj).action.equals("collectable")))
        {
            JOptionPane.showMessageDialog(null, "Collecting Resources.");
            try {
                ((strategygame.Worker)SelectedObject).collectResource((strategygame.Resource)obj);
            } catch (InterruptedException ex) {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (SelectedObject.name.equals("Worker") && ((obj).canMove == false)){
            JOptionPane.showMessageDialog(null, "Repairing");
            try {
                ((strategygame.Worker)SelectedObject).repair(((strategygame.BuildingUnit)(obj)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(((obj).action.equals("attackable")))
        {
            JOptionPane.showMessageDialog(null, "Attacking");
            ((strategygame.MovingAttackingUnit)SelectedObject).attack((strategygame.Unit)obj);
        }
        else{
            JOptionPane.showMessageDialog(null, "There is a problem in the right-click code.");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        test.setText("" + e.getX() + " , " + e.getY());
    
    if(SwingUtilities.isLeftMouseButton(e)){    //MouseListener for Left click
        select(Map[e.getX()][e.getY()]);
    }
    else if (SwingUtilities.isRightMouseButton(e)) {    //MouseListener for Right Click
        if(SelectedObject != null){
            Thread mapThread = new Thread(){
                public void run() {
                    if(SelectedObject.canMove == true && ((strategygame.Unit)SelectedObject).civilization_no == myCivilization_no){
                        if(((strategygame.AttackingUnit)SelectedObject).doing.equals(GUI.AU_Actions.nothing)){
                            attackCollectMoveRepair(e);
                        }
                        else{
                            ((strategygame.AttackingUnit)SelectedObject).doing = AU_Actions.nothing;
                            attackCollectMoveRepair(e);
                        }
                    } 
                }
            };
            mapThread.start();
        }
    }
}

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {

            intialX = me.getXOnScreen();
            intialY = me.getYOnScreen();
            //JOptionPane.showMessageDialog(null, "X: "+intialX + " Y: " + intialY);
            Thread mapThread = new Thread(){
                public void run()
                {
                    while(firstX < 0 && intialX == 0)
                    {                        
                        firstX++;
                        realMap.setLocation(firstX, firstY);
                        intialX = me.getXOnScreen();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    }

                    while(firstY  < 0 && intialY == 0)
                    {
                        firstY++;
                        realMap.setLocation(firstX, firstY);
                        intialY = me.getYOnScreen();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    } 
                    while(firstX > -2634 && intialX == 1365)
                    {
                        firstX--;
                        realMap.setLocation(firstX, firstY);
                        intialX = me.getXOnScreen();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    }
                    while(firstY > -2012 && intialY == 767)
                    {
                        firstY--;
                        realMap.setLocation(firstX, firstY);
                        intialY = me.getYOnScreen();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    }
                }
            };
            mapThread.start();
    }
    
}
