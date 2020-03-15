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
public class CreatingBuildingUnit extends Unit{
    public JButton create = new JButton();
    
    public strategygame.CreatingBuildingUnit cbu;
    
    public CreatingBuildingUnit(strategygame.CreatingBuildingUnit CBU){
        super(CBU);
        cbu = CBU;
        
        create.setBounds(97,58,120,25);
        create.addActionListener(new createChar());
        
        remove.setBounds(create.getX() + create.getWidth() + 20, create.getY(), 120, 25);
        
        add(create);
        add(remove);
        addImg();
    }
    
    private class createChar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cbu.createCharacter();
        }
    }
}
