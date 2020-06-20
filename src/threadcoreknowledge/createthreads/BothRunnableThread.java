package threadcoreknowledge.createthreads;

/**
 * 同时使用Runnable和Thread
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("来自Thread");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }.start();
    }
}
