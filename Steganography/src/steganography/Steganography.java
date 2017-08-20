
package steganography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Steganography {
     public static Connection con;



    public static int getBitValue(int n,int location)
    {
        int v=n & (int)Math.round(Math.pow(2,location));
        return v==0?0:1;
    }
    
    public static int setBitValue(int n,int location,int bit)
    {
       
        int  toggle=(int)Math.pow(2, location),bv=getBitValue(n,location);
    
        if(bv==bit)
            return n;
        
        if(bv==0 && bit==1)
        {
            n|=toggle;
        }
        else if(bv==1 && bit==0)
            n^=toggle; 

        return n;
    }
    
    public static void main(String[] args) {
         try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection("jdbc:sqlserver://SAKSHAM\\SQLEXPRESS:61294;databaseName=StegnoDB;integratedSecurity=true"); 
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex); 
        }
        enterance e=new enterance();
        e.setVisible(true);
    }
    
}
