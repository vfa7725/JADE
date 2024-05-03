import java.util.Arrays;
import java.util.Locale;

public class Puzzle {
    private String solution="";
    private boolean[] guesses;
    private char[] dashes;
    private char[] letters;
    private int stop=0;
    private boolean win;
    private int spacecounter;


    private int num =0;


    public Puzzle(String solution){
        this.solution=solution;
        guesses=new boolean[solution.length()];
        dashes=new char[solution.length()];
        letters=solution.toLowerCase().toCharArray();
        //System.out.println(letters[5]);
        for(int m=0;m<solution.length();m++){
            if(letters[m] == ' '){
                spacecounter++;
            }
        }

        if(stop == 0) {

            for (int i = 0; i < solution.length(); i++) {
                if(letters[i] == ' '){
                    dashes[i]=' ';
                }
                else if(letters[i] != ' '){
                    dashes[i] = '_';
                }

            }
        }
        stop++;

    }

    public boolean isWin() {
        return win;
    }

    public boolean guess(char c){
        int n=0;
        int q=0;
        int count = 0;
        if(num ==  0){
            num++;
            for(int j=0;j<solution.length();j++){
                guesses[j]=false;
            }
        }
        boolean choice=false;
        char[] letters=solution.toLowerCase().toCharArray();
       // System.out.println(letters[0]);
        for(int i=0;i<solution.length();i++){

            if(letters[i] == c && guesses[i] == false){
                guesses[i]=true;
                count++;
                choice= true;
                if(q ==0) {
                    q++;
                    System.out.println(letters[i] + " is in the phrase!");
                }
            }

            else if(letters[i] == c && guesses[i] == true){
                count--;
                choice= false;
            }
            else if(letters[i] != c){
                choice= false;
                if(n == 0) {
                    n++;
                    System.out.println("No " + c + " is incorrect");
                }
            }
        }

        if(count > 0){
            choice=true;
        }
        else if(count < 0){
            choice=false;
        }
       // System.out.println(guesses[2]);
      //  System.out.println(dashes);

        return choice;
    }

    public boolean solve(String proposedSolution){
        boolean check=false;
        char[] splt=proposedSolution.toLowerCase().toCharArray();
        char[] split=solution.toLowerCase().toCharArray();
        for(int i=0;i<solution.length();i++){
            if(splt[i] == split[i]){
                check= true;
            }
            else{
                check= false;
            }
        }
        return check;
    }

    public String getSolution() {
        return solution;
    }

    @Override
    public String toString() {


        String nr=" ";
        int wincount = 0;
        for(int l=0;l<solution.length();l++){
            if(guesses[l] == true){
                ++wincount;
                if(wincount == (letters.length - spacecounter)){
                    win=true;
                }
                else{
                    win=false;
                }
            }
        }



       for(int i=0;i<solution.length();i++){
            if(guesses[i] == true){
                dashes[i]=letters[i];

            }
       }
        System.out.println(dashes);


        return nr;
    }
}

