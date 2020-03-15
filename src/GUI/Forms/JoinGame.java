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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public class JoinGame extends JPanel{
    public JLabel civilization_label = new JLabel("Civilization");
    public JLabel difficulty_label = new JLabel("Difficulty");
    public JButton reset = new JButton("Reset");
    public JButton join = new JButton("Join a Game");
    public JButton back = new JButton("Back");
    public JComboBox civilization_comboBox = new JComboBox(new String[]{"Byzantines(Orange)", "Persians(Blue)", "Civi 3"});
    public JComboBox difficulty_comboBox = new JComboBox(new String[]{"Easy", "Medium", "Hard"});
    public JLabel Background = new JLabel();
    
    public String IPAddress;
    public static MyClient myClient;
    
    public JoinGame(){
        setSize(1370 ,768);
        
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setVisible(false);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Pics\\GameBackground.jpg").getImage().getScaledInstance(1365, 767, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, 1366, 768);
        
//        map_label.setBounds(500, 200, 40, 30);
//        civilization_label.setBounds(map_label.getBounds().x + map_label.getSize().width +100, map_label.getBounds().y, 80, 30);
//        difficulty_label.setBounds(civilization_label.getBounds().x + civilization_label.getSize().width + 100, map_label.getBounds().y, 60, 30);
//        add(map_label);
//        add(civilization_label);
//        add(difficulty_label);
//        map_comboBox.setBounds(map_label.getBounds().x - 30, map_label.getBounds().y + 40, 100, 30);
//        civilization_comboBox.setBounds(civilization_label.getBounds().x - 15, civilization_label.getBounds().y + 40, 100, 30);
//        difficulty_comboBox.setBounds(difficulty_label.getBounds().x - 20, difficulty_label.getBounds().y + 40, 100, 30);
//        add(map_comboBox);
//        add(civilization_comboBox);
//        add(difficulty_comboBox);
//        start.setBounds(map_label.getBounds().x + 10, map_comboBox.getBounds().y + 60, 130, 30);
//        reset.setBounds(start.getBounds().x + start.getSize().width +30, map_comboBox.getBounds().y + 60, 80, 30);
//        back.setBounds(reset.getBounds().x + reset.getSize().width +30, map_comboBox.getBounds().y + 60, 80, 30);
//        join.setBounds(618, 364, 130, 40);
//        add(start);
//        add(reset);
//        add(back);
//        add(join);
//        add(Background);
//        
//        back.addActionListener(new ButtonWatcher());
//        reset.addActionListener(new ButtonWatcher());
//        join.addActionListener(new ButtonWatcher());

        civilization_label.setBounds(533, 328, 80, 30);
        civilization_comboBox.setBounds(623, 328, 140, 30);
        difficulty_label.setBounds(793, 328, 70, 30);
        difficulty_comboBox.setBounds(873, 328, 100, 30);
        
        join.setBounds(538, 408, 110, 30);
        reset.setBounds(668, 408, 70, 30);
        back.setBounds(758, 408, 70, 30);
        
        join.addActionListener(new ButtonWatcher());
        back.addActionListener(new ButtonWatcher());
        reset.addActionListener(new ButtonWatcher());
        
        civilization_label.setFont(new Font("Serif", Font.PLAIN, 18));
        difficulty_label.setFont(new Font("Serif", Font.PLAIN, 18));
        
        add(civilization_label);
        add(civilization_comboBox);
        add(difficulty_label);
        add(difficulty_comboBox);
        add(join);
        add(reset);
        add(back);
        add(Background);

    }
    
    private class ButtonWatcher implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(back)){
                MyFrame.form_StartGame.setVisible(false);
                MyFrame.form_NewGame.setVisible(true);
            }
            else if(buttonPressed.equals(reset))
            {
                civilization_comboBox.setSelectedItem("Byzantines(Orange)");
                difficulty_comboBox.setSelectedItem("Easy");
            }
            else if(buttonPressed.equals(join)){
                IPAddress = JOptionPane.showInputDialog("Enter the IP Address of the other player.");

//                MyFrame.U.setMapType((String)map_comboBox.getSelectedItem());
                MyFrame.U.game = new strategygame.Game();
                MyFrame.U.game.setCivilization_no(civilization_comboBox.getSelectedIndex());
                    
                    myClient = new MyClient();
                try {
                    myClient.connect(IPAddress);
                } catch (IOException ex) {
                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                myClient.sendCivilization();
                
                try {
                    MyFrame.U.saveUsers();
                } catch (IOException ex) {
                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                strategygame.StrategyGame.Frame.createMap(MyFrame.U.game.getMapType());
                MyFrame.form_JoinGame.setVisible(false);
                
                MyFrame.MAP.beforePlaying();
                MyFrame.MAP.setVisible(true);
                
                try {
                    MyFrame.U.createFiles();
                } catch (IOException ex) {
                    Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
}
