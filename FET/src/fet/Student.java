/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import java.util.ArrayList;
/**
 *
 * @author admin
 */

     class Student extends User{
        int id;
        ArrayList<String> enrolledExamSessionsId = new ArrayList<String>();
        ArrayList<String> grades = new ArrayList<String>();
        
        
        Student(String stud_name , String stud_mail , String stud_phone , ArrayList<String> stud_grades ,  ArrayList<String> stud_sessions , int stud_id){
            
            super(stud_name,stud_phone,stud_mail);
            
            this.id = stud_id;
            this.grades = stud_grades;
            this.enrolledExamSessionsId = stud_sessions;
     
}
     }
