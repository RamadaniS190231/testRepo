/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;


public class Consumer implements Runnable {
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> received = new ArrayList<>();
    private boolean running = true;
    
    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
    }
 
    // implement this

    public List<Integer> getReceived() {
        return this.received;
    }

    @Override
    public void run() {

        while (running){
            boolean complete = storage.isProductionComplete();


            Integer num = storage.get();
            if (num != null){
                received.add(num);
            } else{
                if (complete) {
                    running = false;
                }
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public String getName() {
        return name;
    }

    public Storage getStorage() {
        return storage;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

