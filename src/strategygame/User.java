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
import java.util.HashMap;
import javax.swing.*;


/**
 *
 * @author Youssef
 */
public class User implements Serializable{
    private String name , username , password;
    public static Game game;
    
    public static ArrayList<User> myUsers = new ArrayList<>();
    
    public static HashMap<String, User> newUsers = new HashMap<String, User>();
        
    //Constructor : 
    public User() {
        username = "";
        password = "";
        name = "";
    }

    //Setters : 
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getters : 
    public String getName () {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    //Functions :  
    public boolean signUp() {
        if(newUsers.get(username) == null){
            //users.put(username,password);
            newUsers.put(username, this);
            myUsers.add(this);
            new File("DATA\\" + username).mkdir();
            JOptionPane.showMessageDialog(null, "Done.");
            return true;
        }
        else{
            return false;
        }
    }
    
    public void createFiles() throws IOException{
        File file = new File("DATA\\" + username + "\\Archers.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Horsemen.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Priests.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\SiegeRams.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Soldiers.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Workers.txt");
        file.createNewFile();
        
        file = new File("DATA\\" + username + "\\ArcheryRanges.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Barracks.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Monstarys.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\SiegeWorkshops.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Stables.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\TownCenters.txt");
        file.createNewFile();
        
        file = new File("DATA\\" + username + "\\Houses.txt");
        file.createNewFile();
        file = new File("DATA\\" + username + "\\Markets.txt");
        file.createNewFile();
    }
    
    public static void saveUsers() throws FileNotFoundException, IOException{
        JOptionPane.showMessageDialog(null, "SAVE() Entered");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.txt"));
        out.writeObject(myUsers);
        out.close();
        JOptionPane.showMessageDialog(null, "Saved successfully.");
    }
    
    public static void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("users.txt");
        
        if(file.exists() && file.length() != 0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            myUsers = (ArrayList<User>)in.readObject();
            for(int i = 0; i < myUsers.size() ; i++)
            {
                JOptionPane.showMessageDialog(null, ""+myUsers.get(i).getUsername()+" , "+myUsers.get(i).getPassword());
                //users.put(myUsers.get(i).getUsername(), myUsers.get(i).getPassword());
                newUsers.put(myUsers.get(i).getUsername(), myUsers.get(i));
            }
            in.close();

            JOptionPane.showMessageDialog(null, "Loaded successfully.");
        }
    }
    public static void loadGameData() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("DATA\\"+ GUI.Forms.MyFrame.U.getUsername() +"\\Game.txt");
        FileInputStream F = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(F);
        GUI.Forms.MyFrame.U.game = (Game)in.readObject();
        F.close();
    }
}
