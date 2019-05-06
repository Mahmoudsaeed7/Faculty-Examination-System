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
public class Student {

    private int Id,sessions,gardes;
    private String name , phone , mail;
    
    public Student(int ID , String Name , String Mail , String Phone , int Sessions , int Grades){
        this.Id = ID;
        this.name = Name;
        this.mail = Mail;
        this.phone = Phone;
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
