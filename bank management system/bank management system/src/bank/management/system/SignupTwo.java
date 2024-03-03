
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener  {
    
    JTextField panTextField,aadharTextField;
    JComboBox religions,categories,incomes,education,occupations;
    JButton next;
    JRadioButton  syes,sno,eyes,eno;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
                
        JLabel additionalDetails =  new JLabel("Page 2: Additional Details "  );
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(250,70,400,40);
        add(additionalDetails);
        
        JLabel religion =  new JLabel("Religion:"  );
        religion.setFont(new Font("Railway",Font.BOLD,20));
        religion.setBounds(80,120,200,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300,120,400,30);
        religions.setBackground(Color.WHITE);
        add(religions);
        
        JLabel category =  new JLabel("Category: "  );
        category.setFont(new Font("Railway",Font.BOLD,20));
        category.setBounds(80,160,200,30);
        add(category);
        
        String valCategory[] = {"GEN","OBC","SC","ST","Other"};
        categories = new JComboBox(valCategory);
        categories.setBounds(300,160,400,30);
        categories.setBackground(Color.WHITE);
        add(categories);
        
      
        
        JLabel income =  new JLabel("Income: "  );
        income.setFont(new Font("Railway",Font.BOLD,20));
        income.setBounds(80,200,200,30);
        add(income);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto to 10,00,000"};
        incomes = new JComboBox(valIncome);
        incomes.setBounds(300,200,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);
                
        JLabel educational =  new JLabel("Educational "  );
        educational.setFont(new Font("Railway",Font.BOLD,20));
        educational.setBounds(80,240,200,30);
        add(educational);
          
        JLabel qualification =  new JLabel("Qualification: "  );
        qualification.setFont(new Font("Railway",Font.BOLD,20));
        qualification.setBounds(80,270,200,30);
        add(qualification);
        
        String educationValues[] = {"PHD","Master","Graduation","12th","10th","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300,270,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
                
        JLabel occupation =  new JLabel("Occupation: "  );
        occupation.setFont(new Font("Railway",Font.BOLD,20));
        occupation.setBounds(80,320,200,30);
        add(occupation);
        
        String occupationValues[] = {"Salaried","Self employed","Business","Student","Retired","Other"};
        occupations = new JComboBox(occupationValues);
        occupations.setBounds(300,320,400,30);
        occupations.setBackground(Color.WHITE);
        add(occupations);
        
        
        
        JLabel pan =  new JLabel("PAN Number: "  );
        pan.setFont(new Font("Railway",Font.BOLD,20));
        pan.setBounds(80,360,200,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Railway",Font.BOLD,14));
        panTextField.setBounds(300,360,400,30);
        add(panTextField);
        
        JLabel aadhar =  new JLabel("Aadhar Number: "  );
        aadhar.setFont(new Font("Railway",Font.BOLD,20));
        aadhar.setBounds(80,400,200,30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Railway",Font.BOLD,14));
        aadharTextField.setBounds(300,400,400,30);
        add(aadharTextField);
        
        JLabel seniorCitizen =  new JLabel("Senior Citizen: "  );
        seniorCitizen.setFont(new Font("Railway",Font.BOLD,20));
        seniorCitizen.setBounds(80,440,200,30);
        add(seniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,440,190,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(500,440,200,30);
        sno.setBackground(Color.white);
        add(sno);
        
        
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
                       
        JLabel existingAccount =  new JLabel("Existing Account: "  );
        existingAccount.setFont(new Font("Railway",Font.BOLD,20));
        existingAccount.setBounds(80,480,200,30);
        add(existingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,480,190,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(500,480,200,30);
        eno.setBackground(Color.white);
        add(eno);
        
        
        
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);
        
        
        
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
        String creligions = (String) religions.getSelectedItem();
        String ccategories  = (String) categories.getSelectedItem();
        String cincomes  = (String) incomes.getSelectedItem();
        String ceducation  = (String) education.getSelectedItem();
        String coccupations  = (String) occupations.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount="Yes";
        }
        else if(eno.isSelected()){
            existingAccount = "NO";
        }
       
                
        try{
           
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+creligions+"','"+ccategories+"','"+cincomes+"','"+ceducation+"','"+coccupations+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
                
            }
            
            
        
        catch(Exception e){
            System.out.println(e);
        }
    
    
    
    }
     public static void main(String arg[]){
        new SignupTwo("");
    
    
    }
    
    
    
}

    

