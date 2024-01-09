package handson.partone;

import java.util.*;
public class Student {
    int studentId;
    String studentName;
    int studentAge;
    char studentGrade;

    public Student(int id,String name,int age,char grade){
        this.studentId = id;
        this.studentName = name;
        this.studentAge = age;
        this.studentGrade = grade;
    }

    public void setStudent(int id,String name,int age,char grade){
        this.studentId = id;
        this.studentName = name;
        this.studentAge = age;
        this.studentGrade = grade;
    }

    public int getStudentid(){
        return this.studentId;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public byte getStudentAge(){
        return (byte) this.studentAge;
    }

    public char getStudentGrade(){
        return this.studentGrade;
    }


}
