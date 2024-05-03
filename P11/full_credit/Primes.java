import java.text.NumberFormat;
import java.util.ArrayList;

public class Primes {

    private int numThreads;
    private ArrayList<Integer> primes;

    public Primes(int numThreads){
        this.numThreads=numThreads;
        primes=new ArrayList<>();

    }

    public Primes findPrimes(int lower, int upper){
        for(int i=lower;i<=upper;i++){
            if(isPrime(i) == true){
                primes.add(i);
            }
        }
        return this;
    }

    protected boolean isPrime(int number){
        boolean check=true;
        for(int i=2;i<=number/2;i++){
            if(number%i == 0){
                check=false;
                break;
            }
        }
        return check;
    }

    public int numberOfPrimes() {
        return primes.size();
    }
    public Integer[] toArray() {
        Integer [] nums=new Integer[primes.size()];
        for(int i=0;i<primes.size();i++){
            nums[i]=primes.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int numThreads = 1;
        int lower = 0;
        int upper = 10000000; // defaults
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }

        Primes primes = new Primes(numThreads); // Search using one thread
        int sumOfPrimes = 0;
        for(int prime : primes.findPrimes(lower, upper).toArray())
            sumOfPrimes += prime;
        System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between "
                + lower + " and "
                + upper + " is "
                + NumberFormat.getIntegerInstance().format(sumOfPrimes));
    }
}

