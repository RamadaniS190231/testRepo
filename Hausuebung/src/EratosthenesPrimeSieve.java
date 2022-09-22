public class EratosthenesPrimeSieve {

    private int highestNumber;

    public EratosthenesPrimeSieve(int highestNumber) {
    this.highestNumber = highestNumber;
    }

    public interface PrimeSieve{
        public boolean isPrime(int p);

        public void printPrimes();
    }
}
