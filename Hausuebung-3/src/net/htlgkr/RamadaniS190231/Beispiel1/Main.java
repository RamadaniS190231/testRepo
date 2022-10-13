package net.htlgkr.RamadaniS190231.Beispiel1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Weapon> unsortedWList= new ArrayList<>();
        unsortedWList = readFile();
        ArrayList<Weapon> sortedList = sortDamage(unsortedWList);
        Printable printableNormal = (weapons) -> weapons.stream().forEach(System.out::println);
        printableNormal.print(sortedList);

        System.out.println();System.out.println();System.out.println();System.out.println();

        Printable printT = (weapons) -> {
            System.out.println("Name           +  CombatType  +  DamageType  +  Damage  +  Speed  +  Strength  +  Value  +");
            System.out.println("-----------------------------------------------------------------------------------");
            for (int i = 0; i < weapons.size(); i++){
                Weapon w = weapons.get(i);
                System.out.println(w.getName() + "  +    " + w.getCombatType() + "      +   " + w.getDamageType() + "     +     " + w.getDamage() + "     +     " + w.getSpeed() + "    +    " + w.getStrength() + "    +    " + w.getValue() + " + ");

            }
        };
        printT.print(sortedList);

    }

    public static ArrayList<Weapon> readFile(){
        ArrayList<Weapon> wList = new ArrayList<>();
        try {
            File myObj = new File("C:\\Schule\\Shuajb-HTL-3\\POS\\testRepo\\Hausuebung-3\\src\\net\\htlgkr\\RamadaniS190231\\Beispiel1\\weapons.csv");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();

            while (myReader.hasNext()){
                data = myReader.nextLine();
                String[] arr = data.split(";");
                String name = arr[0];
                CombatType combatType = CombatType.valueOf(arr[1]);
                DamageType damageType = DamageType.valueOf(arr[2]);
                int damage = Integer.parseInt(arr[3]);
                int speed = Integer.parseInt(arr[4]);
                int strength = Integer.parseInt(arr[5]);
                int value = Integer.parseInt(arr[6]);

                Weapon weapon = new Weapon(name,
                        combatType,
                        damageType,
                        damage,
                        speed,
                        strength,
                        value);
                wList.add(weapon);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return wList;
    }

    public static ArrayList<Weapon> sortDamage(ArrayList<Weapon> wList){
        wList.sort(Comparator.comparingInt(Weapon::getDamage));
         return wList;
    }

    public static ArrayList<Weapon> sortByDamageAndName(ArrayList<Weapon> wList){
        Comparator<Weapon> comparator = Comparator
                .comparing(Weapon::getCombatType)
                .thenComparing(Weapon::getDamageType)
                .thenComparing(Weapon::getName);
        wList.sort(comparator);
        return wList;
    }


}
