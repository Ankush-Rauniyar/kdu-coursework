package handson.partthree;

import org.slf4j.LoggerFactory;

public class StudentUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StudentUtil.class);
    private StudentUtil(){

    }
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws Exception{
        // Your code: throw IllegalArgumentException with the message that lengths of input arrays are out-of-sync
        if(studentIdList.length == studentsGrades.length) {
            String message = String.format("studentIdList & studentsGrades are out-of-sync. studentIdList.length: %d, studentsGrades.length: %d", studentIdList.length, studentsGrades.length);
            throw new IllegalArgumentException(message);
        }
        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws InvalidDataException{
        if (lower < 0 || higher < 0 || lower > higher) {
            return new int[]{};
        }
        double[] gpaList = new double[studentIdList.length];
        try {
            gpaList = calculateGPA(studentIdList, studentsGrades);
        }catch(MissingGradeException e){
            String message = String.format("Missing student Id is : %d",e.getStudentId());
            throw new InvalidDataException(message,e);
        }catch(IllegalArgumentException e){
            logger.info("InvalidArgumentException caught --");
        }catch (Exception e){
            logger.info("Exception caught --");
        }


        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}
