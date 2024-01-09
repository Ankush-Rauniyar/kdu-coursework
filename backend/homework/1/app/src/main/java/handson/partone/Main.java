package handson.partone;



import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        StudentRepository student_repository = new StudentRepository();
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Enter the entries :");
            int no_of_entries = sc.nextInt();

            for(int i = 0 ; i < no_of_entries ; i++){
                int id = sc.nextInt();
                sc.nextLine();
                String name = sc.nextLine();
                int age = sc.nextInt();
                char grade = sc.next().charAt(0);
                student_repository.addStudent(new Student(id,name,age,grade));
            }
        }else if(choice == 2){
            int retrieval_id = sc.nextInt();
            Student retreivedStudent = student_repository.retreiveStudent(retrieval_id);
        }else if(choice == 3){
            int update_old_id = sc.nextInt();
            int new_id = sc.nextInt();
            String new_name = sc.nextLine();
            int new_age = sc.nextInt();
            char new_grade = sc.next().charAt(0);

            student_repository.updateStudent(update_old_id,new Student(new_id,new_name,new_age,new_grade));

        }
    }
}