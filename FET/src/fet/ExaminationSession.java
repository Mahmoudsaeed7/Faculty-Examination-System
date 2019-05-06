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
public class ExaminationSession {
    String id;
    public ArrayList<Student> students;
    Exam exam;

    public ExaminationSession(String id, Exam exam, ArrayList<Student> students) {
        this.id = id;
        this.exam = exam;
        this.students = students;
    }
    
    
}
