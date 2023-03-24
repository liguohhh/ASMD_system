package user;

import java.util.ArrayList;

public class Student extends User {
    private String studentName;            //学生姓名
    private int schoolId;                  //学校id
    private int classId;                   //班级id



    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Student(){
        super();
    }
    public Student(int userID, String userName, String passWord, String phoneNumber, String studentName, int schoolId, int classId) {
        super(userID, userName, passWord, phoneNumber, "c");
        this.studentName = studentName;
        this.schoolId = schoolId;
        this.classId = classId;
    }

    //做作业，通过查询数据库，看老师是否布置作业，如果布置了，学生选择试卷并返回题目类型数组，如果没有，弹出窗口提示没有作业
    public ArrayList<Object> doHomework() {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }

}
