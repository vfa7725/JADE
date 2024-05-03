import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Die{

        private int Faces;
        private int dicenum;
        
        public Die(int faces){
            Faces=faces;
        }
        
        
        public int getFaces() {
            return Faces;
        }
        
        public int getDicenum() {
            return dicenum;
        }
        
        public void setDicenum(int dicenum) {
            this.dicenum = dicenum;
        }
        
	public int roll(){
	Random r=new Random();
	int num=dicenum;
	int[] rolls =new int[num];
	Arrays.sort(rolls);
	int add=0;
	int sum;
	
	int count =1;
	

      
      
       	for(int i=0;i<num;i++){
       		
       		rolls[i]=(r.nextInt(((Faces-1)+1)))+1;
       		sum=add+(rolls[i]);
       		add=sum;
       		//System.out.print(rolls[i]+" ");
       		if(i == (num-1)){
       			Scanner in =new Scanner(System.in);
       			int guess;
       			float Sum=sum;
       			float avg=Sum/num;
       			System.out.println("\nGuess the Sum of the generated numbers(The numbers will be shown after guessing correctly): ");
       			guess = in.nextInt();
       			while(guess != Sum){
       				
       			       
       			        if(guess > Sum){
       			        	System.out.println("Lower");
       			        	count++;
       			        	System.out.println("Guess the Sum: ");
       			     		guess=in.nextInt();
       			     		
       			        	//System.out.println("\nSum= "+Sum);
       			        }
       			        else{
       			        	System.out.println("Higher");
       			        	count++;
       			        	System.out.println("Guess the Sum: ");
       			        	guess=in.nextInt();
       			        	
       			        	//System.out.println("\nSum= "+Sum);
       			        }
       			}
       			if(guess == Sum){
       			        	System.out.println("Exacto");
       			        	for(int j=0;j<num;j++){
       			        		System.out.print(rolls[j]+" ");
       			        		
       			        	}
       			        	System.out.println("\nScore: "+count);
       			        	//System.out.println("\nSum= "+Sum);
       			        }
       			
       			//System.out.println("Average= "+avg);
       		}
       		
       	}	
       	
       	
       	
       	
       
       return 0;
	}
}
