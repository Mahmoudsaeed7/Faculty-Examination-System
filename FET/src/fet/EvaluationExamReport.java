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
public class EvaluationExamReport {
    String examCode;
    Histogram gradesDistribution;
    ArrayList<Question> toughQuestions;

    public EvaluationExamReport(String examCode, Histogram gradesDistribution, ArrayList<Question> toughQuestions) {
        this.examCode = examCode;
        this.gradesDistribution = gradesDistribution;
        this.toughQuestions = toughQuestions;
    }
    
    
    
}
