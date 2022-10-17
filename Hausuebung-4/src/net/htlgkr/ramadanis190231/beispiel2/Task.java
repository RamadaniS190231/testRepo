package net.htlgkr.ramadanis190231.beispiel2;

import static net.htlgkr.ramadanis190231.beispiel2.Main.sum;

public class Task implements Runnable{
    private int lowest;
    private int highest;

    public Task(int lowest, int highest) {
        this.lowest = lowest;
        this.highest = highest;
    }

    @Override
    public void run() {
        int result = 0;
        for(int i = this.lowest; i <= this.highest; i++){
            result =+ i;
        }

        sum = sum+result;
    }
}
