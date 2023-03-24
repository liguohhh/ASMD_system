package DataBase;

import exercise.*;
import user.School;
import user.Student;
import user.StudyClass;
import user.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;


public class DataBaseGet {
    private MysqlTool mysql=new MysqlTool();
    private Connection con;
    private PreparedStatement ps;

    //从school表中获取学校数组
    public ArrayList<School> GetSchools(){
        ArrayList<School> schools=new ArrayList<>();

        try {
            con= mysql.openDB();
            String sql="select * from school";
            ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                School school = new School();
                school.setSchoolId(rs.getInt("schoolid"));
                school.setSchoolName(rs.getString("schoolname"));
                schools.add(school);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return schools;
    }


    //从school表中获取班级数组
    public ArrayList<StudyClass> GetClasses(){
        ArrayList<StudyClass> Classes=new ArrayList<>();
        try {
            con= mysql.openDB();
            String sql="select * from class";
            ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                StudyClass studyclass = new StudyClass();
                studyclass.setClassId(rs.getInt("classid"));
                studyclass.setClassName(rs.getString("classname"));
                studyclass.setSchoolId(rs.getInt("schoolid"));
                Classes.add(studyclass);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return Classes;
    }

    //获取普通练习的题目，默认10道题，返回题目类型数组。
    //优化内容：【如果想要定向出题（如只有加，只有减，或者只有乘除），可以限定随机数的范围】，【可以修改方法让用户输入题目数】
    public ArrayList<BinaryOperation> GetQuestions(){
        ArrayList<BinaryOperation> questions=new ArrayList<>();
        //读取数据库，根据题目id，随机抽取10道题，并存入questions
        //随机可以使用Random类，进行id的随机，然后取出对应id的题目
            int i=0;
        try {
            con= mysql.openDB();
            String sql1="select * from question ";
            ps= con.prepareStatement(sql1);
            ResultSet rs1 = ps.executeQuery();
            while(rs1.next()){
                i++;
            }                           //遍历结果找id数得最大id=i
            rs1.close();
            ps.close();

            Random a=new Random();
//
//            ArrayList<Integer>ran=new ArrayList<>();//用来查重用的数组


            for(int c=1;c<=10;c++) {//随机抽取10道题for（10）

                int n0=a.nextInt(i+1);
//               for(int d=0;d<10;d++){//查重数组添加获取
//                   ran.add(n+100*d);
//
//               }
                n0=n0+100*c;
                int n=n0;//获取随机数n 伪随机

                String sql = "select * from question where questionid=?";

                ps = con.prepareStatement(sql);
                ps.setInt(1, n);//查询id=n的
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {//存入相应的题目进去questions数组 while（rs。next（））其实也只是一次执行没有循环

                    String fuhao = rs.getString("operator");
                    if (fuhao.equals("+")) {
                        AdditionOperation ADD = new AdditionOperation();
                        ADD.setLeft_operand(rs.getInt("factor1"));
                        ADD.setRight_operand(rs.getInt("factor2"));
                        ADD.setValue(rs.getInt("result"));
                        questions.add(ADD);

                    } else if (fuhao.equals("-")) {
                        SubstractOperation SUB = new SubstractOperation();
                        SUB.setLeft_operand(rs.getInt("factor1"));
                        SUB.setRight_operand(rs.getInt("factor2"));
                        SUB.setValue(rs.getInt("result"));
                        questions.add(SUB);


                    } else if (fuhao.equals("*")) {
                        MultiplyOperation MUL = new MultiplyOperation();
                        MUL.setLeft_operand(rs.getInt("factor1"));
                        MUL.setRight_operand(rs.getInt("factor2"));
                        MUL.setValue(rs.getInt("result"));
                        questions.add(MUL);
                    } else if (fuhao.equals("/")) {
                        DivisionOperation DIV = new DivisionOperation();
                        DIV.setLeft_operand(rs.getInt("factor1"));
                        DIV.setRight_operand(rs.getInt("factor2"));
                        DIV.setValue(rs.getInt("result"));
                        questions.add(DIV);
                    }


                }

            rs.close();
            }
            ps.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questions;
    }

    //获取错题，最多10道题，返回题目类型数组。
    public ArrayList<BinaryOperation> GetWrongQuestions_10(int studentId){
        ArrayList<BinaryOperation> wrongQuestions=new ArrayList<>();
        //读取数据库，获取错题集的前10道题，（如果不够10道就取完），并存入wrongQuestions


        /*待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成*/




        return wrongQuestions;
    }


    //获取错题，最多10道题，返回题目类型数组。
    public ArrayList<BinaryOperation> GetWrongQuestions(int studentId){
        ArrayList<BinaryOperation> wrongQuestions=new ArrayList<>();
        //读取数据库，获取错题集的前10道题，（如果不够10道就取完），并存入wrongQuestions


        /*待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成*/




        return wrongQuestions;
    }

    //返回所有学生信息数组
    public ArrayList<Student> GetStudents()throws Exception{
        ArrayList<Student> StudentMassage=new ArrayList<>();
        //读取数据库的所有学生信息，并存入StudentMassage
        con= mysql.openDB();
        String sql = "select * from student ";
        ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
          Student user=new Student();
            user.setUserID(rs.getInt("studentid"));
            user.setUserName(rs.getString("username"));
            user.setPassWord(rs.getString("password"));
            user.setStudentName(rs.getString("studentname"));
            user.setPhoneNumber(rs.getString("tel"));
            user.setAuthority(rs.getString("permissions"));
            StudentMassage.add(user);
        }

        rs.close();
        ps.close();
        con.close();

        return StudentMassage;
    }
    //返回所有老师信息数组
    public ArrayList<Teacher> GetTeachers()throws Exception{
        ArrayList<Teacher> TeacherMassage=new ArrayList<>();
        //读取数据库的所有学生信息，并存入StudentMassage
        con= mysql.openDB();
        String sql = "select * from student ";
        ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
          Teacher user=new Teacher();
            user.setUserID(rs.getInt("studentid"));
            user.setUserName(rs.getString("username"));
            user.setPassWord(rs.getString("password"));
            user.setTeacherName(rs.getString("studentname"));
            user.setPhoneNumber(rs.getString("tel"));
            user.setAuthority(rs.getString("permissions"));
            TeacherMassage.add(user);
        }

        rs.close();
        ps.close();
        con.close();

        return TeacherMassage;
    }

    public static void main(String[] args) {

        DataBaseGet a=new DataBaseGet();
//        a.GetSchools();
        /*a.GetClasses();

        try {
            ArrayList<StudyClass> cla=a.GetClasses();
            for (int i = 0; i < cla.size(); i++) {
                System.out.println(cla.get(i).getClassId());
                System.out.println(cla.get(i).getClassName());
                System.out.println(cla.get(i).getSchoolId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        try {
            ArrayList<Student> stu=a.GetStudents();
            System.out.print("学生人数：");
            System.out.println(stu.size());
            for (int i = 0; i < stu.size(); i++) {
                System.out.println(stu.get(i).getUserName());
                System.out.println(stu.get(i).getPassWord());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

