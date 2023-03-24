package user;

import java.util.ArrayList;

public class Teacher extends User {
    private String schoolId;  //班级
    private String classId;  //学校
    private String teacherName; //教师姓名
    //老师数据库中缺少用户名和密码！！！！！！！！！！！！！！！！！！！！


    public Teacher(int userID, String userName, String passWord, String phoneNumber,  String schoolId, String classId, String teacherName) {
        super(userID, userName, passWord, phoneNumber, "b");
        this.schoolId = schoolId;
        this.classId = classId;
        this.teacherName = teacherName;
    }

    public Teacher(String schoolId, String classId, String teacherName) {
        this.schoolId = schoolId;
        this.classId = classId;
        this.teacherName = teacherName;
    }

    public Teacher(){}

    //管理班级，进入该界面之后有三个选项，包括删除学生，修改学生信息，查询学生信息，教师需要再次选择
    void managementClass() {

    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    //出试卷，教师通过自己输入题目内容，整合出一张试卷存入数据库
    void publishPaper(ArrayList<Object> problems) {

    }
    //添加学生，输入学生信息，存入数据库。因为用的比较频繁，与管理学生的方法分离开
    void addStudent(Student stu) {

    }

}
