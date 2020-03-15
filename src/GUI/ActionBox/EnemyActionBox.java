/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ActionBox;

import javax.swing.JLabel;

/**
 *
 * @author Youssef
 */
public class EnemyActionBox extends ActionBox{
    public JLabel enemy = new JLabel("ENEMY");
    
    public EnemyActionBox(){
        super();
        enemy.setBounds(177, 95, 100, 50);
        add(enemy);
    }
}
