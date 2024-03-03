
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    public Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0, 900, 900);
        add(atm);
        
        JLabel text = new JLabel(" Enter the amount you want to deposit ");
        text.setFont(new Font("railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        atm.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("railway",Font.BOLD,22));
        amount.setBounds(170,350,300,30);
        atm.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        atm.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(170,450,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        back.addActionListener(this);
        atm.add(back);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
//        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"plz Enter the amount you want to deposit");
            }
            else{
                try{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+"  Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                        
            }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    public static void main(String args[]){
        new Deposit("");
        
    }
}
