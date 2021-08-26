package cn.sichu.myjava.august2021.threadlearning;

/**
 * Java线程对象Thread的状态包括：New、Runnable、Blocked、Waiting、Timed Waiting和Terminated；
 * <p>
 * 通过对另一个线程对象调用join()方法可以等待其执行结束；
 * <p>
 * 可以指定等待时间，超过等待时间线程仍然没有结束就不再等待；
 * <p>
 * 对已经运行结束的线程调用join()方法会立刻返回。
 * 
 * @author sichu
 * @date 2021/08/25
 */
public class ThreadStatus {
    public void threadStatus() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("end");
    }
}
