/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Forms.MyFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Youssef
 */
public class StatusBar extends JPanel{
    public JLabel gold = new JLabel();
    public JLabel currentGold = new JLabel("" + MyFrame.U.game.getMyGold());
    public JLabel stone = new JLabel();
    public JLabel currentStone = new JLabel("" + MyFrame.U.game.getMyStone());
    public JLabel food = new JLabel();
    public JLabel currentFood = new JLabel("" + MyFrame.U.game.getMyFood());
    public JLabel wood = new JLabel();
    public JLabel currentWood = new JLabel("" + MyFrame.U.game.getMyWood());
    public JLabel population = new JLabel();
    public JLabel currentPopulation = new JLabel("" + MyFrame.U.game.getPopulation() + "  /  ");
    public JLabel maxPopulation = new JLabel("" + MyFrame.U.game.getMaxPopulation());
    public JButton pause = new JButton("Save");
    
    public JLabel img = new JLabel();
    
    
    public StatusBar(){
        setLayout(null);
        setBackground(Color.orange);
        
        setBounds(0, 0, 1366, 40);
        
        gold.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Gold.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH)));
        gold.setBounds(150, 5, 40, 30);
        currentGold.setBounds(gold.getX() + 50, gold.getY(), 100, gold.getHeight());
        
        stone.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Stone.png").getImage().getScaledInstance(39, 30, Image.SCALE_SMOOTH)));
        stone.setBounds(currentGold.getX() + 150, currentGold.getY(), 39, 30);
        currentStone.setBounds(stone.getX() + 50, stone.getY(), 100, stone.getHeight());
        
        food.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Food.png").getImage().getScaledInstance(33, 30, Image.SCALE_SMOOTH)));
        food.setBounds(currentStone.getX() + 150, currentStone.getY(), 33, 30);
        currentFood.setBounds(food.getX() + 50, food.getY(), 100, food.getHeight());
        
        wood.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Wood.png").getImage().getScaledInstance(34, 33, Image.SCALE_SMOOTH)));
        wood.setBounds(currentFood.getX() + 150, currentFood.getY(), 34, 30);
        currentWood.setBounds(wood.getX() + 50, wood.getY(), 100, wood.getHeight());
        
        population.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Population.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        population.setBounds(currentWood.getX() + 150, currentWood.getY(), 30, 30);
        currentPopulation.setBounds(population.getX() + 100, population.getY(), population.getWidth(), population.getHeight());
        maxPopulation.setBounds(currentPopulation.getX() + 20, currentPopulation.getY(), currentPopulation.getWidth(), currentPopulation.getHeight());

        pause.setBounds(1256, 5, 100, 30);
        
        img.setIcon(new ImageIcon(new ImageIcon("Pics\\StatusBar\\Background.png").getImage().getScaledInstance(1366, 40, Image.SCALE_SMOOTH)));
        img.setBounds(0, 0, 1366, 40);
        
        add(pause);
        add(gold);
        add(currentGold);
        add(stone);
        add(currentStone);
        add(food);
        add(currentFood);
        add(wood);
        add(currentWood);
        add(population);
        add(currentPopulation);
        add(maxPopulation);
        add(img);
        
        pause.addActionListener(new ButtonWatcher());
    }
    
    public void update(){
        currentFood.setText("" + MyFrame.U.game.getMyFood());
        currentGold.setText("" + MyFrame.U.game.getMyGold());
        currentStone.setText("" + MyFrame.U.game.getMyStone());
        currentWood.setText("" + MyFrame.U.game.getMyWood());
        currentPopulation.setText("" + MyFrame.U.game.getPopulation() + "  /  ");
        maxPopulation.setText("" + MyFrame.U.game.getMaxPopulation());
    }

    private class ButtonWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MyFrame.U.game.saveGame();
            } catch (IOException ex) {
                Logger.getLogger(StatusBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
