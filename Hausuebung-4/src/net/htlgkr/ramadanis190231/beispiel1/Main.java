package net.htlgkr.ramadanis190231.beispiel1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    static List<String> stringList = new ArrayList<>();
    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        readFile();
        removeStrings();

        System.out.println("Chunks:");
        int chunks = sc.nextInt();
        System.out.println("Divider:");
        int divider = sc.nextInt();
        int tasks = integerList.size()/chunks;
        int from = 0;
        int to = tasks-1;
        for (int i = chunks; i > 0; i--) {

            List<Integer> taskList;
            taskList = integerList.subList(from, to);
            from =  from + tasks;
            to = to + tasks;
            Task t = new Task(taskList, divider);
            System.out.println("Task created");
            executor.execute(t);
        }

        executor.shutdown();

    }

    public static void readFile(){
        File file = new File("C:\\Schule\\Shuajb-HTL-3\\POS\\testRepo\\Hausuebung-4\\src\\net\\htlgkr\\ramadanis190231\\beispiel1\\numbers.csv");
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] splitted = line.split(":");
                for (int i = 0; i < splitted.length; i++){
                    stringList.add(splitted[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeStrings(){

        for (int i = 0; i < stringList.size(); i++){

            try {
                integerList.add(Integer.parseInt(stringList.get(i)));

            }catch (Exception e){
               //String wurde nicht geadded
            }
        }
    }


}
