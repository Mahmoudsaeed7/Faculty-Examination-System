/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;

/**
 *
 * @author MAHMOUD SAEED
 */
public class Instructor extends Person {
    private int id,age,courses;
    
    public Instructor(int Id , String Name , String Mail){
        super(Name , Mail);
        this.id = Id;
        this.name = Name;
        this.mail = Mail;
    }
    
    public Instructor(int ID , String Name , String Mail , String Phone , int Age , int Courses){
        super(Name,Mail,Phone);
        this.id = ID;
        this.age = Age;
        this.courses = Courses;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
    
}
