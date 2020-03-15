/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public class Statistics extends JPanel{
    public JLabel Background = new JLabel();
    public JLabel created = new JLabel("CREATED");
    public JLabel destroyed = new JLabel("DESTROYED - Killed");
    
    public JLabel ar = new JLabel("ArcheryRanges");
    public JLabel b = new JLabel("Barracks");
    public JLabel h = new JLabel("Houses");
    public JLabel ma = new JLabel("Markets");
    public JLabel mo = new JLabel("Monstarys");
    public JLabel sw = new JLabel("SiegeWorkshops");
    public JLabel st = new JLabel("Stables");
    public JLabel tc = new JLabel("TownCenters");
    public JLabel A = new JLabel("Archers");
    public JLabel H = new JLabel("Horsemen");
    public JLabel P = new JLabel("Priests");
    public JLabel SO = new JLabel("Soldiers");
    public JLabel SR = new JLabel("SiegeRams");
    public JLabel W = new JLabel("Workers");
    
    public Statistics(){
        setSize(1370 ,768);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1366, 768);
        
        ar.setBounds(100, 100, 1000, 50);
        
        add(ar);
        add(Background);
    }
    
    public void showStatistics(){
    }
}
