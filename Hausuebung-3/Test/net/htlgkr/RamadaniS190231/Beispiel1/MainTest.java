package net.htlgkr.RamadaniS190231.Beispiel1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void sortDamageTest() {
        Main m = new Main();
        ArrayList<Weapon> wList = new ArrayList<>();
        Weapon w1 = new Weapon("Sword", CombatType.MELEE, DamageType.SLASHING, 30, 40, 10, 5);
        Weapon w2 = new Weapon("Axe", CombatType.MELEE, DamageType.SLASHING, 12, 40, 10, 5);
        Weapon w3 = new Weapon("Bow", CombatType.RANGED, DamageType.SLASHING, 70, 40, 10, 5);
        Weapon w4 = new Weapon("Speer", CombatType.MELEE, DamageType.SLASHING, 45, 40, 10, 5);
        wList.add(w1);
        wList.add(w2);
        wList.add(w3);
        wList.add(w4);

        ArrayList<Weapon> testList = m.sortDamage(wList);
        boolean expected = true;
        boolean result = wList.equals(testList);
        assertEquals(expected, result);

    }

    @Test
    public void sortByNameTest() {
        Main m = new Main();
        ArrayList<Weapon> wList = new ArrayList<>();
        Weapon w1 = new Weapon("Speer", CombatType.MELEE, DamageType.SLASHING, 30, 40, 10, 5);
        Weapon w2 = new Weapon("Axe", CombatType.MELEE, DamageType.SLASHING, 30, 40, 10, 5);
        Weapon w3 = new Weapon("Bow", CombatType.RANGED, DamageType.SLASHING, 30, 40, 10, 5);
        Weapon w4 = new Weapon("Speer", CombatType.MELEE, DamageType.SLASHING, 30, 40, 10, 5);
        wList.add(w1);
        wList.add(w2);
        wList.add(w3);
        wList.add(w4);

        ArrayList<Weapon> testList = m.sortByName(wList);
        boolean expected = true;
        boolean result = wList.equals(testList);
        assertEquals(expected, result);

    }

}