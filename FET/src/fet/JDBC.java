/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import java.sql.*;
import fet.Person.*;

/**
 *
 * @author MAHMOUD SAEED
 */
public class JDBC {
    public static  String USERNAME = "root";
    public static  String PASSWORD = "";
    public static  String CONN_STRING = "jdbc:mysql://localhost:3306/fes";
    public static void main(String[] args) {
        
        try{
           Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch(SQLException e){
            System.err.println("Not connected");
        }
    }
    
    public void registration(){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO students(stud_id,stud_name,stud_phone,stud_mail,stud_sessions,stud_grades)"
                    + "VALUES()";
        }catch(SQLException e){
            
        }
    }
}
