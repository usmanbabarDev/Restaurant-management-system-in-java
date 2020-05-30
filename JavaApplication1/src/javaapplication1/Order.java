
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


///////////////////////////////////////////////////////////////////////////

public class Order extends JFrame implements ActionListener{
     
     private  JLabel     ReciptL;
     private  JLabel     COfD;
     private  JLabel     COfM;
     private  JLabel     COfDI ;
     private  JLabel     D  ;
     private  JLabel     mealL;
     private  JLabel     DrinkL;
     private  JLabel     NOMeal;
     private  JLabel     NODrink;
     private  JLabel     Total;
     private  JLabel     Background;
///////////////////////////////////////////////////
     private  JButton    addMeals;
     private  JButton    addDrinks;
     private  JButton    Printbtn;
     private  JButton    Totalbtn;
     private  JButton    reciptbtn;
     private  JButton    resetbtn;
     private  JButton    exitbtn;
     private  JButton    backbtn;
     //////////////////////////////////////////////
     private  JTextField NOTxtDrinks;
     private  JTextField totaltxt;
     private  JTextField NOTxtMeals;
     private  JTextField CD;
     private  JTextField CM;
     private  JTextField CDI;
     private  JTextField DIS;
     ///////////////////////////////////////////////
     private  JCheckBox  HDCheckBox;
     private  JComboBox  MealCombo;
     private  JComboBox  DrinkCombo;
     ///////////////////////////////////////////////
     private  JList      reciptList;  


     //////////////////////////////////////////////
     
