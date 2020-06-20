package threadcoreknowledge.createthreads.wrongways;

/**
 * 使用Lambda表达式创建线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("111")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        }).start();
    }
}
