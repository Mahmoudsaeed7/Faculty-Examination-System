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
public class question {
    private int exID , questionNum;
    private String correctAns , question_num ,choose_1 ,choose_2 ,choose_3,choose_4;

    public question(int Id , String correct_ans ,String quest_num,String Choose_1,String Choose_2,String Choose_3,String Choose_4,int questNum){
        this.exID = Id;
        this.correctAns = correct_ans;
        this.question_num = quest_num;
        this.choose_1 = Choose_1;
        this.choose_2 = Choose_2;
        this.choose_3 = Choose_3;
        this.choose_4 = Choose_4;
        this.questionNum = questNum;
    }

    public int getExID() {
        return exID;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public String getQuestion_num() {
        return question_num;
    }

    public String getChoose_1() {
        return choose_1;
    }

    public String getChoose_2() {
        return choose_2;
    }

    public String getChoose_3() {
        return choose_3;
    }

    public String getChoose_4() {
        return choose_4;
    }
}
