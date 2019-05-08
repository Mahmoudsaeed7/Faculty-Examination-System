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
    String pass;
    Person(String Name){
        this.name = Name;
    }
    Person(String Name , String Mail){
        this.name = Name;
        this.mail = Mail;
    }
    Person(String Name , String Mail , String Phone){
        this.name = Name;
        this.mail = Mail;
        this.phone = Phone;
    }
}
