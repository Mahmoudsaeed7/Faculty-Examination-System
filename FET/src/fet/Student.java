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
public class Student extends Person{
    private int Id,sessions,gardes;
    
    public Student(String Name){
        super(Name);
    }
    
    public Student(int id , String Name , String Mail){
        super(Name,Mail);
        this.Id = id;
    }
    public Student(int ID , String Name , String Mail , String Phone , int Sessions , int Grades){
        super(Name,Mail,Phone);
        this.Id = ID;
        this.sessions = Sessions;
        this.gardes = Grades;
    }
    
    public int getId() {
        return Id;
    }

    public int getSessions() {
        return sessions;
    }

    public int getGardes() {
        return gardes;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }
}
