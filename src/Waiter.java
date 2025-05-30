import java.util.concurrent.Semaphore;

public class Waiter {
    private final Semaphore[] forks = new Semaphore[5];

    public Waiter(){
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public synchronized void requestToEat(int id) throws InterruptedException{
        int rigth = id;
        int left = (id + 1) % 5;

        while(forks[left].availablePermits() == 0 || forks[rigth].availablePermits() == 0){
            wait();
        }
        forks[rigth].acquire();
        forks[left].acquire();


    }

    public synchronized void doneEating(int id){
        int rigth = id;
        int left = (id + 1) % 5;

        forks[rigth].release();
        forks[left].release();

        notifyAll();
    }
}
