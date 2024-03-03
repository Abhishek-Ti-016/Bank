
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    public Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0, 900, 900);
        add(atm);
        
        JLabel text = new JLabel(" Please Select Your Transactions ");
        text.setFont(new Font("railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(215,300,700,40);
        atm.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        atm.add(deposit);  
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        withdrawl.addActionListener(this);
        atm.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        atm.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        ministatement.addActionListener(this);
        atm.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        atm.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        balanceenquiry.addActionListener(this);
        atm.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(170,520,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        atm.add(exit);
        

        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String arg[]){
        new Transactions("");
    }
    
}
