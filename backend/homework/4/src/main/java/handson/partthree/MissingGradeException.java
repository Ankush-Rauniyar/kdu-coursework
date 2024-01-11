package handson.partthree;

public class MissingGradeException extends Exception{
    private final int studentId;
    public MissingGradeException(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return this.studentId;
    }
}
