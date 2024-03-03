
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener  {
    int random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,married,unMarried,other;
    JDateChooser dateChooser;
    SignupOne(){
        Random ran = new Random();
        random = Math.abs(ran.nextInt());
        setLayout(null);
        
        JLabel formno =  new JLabel("APPLICATION FORM NO. " +random );
        formno.setFont(new Font("Railway",Font.BOLD,32));
        formno.setBounds(100,20,600,40);
        add(formno);
        
        JLabel personDetails =  new JLabel("Page 1: Personal Details "  );
        personDetails.setFont(new Font("Railway",Font.BOLD,22));
        personDetails.setBounds(250,70,400,40);
        add(personDetails);
        
        JLabel name =  new JLabel("Name:"  );
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(80,120,200,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300,120,400,30);
        add(nameTextField);
        
        JLabel fname =  new JLabel("Father's Name: "  );
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(80,160,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        fnameTextField.setBounds(300,160,400,30);
        add(fnameTextField);
        
        JLabel dob =  new JLabel("Date Of Birth: "  );
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(80,200,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,200,400,30);
        add(dateChooser);
        
        JLabel gender =  new JLabel("Gender: "  );
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(80,240,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,240,190,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(500,240,200,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email =  new JLabel("Email Address: "  );
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(80,280,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,14));
        emailTextField.setBounds(300,280,400,30);
        add(emailTextField);
        
        JLabel marital =  new JLabel("Marital Status: "  );
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(80,320,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,320,120,30);
        married.setBackground(Color.white);
        add(married);
        
        unMarried = new JRadioButton("UnMarried");
        unMarried.setBounds(430,320,120,30);
        unMarried.setBackground(Color.white);
        add(unMarried);
        
        other = new JRadioButton("Other");
        other.setBounds(560,320,140,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        maritalGroup.add(other);
        
        JLabel address =  new JLabel("Address: "  );
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(80,360,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,14));
        addressTextField.setBounds(300,360,400,30);
        add(addressTextField);
        
        JLabel city =  new JLabel("City: "  );
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(80,400,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,14));
        cityTextField.setBounds(300,400,400,30);
        add(cityTextField);
        
        JLabel state =  new JLabel("State: "  );
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(80,440,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,14));
        stateTextField.setBounds(300,440,400,30);
        add(stateTextField);
        
        JLabel pincode =  new JLabel("Pin Code: "  );
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(80,480,200,30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Railway",Font.BOLD,14));
        pincodeTextField.setBounds(300,480,400,30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(600,530,100,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,650);
        setVisible(true);
        setLocation(350,20);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unMarried.isSelected()){
            marital = "UnMarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else  if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is required");
            }
            else  if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    
    
    }
     public static void main(String arg[]){
        new SignupOne();
    
    
    }
    
    
    
}
