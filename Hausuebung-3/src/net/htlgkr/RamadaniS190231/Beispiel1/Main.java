package net.htlgkr.RamadaniS190231.Beispiel1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public ArrayList<Weapon> readFile(){
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

    public ArrayList<Weapon> sortDamage(ArrayList<Weapon> wList){
        wList.sort((Weapon w1, Weapon w2) -> w2.getDamage()-w1.getDamage());
         return wList;
    }

    public ArrayList<Weapon> sortByName(ArrayList<Weapon> wList){
        wList.sort((Weapon w1, Weapon w2) -> {
            int result = w2.getDamage()-w1.getDamage();
            if (result == 0){
                result = w1.getCombatType().compareTo(w2.getCombatType());
                return result;
            }
            if (result == 0){
                result = w1.getDamageType().compareTo(w2.getDamageType());
                return result;
            }
            if (result == 0){
                result = w1.getName().compareTo(w2.getName());
                return result;
            }
            return result;
        });
        return wList;
    }


}
