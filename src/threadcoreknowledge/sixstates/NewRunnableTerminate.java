package threadcoreknowledge.sixstates;

/**
 * 展示线程的New Runnable Terminated状态，即使是正在运行，也是Runnable状态，而不是Running
 */
public class NewRunnableTerminate implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminate());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
