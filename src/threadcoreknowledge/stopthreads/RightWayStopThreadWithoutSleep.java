package threadcoreknowledge.stopthreads;

/**
 * run方法内没有sleep或wait方法时，停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            if (i % 10000 == 0) {
                System.out.println(i + "是10000的倍数");
            }
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
