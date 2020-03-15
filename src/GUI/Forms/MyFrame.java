/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author Youssef
 */
public class MyFrame extends JFrame{
    public static Credits form_Credits = new Credits();
    public static HomePage form_HomePage = new HomePage();
    public static LogIn form_LogIn = new LogIn();
    public static MainMenu form_MainMenu = new MainMenu();
    public static NewGame form_NewGame = new NewGame();
    public static StartGame form_StartGame = new StartGame();
    public static JoinGame form_JoinGame = new JoinGame();
    public static SignUp form_SignUp = new SignUp();
    public static Statistics form_Statistics = new Statistics();
    
    public static GUI.Map MAP;
    public static MyClient myClient;
    
    public static strategygame.User U = new strategygame.User();
            
    public MyFrame(){
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setTitle("Game");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            strategygame.User.loadUsers();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        add(form_Credits);
        add(form_LogIn);
        add(form_MainMenu);
        add(form_NewGame);
        add(form_SignUp);
        add(form_HomePage);
        add(form_StartGame);
        add(form_JoinGame);
        add(form_Statistics);
        
        form_HomePage.setVisible(true);
    }
    
    public void createMap(String type){
        MAP = new GUI.Map(type);
        MAP.myCivilization_no = MyFrame.U.game.getCivilization_no();
        add(MAP);
    }
}
