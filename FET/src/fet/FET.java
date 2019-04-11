/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;

import java.awt.Toolkit;
import javax.swing.JFrame;
//import static javax.swing.*;
import fet.Splash;

/**
 *
 * @author Pharaoh
 */
 
public class FET {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Splash s=new Splash();
        s.setVisible(true);
       Login l=new Login();
      
        try {
            for (int i = 0; i < 100; i++) {
            Thread.sleep(5);                     
            }                      
             s.setVisible(false);
             l.setVisible(true);
             l.setUndecorated(true);           
        } catch (Exception e) {
        }
        
     
     
       
    }
    
}
