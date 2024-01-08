package handson.partone;

import java.util.*;
public class Student {
    int student_id;
    String student_name;
    int student_age;
    char student_grade;

    public Student(int id,String name,int age,char grade){
        this.student_id = id;
        this.student_name = name;
        this.student_age = age;
        this.student_grade = grade;
    }

    public void setStudent(int id,String name,int age,char grade){
        this.student_id = id;
        this.student_name = name;
        this.student_age = age;
        this.student_grade = grade;
    }

    public int getStudentid(){
        return this.student_id;
    }

    public String getStudentName(){
        return this.student_name;
    }

    public byte getStudentAge(){
        return (byte) this.student_age;
    }

    public char getStudentGrade(){
        return this.student_grade;
    }


}
