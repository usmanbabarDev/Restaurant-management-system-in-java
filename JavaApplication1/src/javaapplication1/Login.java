
package javaapplication1;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    private  JLabel  llog;
    private  JLabel  lpass;
    private  JButton logbtn;
    private  JButton exitbtn;
    private JButton logbtn2;
    private  JPasswordField passf;
    private  JTextField txtf;
    private  JLabel Background;
    
    public Login (){
    super("Resturant Project");
        setLayout(null);
        setSize(700,530);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon muteIcon = new ImageIcon("Background.png");
        setLocationRelativeTo(null);
       
        llog = new JLabel("Username");
        llog.setBounds(210,110, 180, 80);
        llog.setFont(new Font("Script MT Bold", Font.BOLD, 30));
        llog.setForeground(Color.WHITE);
        add(llog);
        
        lpass = new JLabel("Password");
        lpass.setBounds(210,190, 150, 80);
        lpass.setForeground(Color.WHITE);
        lpass.setFont(new Font("Script MT Bold", Font.BOLD, 30));
        add(lpass);
        
        logbtn2 = new JButton("Not Manager");
        logbtn2.setBounds(245,360, 130, 30);
        logbtn2.setFont(new Font("Script MT Bold", Font.BOLD, 15));
        logbtn2.addActionListener(this);
        add(logbtn2);
        
        passf = new JPasswordField();
        passf.setBounds(210,250, 200, 30);
        passf.setToolTipText("Enter Your Password");
        add(passf);
        
        txtf = new JTextField();
        txtf.setBounds(210,170, 200, 30);
        add(txtf);
        
        
        logbtn = new JButton("Login");
        logbtn.setBounds(255, 310,100 , 30);
        logbtn.setFont(new Font("Script MT Bold", Font.BOLD, 20));
        add(logbtn);
        
        
         logbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent login) {
            String username= txtf.getText();
            String pass=passf.getText();
        if (pass.contains("279")&&username.contains("usman")){
           Login.this.dispose();
           new Modify().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "This Password is extremly wrong \n Click ok and try again","Wrong password",JOptionPane.ERROR_MESSAGE);
            
        } 
            }
        });
        
        exitbtn = new JButton("Exit");
        exitbtn.setBounds(255,410, 100, 30);
        exitbtn.setFont(new Font("Script MT Bold", Font.BOLD, 20));
        add(exitbtn);
        
        
        exitbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Exit) {
            Login.this.processWindowEvent(new WindowEvent(Login.this, WindowEvent.WINDOW_CLOSING));       
            }     
        });
        
        
        Background = new JLabel(muteIcon);
        Background.setBounds(0,0,700,530);
        add(Background);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== logbtn2){
            Login.this.dispose();
            new SelectionForm().setVisible(true);
        }
    }
}