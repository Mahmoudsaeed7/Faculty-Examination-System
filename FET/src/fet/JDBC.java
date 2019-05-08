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
    Instructor inst = new Instructor();
    DefaultTableModel instReqTable;
    DefaultTableModel instListTable;
    DefaultTableModel studListTable;
    DefaultTableModel studReqTable;
    DefaultTableModel examTable;
    DefaultTableModel studentNames;
    DefaultTableModel sessionsTable;
    DefaultTableModel exTable;
    DefaultTableModel studData;
    
    public int ID,questionNum=0,examID,examDuration;
    public String mail,usName,usPass , adminName , 
            adminPass , examName , courseName , exGrade ,password ,
            question , choose_1 , choose_2 , choose_3 , choose_4 , correctAns,studName ,examDate,accept;
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
            String instLog = "SELECT * FROM instructors WHERE inst_mail=? AND inst_pass=?";
            String studLog = "SELECT * FROM students WHERE stud_mail=? AND stud_pass=?";
            
            if (usName.contains("stud")) {
                PreparedStatement pst = conn.prepareStatement(studLog);
                pst.setString(1, usName);
                pst.setString(2, usPass);
                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    studpanel stud = new studpanel();
                    stud.setVisible(true);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login !");
                }
            }
            else if (usName.contains("inst")) {
                PreparedStatement pst = conn.prepareStatement(instLog);
                pst.setString(1, usName);
                pst.setString(2, usPass);
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    Userform uf = new Userform();
                    uf.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login !");
                }
            }
            else
            {
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
    
    public ArrayList<Instructor> instList(){
        ArrayList<Instructor> instList = new ArrayList<>();
        
        try{ 
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM inst_requests";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            Instructor inst;
            
            while(rst.next()){
                inst = new Instructor(rst.getInt("inst_id"), rst.getString("inst_name"), rst.getString("inst_mail"));
                password = rst.getString("inst_pass");
                instList.add(inst);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return instList;
    }
    
    public void showInstData(){
        ArrayList<Instructor> List = instList();
        
        DefaultTableModel model = instReqTable;
        Object[] row = new Object[3];
        for(int i=0; i<List.size(); i++){
            row[0] = List.get(i).getId();
            row[1] = List.get(i).getName();
            row[2] = List.get(i).getMail();            
            model.addRow(row);
        }
    }
    
    public ArrayList<Student> studList(){
        ArrayList<Student> studList = new ArrayList<>();
        
        try{ 
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM stud_requests";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            Student stud;
            
            while(rst.next()){
                stud = new Student(rst.getInt("stud_id"), rst.getString("stud_name"), rst.getString("stud_mail"));
                password = rst.getString("stud_pass");
                studList.add(stud);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return studList;
    }
    
    public void showStudData(){
        ArrayList<Student> List = studList();
        
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
    
    public void addInst(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String inst_sql = "INSERT INTO instructors(inst_id,inst_name,inst_mail,inst_phone,inst_age,inst_courses,inst_pass)"
                    + "VALUES(NULL,'"+usName+"','"+mail+"',NULL,NULL,NULL,'"+password+"')";
            String delInst = "DELETE FROM inst_requests WHERE inst_id = '"+ID+"'";
            Statement stmt = conn.createStatement();
                stmt.executeUpdate(inst_sql);
                stmt.executeUpdate(delInst);
                JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void addStud(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String stud_sql = "INSERT INTO students(stud_id,stud_name,stud_pass,stud_phone,stud_mail,stud_sessions,stud_grades)"
                    + "VALUES(NULL,'"+usName+"','"+password+"',NULL,'"+mail+"',NULL,NULL)";
            String delStud = "DELETE FROM stud_requests WHERE stud_id = '"+ID+"'";
            Statement stmt = conn.createStatement();
                stmt.executeUpdate(stud_sql);
                stmt.executeUpdate(delStud);
                JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public ArrayList<Instructor> instructorList(){
        ArrayList<Instructor> List = new ArrayList<>();
        
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM instructors";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            
            Instructor inst;
            
            while(rst.next())
            {
                inst = new Instructor(rst.getInt("inst_id"),rst.getString("inst_name"), rst.getString("inst_mail"),rst.getString("inst_phone"),rst.getInt("inst_age"),rst.getInt("inst_courses"));
                List.add(inst);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return List;
    }
    
    public void instData(){
        ArrayList<Instructor> lst = instructorList();
        
        DefaultTableModel model = instListTable;
        Object[] row = new Object[6];
        for(int i=0; i<lst.size(); i++)
        {
            row[0] = lst.get(i).getId();
            row[1] = lst.get(i).getName();
            row[2] = lst.get(i).getMail();
            row[3] = lst.get(i).getPhone();
            row[4] = lst.get(i).getAge();
            row[5] = lst.get(i).getCourses();
            model.addRow(row);
        }
    }
    
    public ArrayList<Student> studentList(){
        ArrayList<Student> List = new ArrayList<>();
        
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            
            Student stud;
            
            while(rst.next())
            {
                stud = new Student(rst.getInt("stud_id"),rst.getString("stud_name"), rst.getString("stud_mail"),rst.getString("stud_phone"),rst.getInt("stud_sessions"),rst.getInt("stud_grades"));
                List.add(stud);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return List;
    }
    
    public void studData(){
        ArrayList<Student> lst = studentList();
        
        DefaultTableModel model = studListTable;
        Object[] row = new Object[6];
        for(int i=0; i<lst.size(); i++)
        {
            row[0] = lst.get(i).getId();
            row[1] = lst.get(i).getName();
            row[2] = lst.get(i).getMail();
            row[3] = lst.get(i).getPhone();
            row[4] = lst.get(i).getSessions();
            row[5] = lst.get(i).getGardes();
            model.addRow(row);
        }
    }
    
    public void deleteStud(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String del = "DELETE FROM stud_requests WHERE stud_id = '"+ID+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(del);
            JOptionPane.showMessageDialog(null, "Deleted Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void deleteInst(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String del = "DELETE FROM inst_requests WHERE inst_id = '"+ID+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(del);
            JOptionPane.showMessageDialog(null, "Deleted Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void addExam(){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO exams(exam_id,exam_name,duration,date,course_name,grades)"
                    + "VALUES(NULL , '"+examName+"' , '"+examDuration+"' , '"+examDate+"' ,'"+courseName+"','"+exGrade+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public ArrayList<Exam> examList(){
        ArrayList<Exam> examLst = new ArrayList<>();
        try{
             Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
             String exam = "SELECT * FROM exams";
             String getGrades = "SELECT grades FROM exams WHERE exam_id = '"+Emergency.ID+"'";
             Statement stmt = conn.createStatement();
             ResultSet rst = stmt.executeQuery(exam);
             Exam ex;
             while(rst.next()){
                 ex = new Exam(rst.getInt("exam_id"), rst.getString("exam_name"), rst.getInt("duration"), rst.getString("date"), rst.getString("course_name"),rst.getInt("grades"));
                 examLst.add(ex);
             }
             ResultSet rst2 = stmt.executeQuery(getGrades);
             if(rst2.next()){
                 Emergency.grade = rst2.getInt("grades");
             }
        }catch(SQLException e){
             System.err.println(e);
        }
        return examLst;
    }
    
    public void showExams(){
        ArrayList<Exam> lst = examList();
        
        DefaultTableModel model = examTable;
        Object [] row = new Object[5];
        for (int i = 0; i < lst.size(); i++) {
            row[0] = lst.get(i).getExamID();
            row[1] = lst.get(i).getExamName();
            row[2] = lst.get(i).getDuration();
            row[3] = lst.get(i).getDate();
            row[4] = lst.get(i).getCourseName();
            model.addRow(row);
        }
    }
    
    public void addQuest(){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String addQuest = "INSERT INTO questions(exam_id,correct_ans,question_num,choose_1,choose_2,choose_3,choose_4,questionNum)"
                    + "VALUES ('"+Emergency.ID+"','"+correctAns+"','"+question+"','"+choose_1+"','"+choose_2+"','"+choose_3+"','"+choose_4+"','"+questionNum+"')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(addQuest);
            JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public ArrayList<Student> studNames(){
        ArrayList<Student> List = new ArrayList<>();
        
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            
            Student stud;
            
            while(rst.next())
            {
                stud = new Student(rst.getString("stud_name"));
                List.add(stud);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return List;
    }
    
    public void studentsNames(){
        ArrayList<Student> lst = studNames();
        
        DefaultTableModel model = studentNames;
        Object[] row = new Object[1];
        for(int i=0; i<lst.size(); i++)
        {
            row[0] = lst.get(i).getName();
            model.addRow(row);
        }
    }
    
    public ArrayList<ExamSession> sessionsList(){
        ArrayList<ExamSession> sessionsLst = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String examData = "SELECT * FROM exam_sessions WHERE stud_names='0'";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(examData);

            ExamSession ex;
            
            while(rst.next()){
                ex = new ExamSession(rst.getInt("sessionID"), rst.getInt("examID"),rst.getString("acceptance"));
                sessionsLst.add(ex);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return sessionsLst;
    }
    
    public void showSessions(){
        ArrayList<ExamSession> lst = sessionsList();
        
        DefaultTableModel model = sessionsTable;
        Object [] row = new Object[3];
        for (int i = 0; i < lst.size(); i++) {
            row[0] = lst.get(i).getSessionID();
            row[1] = lst.get(i).getExamID();
            row[2] = lst.get(i).getAcceptance();
            model.addRow(row);
        }
    }
    
    public void createSession(){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String SQL = "INSERT INTO exam_sessions(sessionID,examID,stud_names,acceptance)"
                    + "VALUES(NULL,'"+Emergency.ID+"','0','close')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void addSession(int row1 , int row2){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String SQL = "INSERT INTO exam_sessions(sessionID,examID,stud_names,acceptance)"
                    + "VALUES(NULL,'"+Emergency.ID+"','"+studName+"','"+accept+"')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Added Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void updateAcceptance(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String update = "UPDATE exam_sessions SET acceptance = 'open' WHERE examID = '"+Emergency.ID+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "Updated Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void updateAcceptance2(int row){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String update = "UPDATE exam_sessions SET acceptance = 'close' WHERE examID = '"+Emergency.ID+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "Updated Successfuly..");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    
    public void exList(){
        ArrayList<Exam> lst = examList();
        
        DefaultTableModel model = exTable;
        Object [] row = new Object[5];
        for (int i = 0; i < lst.size(); i++) {
            row[0] = lst.get(i).getExamID();
            row[1] = lst.get(i).getExamName();
            row[2] = lst.get(i).getDuration();
            row[3] = lst.get(i).getDate();
            row[4] = lst.get(i).getCourseName();
            model.addRow(row);
        }
    }
    
    public String getAcceptanceStatus(){
        String acceptStatus = "";
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT acceptance FROM exam_sessions WHERE examID = '"+Emergency.ID+"'";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            while(rst.next()){
                acceptStatus = rst.getString("acceptance");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return acceptStatus;
    }
    
    public ArrayList<question> questList(){
        ArrayList<question> questLst = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String selectQuest = "SELECT * FROM questions WHERE exam_id = '"+Emergency.ID+"'";
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(selectQuest);
            question quest;
            while(rst.next()){
                quest = new question(rst.getInt("exam_id"), rst.getString("correct_ans"),rst.getString("question_num") , rst.getString("choose_1"), rst.getString("choose_2"), rst.getString("choose_3"), rst.getString("choose_4"), rst.getInt("questionNum"));
                questLst.add(quest);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return questLst;
    }
    
    public void stdName(){
        ArrayList<Student> lst = studNames();
        
        DefaultTableModel model = studData;
        Object[] row = new Object[1];
        for(int i=0; i<lst.size(); i++)
        {
            row[0] = lst.get(i).getName();
            model.addRow(row);
        }
    }
    
}