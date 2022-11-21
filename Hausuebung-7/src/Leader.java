public class Leader implements Runnable {

    private Fork leftFork;
    private Fork rightFork;
    private int id;

    public Leader(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Leader " + id + " is drinking");

                this.rightFork.take(this.id);
                System.out.println("Leader " + id + " took the right fork " + rightFork.getId());
                this.leftFork.take(this.id);
                System.out.println("Leader " + id + " took the left fork " + leftFork.getId());

                System.out.println("Leader " + id + " is feasting");

                this.leftFork.put(this.id);
                System.out.println("Leader " + id + " has put down the left fork " + leftFork.getId());
                this.rightFork.put(this.id);
                System.out.println("Leader " + id + " has put down the right fork " + rightFork.getId());

            } catch (InterruptedException e) {
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
