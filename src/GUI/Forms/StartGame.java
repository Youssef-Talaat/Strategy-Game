/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public class StartGame extends JPanel{
    public JLabel map_label = new JLabel("Map");
    public JLabel civilization_label = new JLabel("Civilization");
    public JLabel difficulty_label = new JLabel("Difficulty");
    public JButton start = new JButton("Start Game");
    public JButton reset = new JButton("Reset");
    public JButton back = new JButton("Back");
    public JComboBox map_comboBox = new JComboBox(new String[]{"Grass", "Sand", "Snow"});
    public JComboBox civilization_comboBox = new JComboBox(new String[]{"Byzantines(Orange)", "Persians(Blue)", "Civi 3"});
    public JComboBox difficulty_comboBox = new JComboBox(new String[]{"Easy", "Medium", "Hard"});
    public JLabel Background = new JLabel();
    
    public String IPAddress;
    
    public StartGame(){
        setSize(1370 ,768);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1366, 767);
        
//        map_label.setBounds(318, 303, 80, 30);
//        map_comboBox.setBounds(map_label.getX() + map_label.getWidth() + 10, map_label.getY(), 120, 30);
//        civilization_label.setBounds(map_comboBox.getX() + map_comboBox.getWidth() + 50, map_label.getY(), map_label.getWidth(), map_label.getHeight());
//        civilization_comboBox.setBounds(civilization_label.getX() + civilization_label.getWidth() + 10, map_label.getY(), map_comboBox.getWidth(), map_comboBox.getHeight());
//        difficulty_label.setBounds(civilization_comboBox.getX() + civilization_comboBox.getWidth() + 50, map_label.getY(), map_label.getWidth(), map_label.getHeight());
//        difficulty_comboBox.setBounds(difficulty_label.getX() + difficulty_label.getWidth() + 10, map_label.getY(), map_comboBox.getWidth(), map_comboBox.getHeight());

        map_label.setBounds(393, 328, 40, 30);
        map_comboBox.setBounds(443, 328, 75, 30);
        civilization_label.setBounds(533, 328, 80, 30);
        civilization_comboBox.setBounds(623, 328, 140, 30);
        difficulty_label.setBounds(793, 328, 70, 30);
        difficulty_comboBox.setBounds(873, 328, 100, 30);
        
        start.setBounds(538, 408, 110, 30);
        reset.setBounds(668, 408, 70, 30);
        back.setBounds(758, 408, 70, 30);
        
        start.addActionListener(new ButtonWatcher());
        back.addActionListener(new ButtonWatcher());
        reset.addActionListener(new ButtonWatcher());
        
        map_label.setFont(new Font("Serif", Font.PLAIN, 18));
        civilization_label.setFont(new Font("Serif", Font.PLAIN, 18));
        difficulty_label.setFont(new Font("Serif", Font.PLAIN, 18));
        
        add(map_label);
        add(map_comboBox);
        add(civilization_label);
        add(civilization_comboBox);
        add(difficulty_label);
        add(difficulty_comboBox);
        add(start);
        add(reset);
        add(back);
        add(Background);
    }
    
    private class ButtonWatcher implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(start)){
                MyFrame.U.game = new strategygame.Game();
                MyFrame.U.game.setMapType((String)map_comboBox.getSelectedItem());
                MyFrame.U.game.setCivilization_no(civilization_comboBox.getSelectedIndex());
                try {
                    MyFrame.U.saveUsers();
                } catch (IOException ex) {
                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
//                    MyFrame.myClient = new MyClient();
//                try {
//                    MyFrame.myClient.startConnection();
//                    MyFrame.myClient.sendMapType();
//                    MyFrame.myClient.sendCivilization();
//                } catch (IOException ex) {
//                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                strategygame.StrategyGame.Frame.createMap(MyFrame.U.game.getMapType());
                MyFrame.form_StartGame.setVisible(false);
                
                MyFrame.MAP.beforePlaying();
                MyFrame.MAP.setVisible(true);
                
                try {
                    MyFrame.U.createFiles();
                } catch (IOException ex) {
                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(buttonPressed.equals(back))
            {
                MyFrame.form_StartGame.setVisible(false);
                MyFrame.form_NewGame.setVisible(true);
            }
            else if(buttonPressed.equals(reset))
            {
                map_comboBox.setSelectedItem("Grass");
                civilization_comboBox.setSelectedItem("Byzantines(Orange)");
                difficulty_comboBox.setSelectedItem("Easy");
            }
        }
    }
}
