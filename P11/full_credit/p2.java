import java.text.NumberFormat;

public class p2 extends Thread {

	private static int numThreads ;
        private static int lower ;
        private static int upper ;
    @Override
    public void run() {
       
        

        Primes2 primes = new Primes2(numThreads); // Search using one thread
        int sumOfPrimes = 0;
        for(int prime : primes.findPrimes(lower, upper).toArray())
            sumOfPrimes += prime;
        System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between "
                + lower + " and "
                + upper + " is "
                + NumberFormat.getIntegerInstance().format(sumOfPrimes));
    }

    public static void main(String[] args) {
    if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }
      
        //int numThreads = 1;
        if(numThreads == 1){
        	p2 p=new p2();
        	for(int i=0; i<numThreads; ++i) p.run();
        }
        else{
        try {
        Thread[] threads=new Thread[numThreads];
        for(int i=0;i<numThreads;i++){
            threads[i]=new Thread(new p2());
            threads[i].start();
        }
        for(int i=0;i<numThreads;i++){
            
                threads[i].join();}
            } catch (InterruptedException e) {
                System.err.println("Abort: " + e);
            
            }
        }
        
    }
}

