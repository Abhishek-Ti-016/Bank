
package bank.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","ttta5451");
            if(c!=null){
                System.out.println("successfully connected ");
            }
            s = c.createStatement();
            
        }
        catch(Exception e){
           System.out.println(e);
           System.out.println("not connected ");
           
        }
    }
    
}
