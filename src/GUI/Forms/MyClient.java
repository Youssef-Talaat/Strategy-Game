/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import strategygame.Location;

/**
 *
 * @author Youssef
 */
public class MyClient {
    public Socket soc;
    public ServerSocket Ssoc;
    public InputStream is;
    public OutputStream os;
    public PrintWriter pw;
    public BufferedReader br;
    public Thread soc1Thread , soc2Thread , soc3Thread , soc4Thread;
    public static final int port = 6000;
    
    public MyClient(){
        
    }
    
    private void getINandOUTstreams() throws IOException{
        is = soc.getInputStream();
        os = soc.getOutputStream();
        
        pw = new PrintWriter(os,true);
        br = new BufferedReader(new InputStreamReader(is));
        
        soc1Thread = new Thread(){
            public void run(){
                while(true){
                    try {
                        actions(br.readLine());
                        sleep(10);
                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        soc1Thread.start();
    }
    
    public void startConnection() throws IOException{
        Ssoc = new ServerSocket(port);
        soc = Ssoc.accept();
        getINandOUTstreams();
    }
    
    public void connect(String IPAddress) throws IOException{
        soc = new Socket(IPAddress , port);
        getINandOUTstreams();
    }
    
    public void actions(String s) throws InterruptedException{
        String x;
        x = "" + s.charAt(0) + s.charAt(1);
        s = s.substring(3);
        
        switch (x) {
            case "at"://attack
                receiveAttack(s);
                break;
            case "bu"://build
                receiveBuild(s);
                break;
            case "cz"://civilization_no
                receiveCivilization(s);
                break;
            case "cr"://create
                receiveCreate(s);
                break;
            case "co"://collect
                receiveCollect(s);
                break;
            case "mt"://mapType
                receiveMapeType(s);
                break;
            case "mv"://move
                receiveMove(s);
                break;
            case "rm"://removeObject
                receiveRemove(s);
                break;
            case "sa"://stopAttack
                receiveStopAttack(s);
                break;
            case "sc"://stopCollect
                receiveStopCollect(s);
                break;
            case "sm"://stopMove
                receiveStopMove(s);
                break;
            case "tr"://trade
                receiveTrade(s);
                break;
            default:
                break;
        }
    }
    
    public void sendAttack(){}
    
    public void sendBuild(String buildingName , strategygame.Location workerLoc){
        System.out.println("Entered send build.");
        pw.println("bu " + buildingName + " " + workerLoc.getxPosition() + " " + workerLoc.getyPosition() + " ");
    }
    
    public void sendCivilization(){
        System.out.println("Entered send civilization.");
        pw.println("cz " + MyFrame.U.game.getCivilization_no());
    }
    
    public void sendCreate(String name , strategygame.Location L){
        System.out.println("Entered send create.");
        pw.println("cr " + name + " " + L.getxPosition() + " " + L.getyPosition() + " ");
    }
    
    public void sendCollect(){}
    
    public void sendMapType(){
        System.out.println("Entered send mapType.");
        pw.println("mt " + MyFrame.U.game.getMapType());
    }
    
    public void sendMove(strategygame.Location currentL , strategygame.Location newL){ 
        System.out.println("Entered send move.");
        pw.println("mv " + currentL.getxPosition() + " " + currentL.getyPosition()
                    + " " + newL.getxPosition() + " " + newL.getyPosition() + " ");
    }
    
    public void sendRemove(){}
    
    public void sendStopAttack(){}
    
    public void sendStopCollect(){}
    
    public void sendStopMove(){}
    
    public void sendTrade(){}
    
    private String[] divide(String s , int parts){
        String all[] = new String[parts];
        String a = "";
        int x = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' ')
                a += s.charAt(i);
            else{
                all[x] = a;
                a = new String();
                x++;
            }
        }
        
        return all;
    }
    
    private void receiveAttack(String s){}
    
    private void receiveBuild(String s) throws InterruptedException{
        System.out.println("Entered receive build.");
        String []all = new String[3];
        String a = "";
        int x = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' ')
                a += s.charAt(i);
            else{
                all[x] = a;
                a = new String();
                x++;
            }
        }
        
        int xPos = Integer.parseInt(all[1]);
        int yPos = Integer.parseInt(all[2]);
        
        System.out.println(all[0] + " " + all[1] + " " + all[3]);
        
        strategygame.BuildingUnit bu = new strategygame.House(MyFrame.MAP.enemyCivilization_no);
        
        switch (all[0]) {
            case "ArcheryRange":
                bu = new strategygame.ArcheryRange(MyFrame.MAP.enemyCivilization_no);
                break;
            case "Barrack":
                bu = new strategygame.Barrack(MyFrame.MAP.enemyCivilization_no);
                break;
            case "Monstary":
                bu = new strategygame.Monstary(MyFrame.MAP.enemyCivilization_no);
                break;
            case "SiegeWorkshop":
                bu = new strategygame.SiegeWorkshop(MyFrame.MAP.enemyCivilization_no);
                break;
            case "Stable":
                bu = new strategygame.Stable(MyFrame.MAP.enemyCivilization_no);
                break;
            case "TownCenter":
                bu = new strategygame.TownCenter(MyFrame.MAP.enemyCivilization_no);
                break;
            case "House":
                bu = new strategygame.House(MyFrame.MAP.enemyCivilization_no);
                break;
            case "Market":
                bu = new strategygame.Market(MyFrame.MAP.enemyCivilization_no);
                break;
        }
        ((strategygame.Worker)MyFrame.MAP.Map[xPos][yPos]).createByMap();
    }
    
