package threadcoreknowledge.stopthreads;

/**
 * 错误的停止方法：使用stop()来停止线程，会导致线程运行一半突然停止，没办法完成一个基本单位的操作，
 * 会造成脏数据
 */
public class StopThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取装备");
            for (int j = 0; j < 10; j++) {
                System.out.println("连队" + i + "第" + j + "个战士领取装备");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "领取装备结束");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
