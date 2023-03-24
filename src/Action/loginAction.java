package Action;

import DataBase.DataBaseGet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import exercise.MysqlTool;
import user.Student;
import user.Teacher;
import user.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class loginAction implements Action {
    //由用户填写，前端获取后发给Action
    //传个User过来，判断能否登录，判断是学生还是老师
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /*private String username;   //用户名
    private String password;   //密码

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }*/

    //【用户登录】
    @Override
    public String execute() throws Exception {
        //将属性与Student数据库中的账号密码比对
        DataBaseGet db=new DataBaseGet();
        ArrayList<Student> students =db.GetStudents();
        ArrayList<Teacher> teachers =db.GetTeachers();
        int num=My_equal(students,teachers);
        switch (num){
            case 0:return NONE;                   //账号密码都错误
            case 1:return "StudentLogin";         //返回StudentLogin，学生通过struts.xml进入登录成功页面（即进入学生主页面）
            case 2:return "StudentPasswordWrong"; //学生登录失败，密码错误
            case 3:return "StudentUserNameWrong"; //学生登录失败，账号错误
            case 4:return "TeacherLogin";         //返回TeacherLogin，通过struts.xml进入登录成功页面（即进入教师主页面）
            case 5:return "TeacherPasswordWrong"; //教师登录失败，密码错误
            case 6:return "TeacherUserNameWrong"; //教师登录失败，账号错误
        }
        return "hello world!";
    }
    
    public int My_equal(ArrayList<Student> students,ArrayList<Teacher> teachers){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getUserName().equals(user.getUserName())&&students.get(i).getPassWord().equals(user.getPassWord())){
                return 1;//返回1，学生通过struts.xml进入登录成功页面（即进入学生主页面）
            }
            if(students.get(i).getUserName().equals(user.getUserName())&&!students.get(i).getPassWord().equals(user.getPassWord())){
                return 2;//返回2，学生登录失败，密码错误
            }
            if(!students.get(i).getUserName().equals(user.getUserName())&&students.get(i).getPassWord().equals(user.getPassWord())){
                return 3;//返回3，学生登录失败，账号错误
            }
            if(teachers.get(i).getUserName().equals(user.getUserName())&&teachers.get(i).getPassWord().equals(user.getPassWord())){
                return 4;//返回4，教师通过struts.xml进入登录成功页面（即进入教师主页面）
            }
            if(teachers.get(i).getUserName().equals(user.getUserName())&&!teachers.get(i).getPassWord().equals(user.getPassWord())){
                return 5;//返回5，教师登录失败，密码错误
            }
            if(!teachers.get(i).getUserName().equals(user.getUserName())&&teachers.get(i).getPassWord().equals(user.getPassWord())){
                return 6;//返回6，教师登录失败，账号错误
            }
        }
        return 0;//账号密码都未找到
    }

    public static void main(String[] args) {
        DataBaseGet db=new DataBaseGet();
        try {
            ArrayList<Student> students =db.GetStudents();
            System.out.println(students.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
