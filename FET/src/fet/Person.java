/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import fet.JDBC;
/**
 *
 * @author MAHMOUD SAEED
 */
abstract class Person {
    String name;
    String mail;
    String phone;
    
    Person(){};
    Person(String Name , String Mail , String Phone){
        this.name = Name;
        this.mail = Mail;
        this.phone = Phone;
    };
    
    class students extends Person{
        int id;
        int grades;
        String sessions;
        
        students(String stud_name , String stud_mail , String stud_phone , int stud_grades , String stud_sessions , int stud_id){
            
            super(stud_name,stud_mail,stud_phone);
            
            this.id = stud_id;
            this.grades = stud_grades;
            this.sessions = stud_sessions;
        }
    }
    
    class instructors extends Person{
        int id;
        int age;
        int courses;
        
        instructors(String inst_name , String inst_mail , String inst_phone , int inst_age , int inst_courses , int inst_id){
            
            super(inst_name,inst_mail,inst_phone);
            
            this.id = inst_id;
            this.age = inst_age;
            this.courses = inst_courses;
        }
    }
}
