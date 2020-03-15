/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ActionBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Youssef
 */
public class Unit extends ActionBox{
    public JButton remove = new JButton("Remove");
    
    public strategygame.Unit u;
    
    public Unit(strategygame.Unit U){
        super();
        u = U;
        
        remove.addActionListener(new ButtonWatcher());
    }
    
    private class ButtonWatcher implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            u.selfDestroy();
        }
    }
}
