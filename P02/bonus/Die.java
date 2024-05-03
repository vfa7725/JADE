import java.util.Random;
import java.util.Arrays;

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
	
	
	

      
      
       	for(int i=0;i<num;i++){
       		
       		rolls[i]=(r.nextInt(((Faces-1)+1)))+1;
       		sum=add+(rolls[i]);
       		add=sum;
       		System.out.print(rolls[i]+" ");
       		if(i == (num-1)){
       			float Sum=sum;
       			float avg=Sum/num;
       			System.out.println("\nSum= "+Sum);
       			System.out.println("Average= "+avg);
       		}
       		
       	}	
       	
       	
       	
       	
       
       return 0;
	}
}
