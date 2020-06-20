package threadcoreknowledge.createthreads.wrongways;

/**
 * 匿名内部类创建线程
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("匿名内部类创建线程 Thread");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类创建线程 Runnable");
            }
        }).start();
    }
}
