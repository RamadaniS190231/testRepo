import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        Leader[] leaders = createLeaders();

        for (int i = 0; i < leaders.length;i++){
            Thread t = new Thread(leaders[i]);
            t.start();
        }
    }

    public static Leader[] createLeaders(){
        Fork[] forks = new Fork[5];

        for (int i = 0; i < 5; i++){
            forks[i] = new Fork(i, lock);
        }

        Leader[] leaders = new Leader[5];

        for (int i = 0; i < 5; i++){
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1)%5];

            leaders[i] = new Leader(i, leftFork, rightFork);
        }

        return leaders;
    }
}