package net.htlgkr.ramadanis190231.beispiel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Bis wo sollen die Zahlen summiert werden?");
        List<Task> taskList = new ArrayList<>();
        int sum = 0; //Summe der Zahlen
        int tasks = 0;

        int inputNumber = scanner.nextInt(); //Zahl bis wo man summieren soll
        if(inputNumber > 100) {
            tasks = inputNumber / 100; // Wie viele Tasks gebraucht werden wenn die Zahl durch 100 teilbar ist
        }
        int halfTask = inputNumber%100; //Wie viele Tasks zusätzlich gebraucht werden wenn die zahl nicht durch 100 teilbar ist

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        int lowest = 1; // von wo
        int highest = 100; // bis wo gerechnet werden soll
        for (int i = tasks; i > 0; i--){ //Es werden die Tasks erstellt
            Task t = new Task(lowest, highest);
            lowest = lowest + 100;
            highest = highest + 100;
            taskList.add(t);
        }

        Task t2 = new Task(inputNumber - (halfTask-1), inputNumber); //Task wird erstellt wenn zahl nicht durch
        taskList.add(t2);                                                  //100 teilbar ist

        for (Task task : taskList) { //Runable ausgeführt und berechnet
            executor.execute(task);
        }
        executor.shutdown();
        for (Task task : taskList) { //Die summen aus den einzelnen Tasks werden addiert
            sum = sum + task.getSum();
        }

        System.out.println(sum);

        int gausResult = inputNumber * (inputNumber + 1) / 2;
        System.out.println("Ergebnis wenn man es mit der Gaussschen-Summenformel rechnet: " + gausResult);
    }

}

