package handson.parttwo;

import QuestionTwo.SentimentAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int numberOfData = studentsGrades.length;
        double[] gpaCalculated = new double[numberOfData];

        for(int i = 0 ; i < numberOfData ; i++){
            double total = 0;
            int numberOfSubjects = studentsGrades[i].length;
            for(int j = 0 ; j < numberOfSubjects; j++){
                if(studentsGrades[i][j] == 'A'){
                    total += 4;
                }else if(studentsGrades[i][j] == 'B'){
                    total += 3;
                }else if(studentsGrades[i][j] == 'C'){
                    total += 2;
                }
                double avg = total/ numberOfSubjects;
                gpaCalculated[i] = avg;
            }
        }

        return gpaCalculated;
    }

    public static int[] getStudentsByGPA(double lower,double higher,int[] studentIdList, char[][] studentsGrades){
        if(lower < 0 || higher < 0 || (lower > higher)) {
            return null;
        }
        double[] calculatedGPA = calculateGPA(studentIdList,studentsGrades);

        int numberOfStudents = studentsGrades.length;

        int counter = 0;
        for(int i = 0 ; i < numberOfStudents ; i++) {
            if(calculatedGPA[i] >= lower && calculatedGPA[i] <= higher){
                counter++;
            }
        }
        int[] result = new int[counter];
        counter = 0;

        for(int i = 0 ; i < numberOfStudents ; i++) {
            if(calculatedGPA[i] >= lower && calculatedGPA[i] <= higher){
                result[counter] =  studentIdList[i];
                counter++;
            }
        }
        return result;
    }

    private static final Logger logger = (Logger) LoggerFactory.getLogger(SentimentAnalyzer.class);

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        logger.info("Enter lower bound :");
        double lower = sc.nextDouble();
        logger.info("Enter higher bound :");
        double upper =sc.nextDouble();
        logger.info("enter the number of students");
        int n = sc.nextInt();

        int[] studentIdList = new int[n];

        char[][] studentsGrades = new char[n][];
        for(int i = 0 ; i < n ; i++){
            studentIdList[i] = sc.nextInt();
            int subjects = sc.nextInt();
            char[] grades = new char[subjects];
            for(int j = 0 ; j < subjects ; j++){
                grades[j] = sc.next().charAt(0);
            }
            studentsGrades[i] = grades;
        }

        int[] output = getStudentsByGPA(lower,upper,studentIdList,studentsGrades);
        logger.info("final student id list of valid GPA found");
        //System.out.println(Arrays.toString(output));
    }
}
