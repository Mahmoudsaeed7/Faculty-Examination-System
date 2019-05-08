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
public class Exam {
    private int examID , duration , grades;
    private String examName , courseName , date;
    
    Exam(int id , String exName , int exDuration , String exDate , String cName , int Grades){
        this.examID = id;
        this.examName = exName;
        this.duration = exDuration;
        this.date = exDate;
        this.courseName = cName;
        this.grades = Grades;
    }

    public int getGrades() {
        return grades;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    
    public int getExamID() {
        return examID;
    }

    public String getExamName() {
        return examName;
    }

    

    public String getCourseName() {
        return courseName;
    }
}