    private void receiveCivilization(String s){
        System.out.println("Entered receive civilization.");
        System.out.println(Integer.parseInt(s));
        MyFrame.MAP.enemyCivilization_no = Integer.parseInt(s);
    }
    
    private void receiveCreate(String s){
        System.out.println("Entered receive create.");
        String []all = new String[3];
        String l = "";
        int x = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' '){
                l += s.charAt(i);
            }
            else{
                all[x] = l;
                l = new String();
                x++;
            }
        }
        
        
        strategygame.MovingAttackingUnit warrior;
        
        switch (all[0]) {
            case "Archer":{
                warrior = new strategygame.Archer(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "Horseman":{
                warrior = new strategygame.Horseman(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "Priest":{
                warrior = new strategygame.Priest(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "SiegeRam":{
                warrior = new strategygame.SiegeRam(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "Soldier":{
                warrior = new strategygame.Soldier(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "Worker":{
                warrior = new strategygame.Worker(MyFrame.MAP.enemyCivilization_no);
                warrior.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                warrior.createByMap();
                break;
            }
            case "TownCenter":{
                strategygame.TownCenter tc = new strategygame.TownCenter(MyFrame.MAP.enemyCivilization_no);
                tc.L = new Location(Integer.parseInt(all[1]), Integer.parseInt(all[2]));
                tc.createByMap();
                break;
            }
            default:
                System.out.println("ERROR");
                break;
        }
        
    }
    
    private void receiveCollect(String s){}
    
    private void receiveMapeType(String s){
        System.out.println("Entered receive mapType.");
        MyFrame.U.game.setMapType(s);
    }
    
    private void receiveMove(String s){
        System.out.println("Entered recive move.");
        String []locations = new String[4];
        String l = "";
        int x = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' ')
                l += s.charAt(i);
            else{
                locations[x] = l;
                l = new String();
                x++;
            }
        }
        
        strategygame.Location currentL = new strategygame.Location();
        strategygame.Location newL = new strategygame.Location();
        
        currentL.setxPosition(Integer.parseInt(locations[0]));
        currentL.setyPosition(Integer.parseInt(locations[1]));
        newL.setxPosition(Integer.parseInt(locations[2]));
        newL.setyPosition(Integer.parseInt(locations[3]));
        
        System.out.println(" (" + currentL.getxPosition() + " , " + currentL.getyPosition() + ") (" 
                                + newL.getxPosition() + " , " + newL.getyPosition() + ") ");
        
        ((strategygame.MovingAttackingUnit)MyFrame.MAP.Map[currentL.getxPosition()][currentL.getyPosition()]).move(newL);
    }
    
    private void receiveRemove(String s){}
    
    private void receiveStopAttack(String s){}
    
    private void receiveStopCollect(String s){}
    
    private void receiveStopMove(String s){}
    
    private void receiveTrade(String s){}
    
    public void closeSocket() throws IOException{
        soc.close();
    }
    
    public void closeServerSocket() throws IOException{
        Ssoc.close();
    }
}
