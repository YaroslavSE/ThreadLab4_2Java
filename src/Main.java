public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        for (int i = 0; i < 5; i++) {
            new Philosopher(i, waiter);
        }
    }
}