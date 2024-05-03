public class Student {
    private String studentName;
    private double examSum;
    private double examNumGrades;
    private double avg;

    public Student(String name){
        this.studentName=name;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addExam(double grade){
        examSum=examSum+grade;
        examNumGrades++;
    }

    public double average(){

        if(examSum == 0) {
            avg=100;
        }
        else{
            avg=examSum/examNumGrades;
        }
        return avg;
    }

    @Override
    public String toString() {
        return studentName+" has a "+avg+" average.";
    }
}

