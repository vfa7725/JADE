
import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
    ArrayList Students=new ArrayList();
    ArrayList Grades =new ArrayList();
    ArrayList<Student> S1=new ArrayList<Student>();
    public static void showMainMenu() {
        System.out.println("1. Add New Students");
        System.out.println("2. Add Exam Grades");
        System.out.println("3. List All Students and their Averages");
        System.out.println("4. Exit");

    }
    public void run() {
        Scanner in = new Scanner(System.in);

        while (true) {
            showMainMenu();
            System.out.print("> ");
            
            String input = in.nextLine().toString();

               
                switch (input) {
                    case "1":
                        String name = " ";

                        int i = 0;
                        while (!(name.equals(""))) {


                            System.out.println("Enter student's name(Press Enter with no inputs when done): ");
                            name = in.nextLine();

                            Student s2 = new Student(name);
                            S1.add(i, new Student(name));
                            Students.add(S1.get(i).getStudentName());
                            i++;

                        }
                        break;
                    case "2":

                        for (int j = 0; j < ((Students.size()) - 1); j++) {
                           
                            double grade;
                           


                            System.out.println(Students.get(j) + "'s grade: ");
                            grade = in.nextDouble();
                            S1.get(j).addExam(grade);

                            S1.get(j).average();
                          

                        }
                        break;
                    case "3":
                        for (int l = 0; l < (Students.size() - 1); l++) {

                            
                            S1.get(l).average();
                            System.out.println(S1.get(l));
                           
                        }
                        System.out.println();

                        break;
                    case "4":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
                //  }
            }
          
        }
        

    public static void main(String[] args) {
        Grades controller = new Grades();
        controller.run();
    }
}

