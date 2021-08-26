package cn.sichu.myjava.august2021.threadlearning;

/**
 * 
 * @author sichu
 * @date 2021/08/24
 */
public class CreateThread {
    public void createThread() {
        /*version1: 从Thread派生一个自定义类，然后覆写run()方法*/
        Thread t1 = new MyThread();
        // System.out.println("start new thread!");
        t1.start();

        /*version2: 创建Thread实例时，传入一个Runnable实例*/
        Thread t2 = new Thread(new MyRunnable());
        // System.out.println("start new thread!");
        t2.start();

        /*version3: 用Java8引入的lambda语法进一步简写*/
        Thread t3 = new Thread(() -> {
            System.out.println("start new thread!");
        });
        // System.out.println("start new thread!");
        t3.start();
    }

    /**
     * 首先打印main start，
     * <p>
     * 然后创建Thread对象， 紧接着调用 start() 启动新线程
     * <p>
     * 当 start() 方法被调用时，JVM就创建了一个新线程，通过实例变量 t 来表示，并开始执行
     * <p>
     * 接着， main 线程继续执行打印 main end 语句， 而 t 线程在 main 线程执行时会并发执行，打印 thread run 和 thread end 语句
     * <p>
     * 当 run() 方法结束时，新线程就结束了
     * <p>
     * 而 main() 方法结束时，主线程也结束了
     * 
     */
    public void createThread1() {
        System.out.println("main start...");
        Thread t = new Thread() {
            /*新线程的起点*/
            @Override
            public void run() {
                System.out.println("thread run...");
                // 模拟并发执行的效果,在线程中调用Thread.sleep()，强迫当前线程暂停一段时间
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("thread end...");
                }
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("main end...");
        }

    }
}
