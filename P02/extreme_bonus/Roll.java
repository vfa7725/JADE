public class Roll{

	public static void main(String[] args){
	if(args.length > 2 || args.length < 2){
		System.exit(0);
	}
	int num=Integer.parseInt(args[0]);
	int num1=Integer.parseInt(args[1]);
	
	
	
	Die n=new Die(num1);
	
	n.setDicenum(num);
	n.roll();
	//return 0;
	}
}
