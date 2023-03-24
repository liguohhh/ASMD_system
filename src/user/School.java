package user;

import java.util.ArrayList;
/*学校类中包含某个学校的所有班级信息
可以通过声明一个学校类型的变量进行学校信息的存储和增删改查*/
public class School {
    private int SchoolId;                //学校id
    private String SchoolName;              //学校名称

    //getter和setter
    public int getSchoolId() {
        return SchoolId;
    }
    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }
    public String getSchoolName() {
        return SchoolName;
    }
    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}
