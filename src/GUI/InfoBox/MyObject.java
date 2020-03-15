/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

import javax.swing.JLabel;

/**
 *
 * @author Youssef
 */
public abstract class MyObject extends InfoBox{
    public JLabel image = new JLabel("IMAGE");
    public JLabel name = new JLabel();
    public JLabel health = new JLabel();
    
    public MyObject(){
        super();
        
        name.setBounds(55, 28, 120, 30);        
        image.setBounds(name.getBounds().x, name.getBounds().y + 50, 120, 120);
        health.setBounds(220, 43, 180, 30);
        
        add(name);
        add(image);
        add(health);
    }
    
    public abstract void updateIB();
}
