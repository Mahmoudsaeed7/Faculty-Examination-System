/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import java.sql.*;
import fet.Person.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAHMOUD SAEED
 */
public class JDBC {
    DefaultTableModel instReqTable;
    DefaultTableModel studReqTable;
    public String mail,usName,usPass;
    public String adminName , adminPass;
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
        int req =0;
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String stud = "INSERT INTO stud_requests(stud_id,stud_name,stud_pass,stud_mail)"
                    + "VALUES(NULL,'"+usName+"','"+usPass+"','"+mail+"')";
            String inst = "INSERT INTO inst_requests(inst_id,inst_name,inst_pass,inst_mail)"
                    + "VALUES(NULL,'"+usName+"','"+usPass+"','"+mail+"')";
            if (mail.contains("stud")) {
                stmt.executeUpdate(stud);
                JOptionPane.showMessageDialog(null, "Added Successfuly..");
            }
            else if (mail.contains("inst")) {
                stmt.executeUpdate(inst);
                JOptionPane.showMessageDialog(null, "Added Successfuly..");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void Login(JDBC j){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM administrator WHERE admin_username=? AND admin_pass=?";
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
    
    public void add_admin(JDBC j){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO administrator(admin_id , admin_username , admin_pass)"
                    + "VALUES(NULL , '"+adminName+"' , '"+adminPass+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public ArrayList<inst_requests> instList(){
        ArrayList<inst_requests> instList = new ArrayList<>();
        
        try{ 
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM inst_requests";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            inst_requests inst;
            
            while(rst.next()){
                inst = new inst_requests(rst.getInt("inst_id"), rst.getString("inst_name"), rst.getString("inst_mail"));
                instList.add(inst);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return instList;
    }
    
    public void showInstData(){
        ArrayList<inst_requests> List = instList();
        
        DefaultTableModel model = instReqTable;
        Object[] row = new Object[3];
        for(int i=0; i<List.size(); i++){
            row[0] = List.get(i).getId();
            row[1] = List.get(i).getName();
            row[2] = List.get(i).getMail();            
            model.addRow(row);
        }
    }
    
    public ArrayList<stud_requests> studList(){
        ArrayList<stud_requests> studList = new ArrayList<>();
        
        try{ 
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM stud_requests";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            stud_requests stud;
            
            while(rst.next()){
                stud = new stud_requests(rst.getInt("stud_id"), rst.getString("stud_name"), rst.getString("stud_mail"));
                studList.add(stud);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return studList;
    }
    
    public void showStudData(){
        ArrayList<stud_requests> List = studList();
        
        DefaultTableModel model = studReqTable;
        Object[] row = new Object[3];
        for(int i=0; i<List.size(); i++){
            row[0] = List.get(i).getId();
            row[1] = List.get(i).getName();
            row[2] = List.get(i).getMail();            
            model.addRow(row);
        }
    }
    
    public int numOfRequests(){
        String instCount="";
        String studCount="";
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String req_count = "SELECT COUNT(inst_requests.inst_name),COUNT(stud_requests.stud_name)"
                    + "FROM inst_requests,stud_requests";
            PreparedStatement pst = conn.prepareStatement(req_count);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
             instCount = rst.getString("COUNT(inst_requests.inst_name)");
             studCount = rst.getString("COUNT(stud_requests.stud_name)");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return Integer.valueOf(instCount)+Integer.valueOf(studCount);
    }
    
    public void add(){
        
    }
}