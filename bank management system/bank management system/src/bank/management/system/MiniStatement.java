
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    public MiniStatement(String pinnumber){
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,30);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,100,300,30);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,30);
        
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            int bal = 0;
            
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your Current Balance is "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
//        setUndecorated(true);
        setLocation(20,20);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
    }
    public static void main(String arg[]){
        new MiniStatement("");
        
                
    }
    
}
