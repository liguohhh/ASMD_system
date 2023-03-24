package Action;

import DataBase.DataBaseGet;
import com.opensymphony.xwork2.ActionContext;
import exercise.BinaryOperation;
import java.util.ArrayList;
import com.opensymphony.xwork2.Action;



//当学生点击练习或查看试卷时，前端调用此类，获取题目数组，并显示给用户
public class GetQuestionAction implements Action {
    private ArrayList<BinaryOperation> questions;         //随机出题 的题目数组
    private ArrayList<BinaryOperation> wrongQuestions;    //错题    的题目数组
    private int studentId;           //用户id，通过id指定某一个错题集

    public ArrayList<BinaryOperation> getWrongQuestions() {
        return wrongQuestions;
    }
    public ArrayList<BinaryOperation> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<BinaryOperation> questions) {
        this.questions = questions;
    }
    public void setWrongQuestions(ArrayList<BinaryOperation> wrongQuestions) {
        this.wrongQuestions = wrongQuestions;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //【正常练习】获取普通练习的题目，默认10道题。《后续可增加方法让用户输入题目数》
    @Override
    public String execute() {
        //从数据库中随机抽10道题，存入questions
        DataBaseGet db=new DataBaseGet();
        questions=db.GetQuestions();

        ActionContext ac=ActionContext.getContext();
        //把習題保存到application中
        ac.getApplication().put("questions",getQuestions());
        //返回SUCCESS，题目返回成功
        return SUCCESS;
    }

    //【复习练习】获取某个用户的错题，数量<=10，错题如果超过十道，则只返回前十道题
    public String execute01() {
        //从数据库中随机抽10道题，存入questions
        DataBaseGet db=new DataBaseGet();
        wrongQuestions=db.GetWrongQuestions_10(studentId);
        ActionContext ac=ActionContext.getContext();
        //把習題保存到application中
        ac.getApplication().put("wrongQuestions",getWrongQuestions());
        //返回SUCCESS，题目返回成功
        return SUCCESS;
    }

    //【查看历史错题】获取某个用户的所有错题
    public String execute02() {
        //从数据库中随机抽10道题，存入questions
        DataBaseGet db=new DataBaseGet();
        wrongQuestions=db.GetWrongQuestions_10(studentId);
        ActionContext ac=ActionContext.getContext();
        //把習題保存到application中
        ac.getApplication().put("wrongQuestions",getWrongQuestions());
        //返回SUCCESS，题目返回成功
        return SUCCESS;
    }



}
