
package javaapplication1;



import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SplachScreen extends JFrame 
{    
    private  JLabel Background;

    public SplachScreen()
            
    {      
            setLayout(null);
            setUndecorated(true);
            setSize(553, 369);
            setLocationRelativeTo(null);   
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon muteIcon = new ImageIcon("ssrp.gif");
            setVisible(true);   
            Background = new JLabel(muteIcon);
            Background.setBounds(0,0, 553, 369);
            add(Background);
            
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                        Thread.sleep(5000);
                            
                        Login go = new Login();
                        go.setVisible(true);
                        SplachScreen.this.dispose();
                   } catch(InterruptedException ex){
                       
                   }
            }
        
        }).start();
    }
    }

