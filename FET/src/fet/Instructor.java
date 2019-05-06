/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;
import java.util.ArrayList;

/**
 *
 * @author MAHMOUD SAEED
 */
public class Instructor extends User {
    public int id,age;
    int coursesCodes;
   public String name,mail,phone;
    
    public Instructor(int ID , String Name , String Mail , String Phone , int Age , int Courses){
        super(Name , Phone , Mail );
        this.id = ID;
        this.age = Age;
        this.coursesCodes = Courses;
    }
    
}
