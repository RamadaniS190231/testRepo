public class EratosthenesPrimeSieve implements PrimeSieve{

    private int highestNumber;

    public EratosthenesPrimeSieve(int highestNumber)
    {
    this.highestNumber = highestNumber;
    }


    @Override
    public boolean isPrime(int p) {


        return false;
    }

    @Override
    public void printPrimes() {

        boolean[] crossed = new boolean[this.highestNumber];
        crossed[0] = false;

        for (int i = 1; i < this.highestNumber; i++){
            crossed[i] = true;
        }

        for (int i = 2; i <= this.highestNumber; i++){
            if (crossed[i-1] == true){
                System.out.println(i);

                for (int j = 2*i; j <= this.highestNumber; j+= i){
                    crossed[j-1] = false;
                }
            }
        }
    }
}
