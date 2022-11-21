public class Fork {

    private int id;
    private boolean isUsed = false;
    private int leaderUsingThisFork;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getLeaderUsingThisFork() {
        return leaderUsingThisFork;
    }

    public void setLeaderUsingThisFork(int leaderUsingThisFork) {
        this.leaderUsingThisFork = leaderUsingThisFork;
    }
}
