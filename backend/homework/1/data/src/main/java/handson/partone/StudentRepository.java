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
        int total_students = students.size();
        for(int i = 0 ; i < total_students ; i++){
            if(students.get(i).student_id == id){
                return students.get(i);
            }
        }
        loggersDefined.loggingStoringing("student -- retrieved");
        return null;
    }

    public void updateStudent(int id,Student new_student_details){
        loggersDefined.loggingStoringing("Updating student");
        int total_students = students.size();
        int current = -1;
        for(int i = 0 ; i < total_students ; i++){
            if(students.get(i).student_id == id){
                current = i;
                break;
            }
        }
        students.set(current,new_student_details);
        loggersDefined.loggingStoringing("student -- update");
    }
}
