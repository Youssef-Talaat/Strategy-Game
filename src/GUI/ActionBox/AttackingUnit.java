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
public class AttackingUnit extends Unit{
    public JButton stopMove = new JButton("StopMove");
    public JButton stopAttack = new JButton("StopAttack");
    
    public strategygame.MovingAttackingUnit au;
    
    public AttackingUnit(strategygame.MovingAttackingUnit AU){
        super(AU);
        au = AU;
        
        stopAttack.setBounds(60,51,130,25);
        stopMove.setBounds(stopAttack.getX()+stopAttack.getWidth()+8, stopAttack.getY(), stopAttack.getWidth(), stopAttack.getHeight());
        
        stopAttack.addActionListener(new ButtonWatcher());
        stopMove.addActionListener(new ButtonWatcher());
        
        add(stopAttack);
        add(stopMove);
        addImg();
    }
    
    private class ButtonWatcher implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == stopMove)
            {
                au.stopMove();
            }
            else if(e.getSource() == stopAttack)
            {
                au.stopAttack();
            }
        }
    }
}
