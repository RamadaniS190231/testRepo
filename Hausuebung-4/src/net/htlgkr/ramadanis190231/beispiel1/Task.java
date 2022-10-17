package net.htlgkr.ramadanis190231.beispiel1;

import com.sun.org.apache.xpath.internal.axes.SubContextList;

import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable{
    private List<Integer> list;
    private int divider;

    public Task(List<Integer> list, int divider) {
        this.list = list;
        this.divider = divider;
    }

    @Override
    public void run() {

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % divider == 0){
                System.out.println(list.get(i) + ": ist ein Teiler von " + divider);
            }
        }

    }
}
