
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    public PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0, 0, 900, 900);
        add(atm);
        
        JLabel text = new JLabel(" CHANGE YOUR PIN ");
        text.setFont(new Font("railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,40);
        atm.add(text);
        
        JLabel pintext = new JLabel(" NEW PIN: ");
        pintext.setFont(new Font("railway",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,30);
        atm.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(350,320,150,30);
        pin.setFont(new Font("Arial",Font.BOLD,22));
        atm.add(pin);
        
        JLabel repintext = new JLabel(" RE-ENTER NEW PIN: ");
        repintext.setFont(new Font("railway",Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,30);
        atm.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(350,360,150,30);
        repin.setFont(new Font("Arial",Font.BOLD,22));
        atm.add(repin);
        
        change = new JButton("Change");
        change.setBounds(165,485,150,30);
//        deposit.setBackground(Color.BLACK);
//        deposit.setForeground(Color.WHITE);
        change.addActionListener(this);
        atm.add(change);
        
        back = new JButton("Back");
        back.setBounds(165,520,150,30);
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
        if(ae.getSource()==change){
        
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Re-enter pin does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null," Please Enter  New Pin");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null," Please Re-Enter  New Pin");
                return;
            }
            Conn c = new Conn();
            String query = " update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
            String query2 = " update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
            String query3 = " update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        
            
            
        }
        catch(Exception e){
            System.out.println(e);
        
        }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String arg[]){
        new PinChange("").setVisible(true);
    }
    
}
