/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

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
public class MainMenu extends JPanel{
    public JButton Continue = new JButton("Continue");
    public JButton NewGame = new JButton("New Game");
    public JButton Option = new JButton("Option");
    public JButton Credits = new JButton("Credits");
    public JButton Back = new JButton("Back");
    public JButton Exit = new JButton("Exit");
    public JLabel Background = new JLabel();
    
    public MainMenu(){
        setSize(1370 ,1536);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1365, 767);
        
        Continue.setBounds(617, 190, 160, 40);
        NewGame.setBounds(617, Continue.getBounds().y + 60, 160, 40);
        Option.setBounds(617, NewGame.getBounds().y + 60, 160, 40);
        Credits.setBounds(617, Option.getBounds().y + 60, 160, 40);
        Back.setBounds(617, Credits.getBounds().y + 60, 160, 40);
        Exit.setBounds(617, Back.getBounds().y + 60, 160, 40);
        
        add(Continue);
        add(NewGame);
        add(Option);
        add(Credits);
        add(Back);
        add(Exit);
        add(Background);
        
        Continue.addActionListener(new ButtonWatcher());
        NewGame.addActionListener(new ButtonWatcher());
        Option.addActionListener(new ButtonWatcher());
        Credits.addActionListener(new ButtonWatcher());
        Back.addActionListener(new ButtonWatcher());
        Exit.addActionListener(new ButtonWatcher());
    }
    private class ButtonWatcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(Continue))
            {
                try {
                    MyFrame.form_MainMenu.setVisible(false);
                    MyFrame.U.loadGameData();
                    strategygame.StrategyGame.Frame.createMap(MyFrame.U.game.getMapType());
                    MyFrame.U.game.loadGame();
                    MyFrame.MAP.setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(buttonPressed.equals(NewGame))
            {
                //Create new Game
            }
            else if(buttonPressed.equals(Option))
            {
                //Open Option panel."we will create it"
            }
            else if(buttonPressed.equals(Credits))
            {
                MyFrame.form_MainMenu.setVisible(false);
                MyFrame.form_Credits.setVisible(true);
            }
            else if(buttonPressed.equals(Back)){
                MyFrame.form_MainMenu.setVisible(false);
                MyFrame.form_HomePage.setVisible(true);
                MyFrame.U = null;
            }
            else if(buttonPressed.equals(Exit))
            {
                System.exit(0);
            }
        }
    }
}
