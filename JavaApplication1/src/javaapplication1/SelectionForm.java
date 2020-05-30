
package javaapplication1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class SelectionForm extends JFrame {
    
    private JButton  btn1;
    private JButton  btn2;
    private JButton  btn4;
    private  JLabel Background;

    
    public SelectionForm(){  
        super("Selection Form");
        setLayout(null);
        setSize(800 , 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon muteIcon = new ImageIcon("background.png");
        setLocationRelativeTo(null);
        
        btn1 = new JButton("Order");
        btn1.setBounds(300,90,150,50);
        add(btn1);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Exit) {
                 Order go = new Order();
                        go.setVisible(true);
                        SelectionForm.this.dispose(); 
            }
        });
        
        btn2 = new JButton("Show Meals/Drinks");
        btn2.setBounds(300,220,150,50);
        add(btn2);
        
         btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Exit) {
                 show go = new show();
                        go.setVisible(true);
                        SelectionForm.this.dispose(); 
            }
        });
        
        btn4 = new JButton("Exit");
        btn4.setBounds(300,350,150,50);
        add(btn4);
        
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Exit) {
                SelectionForm.this.processWindowEvent(new WindowEvent(SelectionForm.this, WindowEvent.WINDOW_CLOSING));
            }
        });

        Background = new JLabel(muteIcon);
        Background.setBounds(0,0, 800,600);
        add(Background);
        
        setVisible(true);
    }
    
}
