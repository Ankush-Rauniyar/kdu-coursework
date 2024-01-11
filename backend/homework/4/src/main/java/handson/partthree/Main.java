package handson.partthree;

import org.slf4j.LoggerFactory;

import static handson.partthree.StudentUtil.calculateGPA;

public class Main {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    public  static void main (String[] args) {

        try {
            int[] studentIdList1 = {1001, 1002};
            char[][] studentsGrades1 = {{'A', 'A', 'A', 'B'}};
            calculateGPA(studentIdList1, studentsGrades1);
        } catch (IllegalArgumentException | MissingGradeException | InvalidDataException exception) {
            logger.info("IllegalArgumentException caught: {}",exception.getMessage());
        }catch (Exception e){
            logger.info("Exception caught --");
        }
        try {
            int[] studentIdList1 = {1001};
            char[][] studentsGrades2 = {{'A', ' ', 'B'}};
            calculateGPA(studentIdList1, studentsGrades2);
        } catch (MissingGradeException exception) {
            String formattedMessage = String.format("Missing grade for student: %d", exception.getStudentId());
            throw new InvalidDataException(formattedMessage, exception);
        }catch (Exception e){
        logger.info("Exception caught --");
    }
    }
}
