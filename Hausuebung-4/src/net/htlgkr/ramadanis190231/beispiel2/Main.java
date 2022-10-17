package net.htlgkr.ramadanis190231.beispiel2;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Bis wo sollen die Zahlen summiert werden?");

        int inputNumber = scanner.nextInt();
        int tasks = inputNumber/100;
        int halfTask = inputNumber%100;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        int lowest = 1;
        int highest = 100;
        for (int i = tasks; i > 0; i--){
            Task t = new Task(lowest, highest);
            lowest = lowest + 100;
            highest = highest + 100;
            executor.execute(t);
        }
        Task t2 = new Task(inputNumber-halfTask, inputNumber);
        executor.execute(t2);

        executor.shutdown();

        System.out.println(sum);
    }

}

