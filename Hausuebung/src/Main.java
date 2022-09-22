import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bis wo wollen Sie die Primzahlen ausrechen");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int highestNumber = sc.nextInt();
        int[] crossed = new int[highestNumber];
        
        EratosthenesPrimeSieve eps = new EratosthenesPrimeSieve(highestNumber);


        for(int i = 2; i == highestNumber; i++){

        }
    }
}