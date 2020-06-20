package threadcoreknowledge.sixstates;

/**
 * 展示线程的 Blocked Waiting TimedWaiting 三种状态
 */
public class BlockedWaitingTimedWaiting implements Runnable {

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting r1 = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(r1);
        thread1.start();
        Thread thread2 = new Thread(r1);
        thread2.start();
        System.out.println(thread1.getState()); // TIMED_WAITING
        System.out.println(thread2.getState()); // BLOCKED
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState()); // WAITING
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
