package threadcoreknowledge.stopthreads;

/**
 * run无法抛出checked Exception, 只能使用try/catch
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() { // run方法中只能try/catch，不能向外抛出异常
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
