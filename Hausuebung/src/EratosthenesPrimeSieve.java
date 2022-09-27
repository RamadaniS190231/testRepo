public class EratosthenesPrimeSieve implements PrimeSieve{

    private int highestNumber;

    public EratosthenesPrimeSieve(int highestNumber)
    {
    this.highestNumber = highestNumber;
    }


    @Override
    public boolean isPrime(int p) {
        boolean[] crossed = new boolean[p];
        crossed[0] = false;

        for (int i = 1; i < p; i++){
            crossed[i] = true;
        }

        for (int i = 2; i <= p; i++){
            if (crossed[i-1] == true){
                if (i == p){
                    return true;
                }

                for (int j = 2*i; j <= p; j+= i){
                    crossed[j-1] = false;
                }
            }
        }
        return false;
    }

    @Override
    public void printPrimes() {

        for (int i = 1; i <= highestNumber; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
