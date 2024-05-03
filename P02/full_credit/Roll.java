import java.util.Random;
import java.util.Arrays;

public class Roll{
	public static void main(String[] args){
	Random r=new Random();
	int num=Integer.parseInt(args[0]);
	int num1=Integer.parseInt(args[1]);
	int[] rolls =new int[num];
	Arrays.sort(rolls);
	int add=0;
	int sum;
	
	if(args.length > 2 || args.length < 2){
		System.exit(0);
	}
	

       else{
      
       	for(int i=0;i<num;i++){
       		
       		rolls[i]=(r.nextInt(((num1-1)+1)))+1;
       		sum=add+(rolls[i]);
       		add=sum;
       		if(i == (num-1)){
       			Arrays.sort(rolls);
       			for(int j=0;j<num;j++){
       				System.out.print(rolls[j]+" ");
       			}
       			float Sum=sum;
       			float avg=Sum/num;
       			System.out.println("\nSum= "+Sum);
       			System.out.println("Average= "+avg);
       		}
       		
       	}	
       	
       	
       	
       	
       }
       
	}
}
