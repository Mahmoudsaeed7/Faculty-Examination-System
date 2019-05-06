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
public class Question {
     ArrayList<String> choices;
     char correctChoice;
     int grade;
     int evaluationRank;

    public Question(ArrayList<String> choices, char correctChoice, int grade, int evaluationRank) {
        this.choices = choices;
        this.correctChoice = correctChoice;
        this.grade = grade;
        this.evaluationRank = evaluationRank;
    }
     
     
    
}
