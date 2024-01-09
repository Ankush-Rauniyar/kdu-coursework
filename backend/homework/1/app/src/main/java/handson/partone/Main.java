package handson.partone;



import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        StudentRepository studentRepository = new StudentRepository();
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Enter the entries :");
            int noOfEntries = sc.nextInt();


            for(int i = 0 ; i < noOfEntries ; i++){
                int id = sc.nextInt();
                sc.nextLine();
                String name = sc.nextLine();
                int age = sc.nextInt();
                char grade = sc.next().charAt(0);
                studentRepository.addStudent(new Student(id,name,age,grade));
            }
        }else if(choice == 2){
            int retrievalId = sc.nextInt();
            studentRepository.retreiveStudent(retrievalId);

        }else if(choice == 3){
            int updateOldId = sc.nextInt();
            int newId = sc.nextInt();
            String newName = sc.nextLine();
            int newAge = sc.nextInt();
            char newGrade = sc.next().charAt(0);

            studentRepository.updateStudent(updateOldId,new Student(newId,newName,newAge,newGrade));

        }
    }
}