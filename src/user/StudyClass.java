package user;

/*班级类中包含某个班级的所有学生信息
可以通过声明一个班级类型的变量进行学校信息的存储和增删改查*/
public class StudyClass {
    private int ClassId;                     //班级id
    private String ClassName;                //班级name
    private int SchoolId;                    //学校id

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }
}
