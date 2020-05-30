
package javaapplication1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//////////////////////////////////////////////////////////////////

public class Modify extends JFrame implements ActionListener{

    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private JLabel lbl6;
    private JLabel Background;
   
    ///////////////////////////
   
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    
    ///////////////////////////
    
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    
    //////////////////////////
    
    private JList lst1;
    private JList lst2;
    
   //////////////////////////
    
    public Modify() {
        super("Modify");
        setLayout(null);
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon muteIcon = new ImageIcon("background.png");
        setLocationRelativeTo(null);
        ////////////////////////////////////////////////
        lbl1 = new JLabel("Meal");
        lbl1.setBounds(15, 85, 70, 20);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl1);

        txt1 = new JTextField("");
        txt1.setBounds(15, 110, 120, 30);
        add(txt1);
        
        txt2 = new JTextField("");
        txt2.setBounds(15, 175, 120, 30);
        add(txt2);


        lbl2 = new JLabel("Price");
        lbl2.setBounds(15, 150, 70, 20);
        lbl2.setForeground(Color.WHITE);
        lbl2.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl2);

        btn1 = new JButton("Add");
        btn1.setBounds(180, 90, 100, 35);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Edit");
        btn2.setBounds(180, 130, 100, 35);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("Remove");
        btn3.setBounds(180, 170, 100, 35);
        btn3.addActionListener(this);
        add(btn3);

        lbl3 = new JLabel("Drink");
        lbl3.setBounds(15, 270, 70, 20);
        lbl3.setForeground(Color.WHITE);
        lbl3.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl3);

        txt3 = new JTextField();
        txt3.setBounds(15, 295, 120, 30);
        add(txt3);

        lbl4 = new JLabel("Price");
        lbl4.setBounds(15, 335, 70, 20);
        lbl4.setForeground(Color.WHITE);
        lbl4.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl4);

        txt4 = new JTextField();
        txt4.setBounds(15, 360, 120, 30);
        add(txt4);

        btn4 = new JButton("Add");
        btn4.setBounds(180, 275, 100, 35);
        btn4.addActionListener(this);
        add(btn4);

        btn5 = new JButton("Edit");
        btn5.setBounds(180, 315, 100, 35);
        btn5.addActionListener(this);
        add(btn5);

        btn6 = new JButton("Remove");
        btn6.setBounds(180, 355, 100, 35);
        btn6.addActionListener(this);
        add(btn6);

        lbl5 = new JLabel("Meal Menu");
        lbl5.setBounds(350, 15, 140, 20);
        lbl5.setForeground(Color.WHITE);
        lbl5.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl5);

        lbl6 = new JLabel("Drinks Menu");
        lbl6.setBounds(580, 15, 160, 20);
        lbl6.setForeground(Color.WHITE);
        lbl6.setFont(new Font("Script MT Bold", Font.BOLD, 25));
        add(lbl6);

        lst1 = new JList();
        lst1.setBounds(350, 40, 200, 410);
        lst1.setForeground(Color.BLACK);
        lst1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lst1);
        
        lst2 = new JList();
        lst2.setBounds(580, 40, 200, 410);
        lst2.setForeground(Color.BLACK);
        lst2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lst2);
        
        lst1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                 try{
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");

                     Statement s = con.createStatement();
                String sql ="select*from meal where Name='"+lst1.getSelectedValue()+"'";
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()){
                    txt1.setText(rs.getString(1));
                    txt2.setText(rs.getInt(2)+"");
                }
                
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
            }
        });
        
    lst2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                 try{
                               Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from drinks where Name='"+lst2.getSelectedValue()+"'";
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()){
                    txt3.setText(rs.getString(1));
                    txt4.setText(rs.getInt(2)+"");
                }
                
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
            }
        });        
        Background = new JLabel(muteIcon);
        Background.setBounds(0, 0, 800, 700);
        add(Background);
        setVisible(true);
        
        FillList1();
        FillList2();
       
        
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
                String sql ="select*from drinks";
                ResultSet rs = s.executeQuery(sql);
                DefaultListModel DLM = new DefaultListModel();
                while(rs.next()){
                    DLM.addElement(rs.getString("Name"));
                  
                }
                lst2.setModel(DLM);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    
    private void lst1ValueChanged(ListSelectionEvent e){
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn4) {
            try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "insert into drinks "
                        + "(Name,Price)"
                        + "values('"+ txt3.getText() + "','"+ Integer.parseInt(txt4.getText()) + "')";
                
                
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Drink Added To Menu");
                FillList2();
                txt3.setText(null);
                txt4.setText("0");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

        }
        if (ae.getSource() == btn1) {
            try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                
                String sql = "insert into meal "
                        + "(Name,Price)"
                        + "values('"+ txt1.getText() + "','"+ Integer.parseInt(txt2.getText()) + "')";
                
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Meal Added To Menu");
                FillList1();
                txt1.setText(null);
                txt2.setText("0");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

        }
        if(ae.getSource()==btn2){
            try {
                 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "update meal set Name = '"+txt1.getText()+"', Price='"+txt2.getText()+"' WHERE Name ='"+lst1.getSelectedValue()+"'";
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Meal Infromation Updated Successfully");
                FillList1();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                
                String sql = "insert into meal "
                        + "(Name,Price)"
                        + "values('"+ txt1.getText() + "','"+ Integer.parseInt(txt2.getText()) + "')";
                
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Meal Added To Menu");
                FillList1();
                txt1.setText(null);
                txt2.setText("0");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
        
        if(ae.getSource()==btn5){
            try {
                 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "update drinks set Name = '"+txt3.getText()+"', Price='"+txt4.getText()+"' WHERE Name ='"+lst2.getSelectedValue()+"'";
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Drinks Infromation Updated Successfully");
                FillList2();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "insert into drinks "
                        + "(Name,Price)"
                        + "values('"+ txt3.getText() + "','"+ Integer.parseInt(txt4.getText()) + "')";
                
                
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Drink Added To Menu");
                FillList2();
                txt3.setText(null);
                txt4.setText("0");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

        }
        if(ae.getSource()==btn3){
        try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "Delete from meal where Name = '"+lst1.getSelectedValue()+"' ";
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Meal Infromation Deleted Successfully");
                FillList1();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        
        }
        if(ae.getSource()==btn6){
        try {
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql = "Delete from drinks where Name = '"+lst2.getSelectedValue()+"' ";
                s.execute(sql);
                JOptionPane.showMessageDialog(null, "Drinks Infromation Delete Successfully");
                FillList2();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        
        }
        
    
    }
    
}
