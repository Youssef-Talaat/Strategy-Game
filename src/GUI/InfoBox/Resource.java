/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.InfoBox;

/**
 *
 * @author Youssef
 */
public class Resource extends MyObject{
    public strategygame.Resource r;
    
    public Resource(strategygame.Resource R){
        super();
        r = R;
        
        name.setText(""+r.name);
        health.setText("Amount:   "+r.getCurrentQuantity()+ "/" + r.getMainQuantity());
        addImg();
    }
    
    public void updateIB(){
        health.setText("Amount:   "+r.getCurrentQuantity()+ "/" + r.getMainQuantity());
    }
}
