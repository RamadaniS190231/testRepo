/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;

    private boolean flag1 = false;
    
    public Storage() {
        this.queue = new ArrayBlockingQueue<>(10);
        this.fetchedCounter = 0;
        this.storedCounter = 0;
        this.underflowCounter = 0;
        this.overflowCounter = 0;
        this.productionComplete = false;
    }
    
    public synchronized boolean put(Integer data) throws InterruptedException {
        if (queue.size() < 10){
            queue.put(data);
            this.storedCounter++;
            return true;
        }else {
            this.overflowCounter++;
            return false;
        }
        }
 
    public synchronized Integer get() {
        if (queue.size() != 0){
            try {
                this.fetchedCounter++;
                return queue.poll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            underflowCounter++;
            return null;
        }
    }

    public boolean isProductionComplete() {
        return this.productionComplete;
    }

    public void setProductionComplete() {
        if (flag1 == false){
            flag1 = true;
        }else {
            this.productionComplete = true;
        }
    }

    public ArrayBlockingQueue<Integer> getQueue() {
        return queue;
    }

    public int getFetchedCounter() {
        return fetchedCounter;
    }

    public int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }
}
