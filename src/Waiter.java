public class Waiter {
    private final boolean[] forks = new boolean[5];

    public synchronized void requestToEat(int id) throws InterruptedException{
        int rigth = id;
        int left = (id + 1) % 5;

        while(forks[left] || forks[rigth]){
            wait();
        }

        forks[left] = true;
        forks[rigth] = true;
    }

    public synchronized void doneEating(int id){
        int rigth = id;
        int left = (id + 1) % 5;

        forks[rigth] = false;
        forks[left] = false;

        notifyAll();
    }
}
