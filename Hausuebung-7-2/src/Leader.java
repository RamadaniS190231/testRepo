import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;

public class Leader implements Runnable{
    private Fork leftFork;
    private Fork rightFork;
    private int id;
    private Lock lock;

    public Leader(Fork leftFork, Fork rightFork, int id, Lock lock) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true){

            LocalDateTime time;
            drinking();

            grabRightFork();
            time = LocalDateTime.now();
            System.out.println(time + " Leader " + id + " grabbed the right fork.");
            grabLeftFork(); // Methode macht nichts
            time = LocalDateTime.now();
            System.out.println(time + " Leader " + id + " grabbed the left fork.");
            feasting();

            releaseLeftFork();
            time = LocalDateTime.now();
            System.out.println(time + " Leader " + id + " released the left fork.");
            releaseRightFork();
            time = LocalDateTime.now();
            System.out.println(time + " Leader " + id + " released the right fork.");
        }

    }

    public void grabRightFork(){
        while (rightFork.isUsed() || leftFork.isUsed()) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
        lock.lock();
        rightFork.setLeaderUsingThisFork(this.id);
        leftFork.setLeaderUsingThisFork(this.id);
        rightFork.setUsed(true);
        leftFork.setUsed(true);
        lock.unlock();
    }

    public void grabLeftFork(){

    }

    public void releaseLeftFork(){
        leftFork.setUsed(false);
    }

    public void releaseRightFork(){
        rightFork.setUsed(false);
    }

    public void feasting(){
        int i = (int) (Math.random() * 1000) + 1;
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time + " Leader " + id + " is feasting");
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void drinking(){
        int i = (int) (Math.random() * 1000) + 1;
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time + " Leader " + id + " is drinking");
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    public Fork getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