     public Order(){
    
        super("Order Form");
        setLayout(null);
        setSize(450,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon muteIcon = new ImageIcon("background.png");
        setLocationRelativeTo(null);
        
    /////////////////////////////////////////////////////////////////////////////
        
        mealL = new JLabel("Select Meal");
        mealL.setBounds(25,10, 150, 20);
        mealL.setForeground(Color.WHITE);
        mealL.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(mealL);
        
        DrinkL = new JLabel("Select Drink");
        DrinkL.setBounds(25,60, 120, 20);
        DrinkL.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        DrinkL.setForeground(Color.WHITE);
        add(DrinkL);
        
        NOMeal = new JLabel("Number");
        NOMeal.setBounds(150,10, 90, 20);
        NOMeal.setForeground(Color.WHITE);
        NOMeal.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(NOMeal);
     
        NODrink = new JLabel("Number");
        NODrink.setBounds(150,60, 90, 20);
        NODrink.setForeground(Color.WHITE);
        NODrink.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(NODrink);
       
        COfD = new JLabel("Cost of Drinks");
        COfD.setBounds(25,170, 120, 20);
        COfD.setForeground(Color.WHITE);
        COfD.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(COfD);
        
        COfM = new JLabel("Cost of Meals");
        COfM.setBounds(25,210, 120, 20);
        COfM.setForeground(Color.WHITE);
        COfM.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(COfM);
        
        COfDI = new JLabel("Cost of Dilevery");
        COfDI.setBounds(25,250, 140, 20);
        COfDI.setForeground(Color.WHITE);
        COfDI.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(COfDI);
        
        D = new JLabel("Discount %");
        D.setBounds(25,290, 90, 20);
        D.setForeground(Color.WHITE);
        D.setFont(new Font("Script MT Bold", Font.BOLD, 17));
        add(D);
        
     
      
        
        Total = new JLabel("Total");
        Total.setBounds(25,370, 50, 20);
        Total.setForeground(Color.WHITE);
        Total.setFont(new Font("Script MT Bold", Font.BOLD, 20));
        add(Total);
        
      //////////////////////////////////////////////////////////////////
        
        MealCombo =new JComboBox ();
        MealCombo.setBounds(25, 30, 90, 20);
        JScrollPane JSP1 = new JScrollPane(MealCombo);
        add(MealCombo);
    
        
        DrinkCombo =new JComboBox ();
        DrinkCombo.setBounds(25, 80, 90, 20);
        JScrollPane JSP2 = new JScrollPane(DrinkCombo);
        add(DrinkCombo);
      ///////////////////////////////////////////////////////////////////////
      
        HDCheckBox =new JCheckBox("Home Delivery");
        HDCheckBox.setBounds(200, 115, 120, 20);
        HDCheckBox.addActionListener(this);
        add(HDCheckBox);
        
       //////////////////////////////////////////////////////////////////////
        
        NOTxtMeals = new JTextField("0");
        NOTxtMeals.setBounds(150, 30, 90, 20);
        add(NOTxtMeals);
        
        
        NOTxtDrinks = new JTextField("0");
        NOTxtDrinks.setBounds(150,80, 90, 20);
        add(NOTxtDrinks);
        
        
        CD = new JTextField("0");
        CD.setBounds(150,170,150,20);
        CD.setEditable(false);
        add(CD);
        
        
        CM = new JTextField("0");
        CM.setBounds(150,210, 150, 20);
        CM.setEditable(false);
        add(CM);
        
        CDI = new JTextField("0");
        CDI.setEditable(false);
        CDI.setBounds(150,250, 150, 20);
        add(CDI);
        
        DIS = new JTextField("0");
        DIS.setBounds(150,290, 150, 20);
        add(DIS);
        
        totaltxt = new JTextField("0");
        totaltxt.setEditable(false);
        totaltxt.setBounds(25, 400,150, 20);
        add(totaltxt);
        
        ///////////////////////////////////////////////////////////////////////
        
        addMeals= new JButton("ADD");
        addMeals.setBounds(250,30, 70, 20);
        addMeals.addActionListener(this);
        add(addMeals);
        
        addDrinks= new JButton("ADD");
        addDrinks.setBounds(250,80, 70, 20);
        addDrinks.addActionListener(this);
        add(addDrinks);
        
        Totalbtn = new JButton("Count");
        Totalbtn.setBounds(200, 400, 70, 20);
        Totalbtn.addActionListener(this);
        add(Totalbtn);
        
     
        ///////////////////////////////////////////////////////////////////////
        resetbtn= new JButton("Reset");
        resetbtn.setBounds(55, 500, 160, 40);
        add(resetbtn);
        resetbtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                  Order.this.dispose();
                  new Order().setVisible(true);
             }
         });
        ///////////////////////////////////////////////////////////////////////
        backbtn= new JButton("Back");
        backbtn.setBounds(55, 550, 160, 40);
        add(backbtn); 
        backbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Back) {
                SelectionForm go = new SelectionForm();
                        go.setVisible(true);
                        Order.this.dispose(); 
                   
            }     
        });
        ///////////////////////////////////////////////////////////////////////
        exitbtn= new JButton("Exit");
        exitbtn.setBounds(55, 600, 160, 40);
        add(exitbtn);
        exitbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent Exit) {
            Order.this.processWindowEvent(new WindowEvent(Order.this, WindowEvent.WINDOW_CLOSING));       
            }     
        });
        ///////////////////////////////////////////////////////////////////////
        
        
        
        
        Background = new JLabel(muteIcon);
        Background.setBounds(0,0, 800, 700);
        add(Background);
        
        setVisible(true);
        FillCombo1();
        FillCombo2();
     }
    private void FillCombo1(){
    try{
     Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");               
     Statement s = con.createStatement();
                String sql ="select*from meal";
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()){
                    String name =rs.getString("Name");
                    MealCombo.addItem(name);
                    
                }
        }
    catch(Exception e ){JOptionPane.showMessageDialog(null,e);}
    }
    private void FillCombo2(){
    try{
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select*from drinks";
                ResultSet rs = s.executeQuery(sql);
                while(rs.next()){
                    String name =rs.getString("Name");
                    DrinkCombo.addItem(name);
                    
                }
                
        }
    catch(Exception e ){JOptionPane.showMessageDialog(null,e);}
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addMeals){
            try{
                int n,num;
                               Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select Price from meal where Name='"+MealCombo.getSelectedItem()+"'";
                ResultSet rs = s.executeQuery(sql);
                rs.next();
                n=rs.getInt(1);
                num=Integer.parseInt(NOTxtMeals.getText());
                n*=num;
                num=Integer.parseInt(CM.getText());
                CM.setText(Integer.toString(n+num));
                NOTxtMeals.setText("0");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        }
        if(ae.getSource()==addDrinks){
             try{
                int n,num;
                               Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/acp","root","");
                Statement s = con.createStatement();
                String sql ="select Price from drinks where Name='"+DrinkCombo.getSelectedItem()+"'";
                ResultSet rs = s.executeQuery(sql);
                rs.next();
                n=rs.getInt(1);
                num=Integer.parseInt(NOTxtDrinks.getText());
                n*=num;
                num=Integer.parseInt(CD.getText());
                CD.setText(Integer.toString(n+num));
                NOTxtDrinks.setText("0");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        }
        if(ae.getSource()==HDCheckBox){
        if (HDCheckBox.isSelected()){
            int x;
            x=Integer.parseInt(CDI.getText());
            x+=10;
            CDI.setText(Integer.toString(x));
        }
        else {
            int x;
            x=Integer.parseInt(CDI.getText());
            x-=10;
            CDI.setText(Integer.toString(x));
        }}
        if(ae.getSource()==Totalbtn){
            int x=0,y;
            y=Integer.parseInt(CM.getText());
            x+=y;
            y=Integer.parseInt(CD.getText());
            x+=y;
            y=Integer.parseInt(CDI.getText());
            x+=y;
            y=Integer.parseInt(DIS.getText());
            if(y>25){
            JOptionPane.showMessageDialog(null, "This Discount value >25% can't be executed  \n it'll be represented as 0%","Wrong value",JOptionPane.INFORMATION_MESSAGE);
            }
            else {x-=(x*y)/100;}
            totaltxt.setText(Integer.toString(x));
        }
    }
}
