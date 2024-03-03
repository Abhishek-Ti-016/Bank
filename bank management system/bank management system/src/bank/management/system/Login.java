
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton signIn,clear,signUp;
    JTextField card;
    JPasswordField pinTextField;
    Login (){
        
        setTitle("AUTOMATED TAILOR MACHINE");
        setLayout(null);
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel(" Welcome to ATM ");
        text.setFont(new Font("Onward",Font.BOLD,38));
        text.setBounds(200,30,400,40);
        add(text);
        
        JLabel cardno = new JLabel(" Card No: ");
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        card = new JTextField();
        card.setBounds(280,150,200,40);
        card.setFont(new Font("Arial",Font.BOLD,16));
        add(card);
        
        JLabel pin = new JLabel(" PIN: ");
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120,200,400,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(280,200,200,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(pinTextField);
        
        signIn = new JButton("SIGN IN");
        signIn.setBounds(280,250,90,40);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        
        clear = new JButton("CLEAR");
        clear.setBounds(380,250,100,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(280,300,200,40);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        
        getContentPane().setBackground(Color.WHITE);
          
        
        setSize(800,400);
        setVisible(true);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            card.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource()==signIn){
            Conn c = new Conn();
            String cardnumber = card.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs  = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin" );
                }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if (ae.getSource()==signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        
        
    }
    public static void main(String arg[]){
        new Login();
    
    
    }
            
    
}
