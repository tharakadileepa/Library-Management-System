
package lk.tharaka.librarymgt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection dBconnection;
    private Connection connection;

    private DBconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymgt","root","1234");
    
    }

    public static DBconnection getInstance() throws ClassNotFoundException, SQLException{
        
        if(dBconnection==null){
            dBconnection= new DBconnection();
            
        }
        
        return dBconnection;
       
}
    public Connection getConnection(){
        return connection;
        
    }
    
    
    
}
