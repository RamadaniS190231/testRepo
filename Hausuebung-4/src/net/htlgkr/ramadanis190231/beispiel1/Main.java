package net.htlgkr.ramadanis190231.beispiel1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    static List<String> stringList = new ArrayList<>();
    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        readFile();
        removeStrings();

        System.out.println("Chunks:");
        int chunks = sc.nextInt();
        System.out.println("Divider:");
        int divider = sc.nextInt();

    }

    public static void readFile(){
        File file = new File("C:\\Schule\\Shuajb-HTL-3\\POS\\testRepo\\Hausuebung-4\\src\\net\\htlgkr\\ramadanis190231\\beispiel1\\numbers.csv");
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                lines++;
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
