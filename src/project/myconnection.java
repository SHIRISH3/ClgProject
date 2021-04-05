package project;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
 
public class myconnection {
    
     public static Connection getConnection(){
     
        Connection con = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Shirish3302");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
        
    public static void main(String[] args){
       Connection conn = null;
        Statement stmt = null;
        
        try{
            //step-3:register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //step-4:open a connection
            System.out.println("connection to database...");
             conn = myconnection.getConnection();
            
            //step-5:Execute a query
            System.out.println("creating database....");
            stmt = conn.createStatement();
            
            String sql = "CREATE DATABASE project";
            stmt.executeUpdate(sql);
            
            System.out.println("Database created successfully...");
           }catch(SQLException se){
            //Handle error for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle error  for class.forname
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                
            }//noting we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    } //end try  
}//end main
}//end JDBCExample