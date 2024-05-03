import java.text.NumberFormat;
import java.util.ArrayList;

public class Primes2 {

    private int numThreads;
    private ArrayList<Integer> primes;

    public Primes2(int numThreads){
        this.numThreads=numThreads;
        primes=new ArrayList<>();

    }

    public Primes2 findPrimes(int lower, int upper){

        //int n=0;
        int range =upper/numThreads;
        int[] newUppers = new int[numThreads];
        newUppers[0]=range;
        int[] newLowers = new int[numThreads];
        newLowers[0]=lower;

        for(int l=1;l<numThreads;l++){
            newLowers[l]=newUppers[l-1]+1;
            newUppers[l]=newUppers[l-1]+range;
        }

        for(int i=0;i<numThreads;i++){
            addPrimes(newLowers[i],newUppers[i]);

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


    protected void addPrimes(int lower, int upper){
        for(int i=lower;i<=upper;i++) {
            if (isPrime(i) == true) {
                primes.add(i);
            }
        }
    }
}

