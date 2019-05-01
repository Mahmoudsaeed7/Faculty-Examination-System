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
public class stud_requests {
        private int id;
        private String name,mail;
        
        public stud_requests(int ID , String Name , String Mail){
            
            this.id = ID;
            this.name = Name;
            this.mail = Mail;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getMail() {
            return mail;
        }
}
