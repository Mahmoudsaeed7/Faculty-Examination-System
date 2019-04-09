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
       // s.setVisible(true);
        s.setSize(1450, 1000);
         Login l=new Login();
//         l.setVisible(true);
//         l.setSize(1450, 1000);
//         l.setExtendedState(JFrame.MAXIMIZED_BOTH);
   //    jPanel1.setSize(width, height);
        
       
       // jPanel1.setSize(width, height);
        try {
            for (int i = 0; i < 100; i++) {
            Thread.sleep(40);    
               
                
            }
             s.setVisible(true);
//             l.setSize(width, height);
           
             l.setExtendedState(JFrame.MAXIMIZED_BOTH);
             l.setVisible(true);
             l.setUndecorated(true);
            
        } catch (Exception e) {
        }
        
     
     
       
    }
    
}
