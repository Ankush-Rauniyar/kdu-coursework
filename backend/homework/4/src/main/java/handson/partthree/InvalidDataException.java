package handson.partthree;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message,Throwable missingGradeException){
        super(message,missingGradeException);
    }
}
