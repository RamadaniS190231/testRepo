package net.htlgkr.ramadanis190231.beispiel2;

public class Task implements Runnable{
    private int lowest;
    private int highest;
    private int sum;
    public Task(int lowest, int highest) {
        this.lowest = lowest;
        this.highest = highest;
    }

    @Override
    public void run() {
        int result = 0;
        for(int i = this.lowest; i <= this.highest; i++){
            result = result + i;
        }

        sum = result;
    }

    public int getSum() {
        return sum;
    }
}
