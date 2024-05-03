import java.util.Scanner;

public class Grades {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter student's name: ");
        String name=in.nextLine();

        Student S1=new Student(name);
        double num=0;
        while(num >= 0) {
            System.out.println("Enter next grade (< 0 when done): ");
            num = in.nextInt();
            if(num > 0) {
                S1.addExam(num);
            }
        }
        S1.average();
        System.out.println(S1);
    }
}

