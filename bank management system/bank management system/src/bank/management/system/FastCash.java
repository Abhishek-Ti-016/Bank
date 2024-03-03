
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java .util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,back;
    String pinnumber;
    public FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0, 900, 900);
        add(atm);
        
        JLabel text = new JLabel("Select Withdrawl Amount ");
        text.setFont(new Font("railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(215,300,700,40);
        atm.add(text);
        
        b1 = new JButton("RS 100");
        b1.setBounds(170,415,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b1.addActionListener(this);
        atm.add(b1);  
        
        b2 = new JButton("RS 500");
        b2.setBounds(355,415,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b2.addActionListener(this);
        atm.add(b2);
        
        b3 = new JButton("RS 1000");
        b3.setBounds(170,450,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b3.addActionListener(this);
        atm.add(b3);
        
        b4 = new JButton("RS 2000");
        b4.setBounds(355,450,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b4.addActionListener(this);
        atm.add(b4);
        
        b5 = new JButton("RS 5000");
        b5.setBounds(170,485,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b5.addActionListener(this);
        atm.add(b5);
        
        b6 = new JButton("RS 10000");
        b6.setBounds(355,485,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        b6.addActionListener(this);
        atm.add(b6);
        
        back = new JButton("Back");
        back.setBounds(170,520,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        back.addActionListener(this);
        atm.add(back);
        

        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                
                
                }
                if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null," Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully ");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        } 
    }

        
    
    public static void main(String arg[]){
        new FastCash("");
    }
    
}
