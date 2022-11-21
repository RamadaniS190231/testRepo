import java.util.concurrent.locks.Lock;

public class Fork {

    private boolean isUsed = true;
    private int id;
    private int leaderUsingThisFork;
    private Lock lock;

    public Fork(int id, Lock lock) {
        this.id = id;
        this.lock = lock;
    }

    public void take(int leader) throws InterruptedException {

        try {
            lock.lock();
            while (!isUsed) {

                try {
                    System.out.println(leaderUsingThisFork + " Is waiting for");
                    wait(500);
                    lock.unlock();
                }catch (Exception e){

                }
            }
            leaderUsingThisFork = leader;
            isUsed = false;
        } finally {
            lock.unlock();
        }
    }

    public void put(int leader){
        lock.lock();
        if (!isUsed && leaderUsingThisFork == leader){
            isUsed = true;
            notify();
        }
        lock.unlock();
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeaderUsingThisFork() {
        return leaderUsingThisFork;
    }

    public void setLeaderUsingThisFork(int leaderUsingThisFork) {
        this.leaderUsingThisFork = leaderUsingThisFork;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
