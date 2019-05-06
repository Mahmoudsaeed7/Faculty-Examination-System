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
<<<<<<< HEAD
public class Instructor {
    private int id,age,courses;
    private String name,mail,phone;
    
    public Instructor(int ID , String Name , String Mail , String Phone , int Age , int Courses){
=======
public class Instructor extends User {
    public int id,age;
    ArrayList<String> coursesCodes;
   public String name,mail,phone;
    
    public Instructor(int ID , String Name , String Mail , String Phone , int Age , ArrayList<String> Courses){
        super(Name , Phone , Mail );
>>>>>>> parent of 32787f9... ......
        this.id = ID;
        this.name = Name;
        this.mail = Mail;
        this.phone = Phone;
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
