public class Philosopher extends Thread {
    private final Waiter waiter;
    private final int leftFork, rightFork;
    private final int id;

    public Philosopher(int id, Waiter waiter) {

        this.id = id;
        this.waiter = waiter;

        if(id == 4){
            rightFork = (id + 1) % 5;
            leftFork = id;
        }
        else{
            rightFork = id;
            leftFork = (id + 1) % 5;
        }
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Philosopher" + id + " is thinking " + (i + 1) + " times");
                waiter.requestToEat(id);
                System.out.println("Philosopher" + id + " is eating" + (i + 1) + " times");
                waiter.doneEating(id);
            }

        } catch (InterruptedException e){
            System.out.println("Philosopher " + id + " was interrupted.");
        }
    }

}
