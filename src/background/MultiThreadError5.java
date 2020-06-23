package background;

import java.awt.*;
import java.util.EventListener;

/**
 * 观察者模式
 */
public class MultiThreadError5 {

    int count;

    public MultiThreadError5(MySource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.println("我得到的数字是" + count);
            }
        });
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        count = 100;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mySource.eventCome(new Event() {
                });
            }
        }).start();
        MultiThreadError5 multiThreadError5 = new MultiThreadError5(mySource);
    }

    static class MySource {
        private EventListener listener;

        void registerListener(EventListener listener) {
            this.listener = listener;
        }

        void eventCome(Event e) {
            if (listener != null) {
                listener.onEvent(e);
            } else {
                System.out.println("还未初始化完毕");
            }
        }
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
