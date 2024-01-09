package handson.partone;

import java.util.ArrayList;

public class StudentRepository {

    LoggersDefined loggersDefined = new LoggersDefined();
    ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student current){

        loggersDefined.loggingStoringing("adding student");
        students.add(current);
        loggersDefined.loggingStoringing("student -- added");
    }

    public Student retreiveStudent(int id){
        loggersDefined.loggingStoringing("retrieving  student");
        int totalStudents = students.size();
        for(int i = 0 ; i < totalStudents ; i++){
            if(students.get(i).studentId == id){
                return students.get(i);
            }
        }
        loggersDefined.loggingStoringing("student -- retrieved");
        return null;
    }

    public void updateStudent(int id,Student newStudentDetails){
        loggersDefined.loggingStoringing("Updating student");
        int totalStudents = students.size();
        int current = -1;
        for(int i = 0 ; i < totalStudents ; i++){
            if(students.get(i).studentId == id){
                current = i;
                break;
            }
        }
        students.set(current,newStudentDetails);
        loggersDefined.loggingStoringing("student -- update");
    }
}
