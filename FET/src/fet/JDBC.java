/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import java.sql.*;
import fet.Person.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHMOUD SAEED
 */
public class JDBC {
    public String mail,usName,usPass;
    public static  String USERNAME = "root";
    public static  String PASSWORD = "";
    public static  String CONN_STRING = "jdbc:mysql://localhost:3306/fes";
    public static void main(String[] args) {
        
        try{
           Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void registration(JDBC j){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO students(stud_id,stud_name,stud_pass,stud_phone,stud_mail,stud_sessions,stud_grades)"
                    + "VALUES(NULL,'"+usName+"','"+usPass+"','01115736084','"+mail+"',5,10)";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, usName);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void Login(JDBC j){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM students WHERE stud_name=? AND stud_pass=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usName);
            pst.setString(2, usPass);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                Admin admin = new Admin();
                admin.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Login !");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
