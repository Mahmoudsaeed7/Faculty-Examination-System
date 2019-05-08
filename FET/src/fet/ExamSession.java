/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fet;

import java.util.*;

/**
 *
 * @author MAHMOUD SAEED
 */
public class ExamSession {
    private int sessionID , examID;
    private String acceptance;
    private ArrayList<String> studentsNames;

    public ExamSession(int sessionId,int exID , String Acceptance){
        this.sessionID = sessionId;
        this.examID = exID;
        this.acceptance = Acceptance;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setStudentsNames(ArrayList<String> studentsNames) {
        this.studentsNames = studentsNames;
    }

    public int getSessionID() {
        return sessionID;
    }

    public int getExamID() {
        return examID;
    }

    public ArrayList<String> getStudentsNames() {
        return studentsNames;
    }
}
