import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Boom {
    private Puzzle puzzle;
    private Fuse fuse;
    private Fuse fuse1;
    private int count;
    private String[] words= new String[]{"work is good", "dance like me", "study is the key to success"};


    public int random(){
        Random random = new Random();
        int index = random.nextInt(words.length);
        //System.out.println(words[index]);
        return index;
    }
    public void cli(){
        System.out.println("Enter lower case letters to guess,");
        System.out.println("! to propose a solution");
        System.out.println("0 to exit");

        String name=words[random()];
        char[] splt=new char[name.length()];
        Scanner in = new Scanner(System.in);
        fuse1 = new Fuse(5);
        puzzle=new Puzzle(name);
        for (int i = 0; i < name.length(); i++) {
            char c = name.toLowerCase(Locale.ROOT).toCharArray()[i];
            if(c == ' '){
                splt[i] = ' ';
            }
            else if(c != ' '){
                splt[i] = '_';
            }

        }
        System.out.println("\n"+fuse1);
        System.out.println(splt);
        while(true){

            String guess;
            System.out.println("Guess a letter: ");
            guess=in.nextLine();

            if(guess.charAt(0) == '!'){

                String phrase;
                System.out.println("What is the Phrase? ");
                phrase=in.nextLine();
                boolean check=puzzle.solve(phrase);


                    if (check == true) {
                        System.out.println("*** W I N N E R ***");
                        System.out.println("The secrete phrase was " + puzzle.getSolution());
                        System.exit(0);
                    } else if (check == false) {
                        System.out.println("You are wrong. Game over");
                        fuse = new Fuse(0);
                        fuse.burn();
                        System.out.println(fuse);
                        System.exit(0);
                    }


            }


            else if(guess.charAt(0) != ' '){
                char c=guess.charAt(0);
               boolean ans= puzzle.guess(c);
               if(ans == true) {
                   ++count;
                   System.out.println(puzzle);
                   boolean win=puzzle.isWin();
                   if(win == true){
                       System.out.println("You win");
                       System.exit(0);
                   }
               }
                else if(ans == false) {
                    boolean a=fuse1.burn();
                    System.out.println(fuse1);
                    if(a == false){
                        System.exit(0);
                    }
                }
            }
            else if(guess.charAt(0) == ' '){
                boolean a=fuse1.burn();
                System.out.println(fuse1);
                if(a == false){
                    System.exit(0);
                }
            }
            else if(Integer.parseInt(guess) == 0){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args){
        Boom controller = new Boom();
        controller.cli();
    }
}

