
package javaapplication1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
public class show extends JFrame implements ActionListener{
    private JList lst1;
    private JList lst2;
    private JList lst3;
    private JList lst4;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4; 
    private JLabel lbl5; 
    private JButton btn1;
    public show(){
        super("show");
            setLayout(null);
            setSize(800, 550);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon muteIcon = new ImageIcon("background.png");
            setLocationRelativeTo(null);
            
            lbl1=new JLabel("Meals");
            lbl1.setBounds(70, 15, 160, 20);
            lbl1.setForeground(Color.WHITE);
            lbl1.setFont(new Font("Script MT Bold", Font.BOLD, 25));
            add(lbl1);
            
            lst1=new JList();
            lst1.setBounds(70, 50, 200, 400);
            lst1.setForeground(Color.BLACK);
            lst1.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lst1);

            lbl2=new JLabel("Price");
            lbl2.setBounds(295, 15, 160, 20);
            lbl2.setForeground(Color.BLUE);
            lbl2.setFont(new Font("Script MT Bold", Font.BOLD, 25));
            add(lbl2);
            
            lst2=new JList();
            lst2.setBounds(295, 50, 60, 400);
            lst2.setForeground(Color.BLACK);
            lst2.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lst2);
            
            lbl3=new JLabel("Drinks");
            lbl3.setBounds(435, 15, 160, 20);
            lbl3.setForeground(Color.WHITE);
            lbl3.setFont(new Font("Script MT Bold", Font.BOLD, 25));
            add(lbl3);
            
            lst3=new JList();
            lst3.setBounds(435, 50, 200, 400);
            lst3.setForeground(Color.BLACK);
            lst3.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lst3);

            lbl4=new JLabel("Price");
            lbl4.setBounds(660, 15, 160, 20);
            lbl4.setForeground(Color.WHITE);
            lbl4.setFont(new Font("Script MT Bold", Font.BOLD, 25));
            add(lbl4);
            
            lst4=new JList();
            lst4.setBounds(660, 50, 60, 400);
            lst4.setForeground(Color.BLACK);
            lst4.setFont(new Font("Tahoma", Font.BOLD, 20));
            add(lst4);
            
            btn1=new JButton("Back");
            btn1.setFont(new Font("Script MT Bold", Font.BOLD, 25));
            btn1.setBounds(335, 470, 120, 30);
            btn1.addActionListener(this);
            add(btn1);
            
            btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Back) {
                SelectionForm go = new SelectionForm();
                        go.setVisible(true);
                        show.this.dispose(); 
                   
            }     
        });
            
            lbl5 = new JLabel(muteIcon);
            lbl5.setBounds(0,0, 800, 700);
            add(lbl5);  
            
            setVisible(true);
            FillList1();
            FillList2();
            FillList3();
            FillList4();
            
    }
    
    final void FillList1(){
        try{
                               Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from meal";
                ResultSet rs = s.executeQuery(sql);
                DefaultListModel DLM = new DefaultListModel();
                while(rs.next()){
                    DLM.addElement(rs.getString("Name"));
                
                }
                lst1.setModel(DLM);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    final void FillList2(){
        try{
                 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from meal";
                ResultSet rs = s.executeQuery(sql);
                DefaultListModel DLM = new DefaultListModel();
                while(rs.next()){
                    DLM.addElement(rs.getString("Price"));
                
                }
                lst2.setModel(DLM);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
        final void FillList3(){
        try{
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from drinks";
                ResultSet rs = s.executeQuery(sql);
                DefaultListModel DLM = new DefaultListModel();
                while(rs.next()){
                    DLM.addElement(rs.getString("Name"));
                
                }
                lst3.setModel(DLM);
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
        final void FillList4(){
        try{
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from drinks";
                ResultSet rs = s.executeQuery(sql);
                DefaultListModel DLM = new DefaultListModel();
                while(rs.next()){
                    DLM.addElement(rs.getString("Price"));
                
                }
                lst4.setModel(DLM);
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
