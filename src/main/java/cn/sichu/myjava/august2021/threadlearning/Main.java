package cn.sichu.myjava.august2021.threadlearning;

/**
 * 
 * @author sichu
 * @date 2021/08/24
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*创建新线程*/
        // CreateThread ct = new CreateThread();
        // ct.createThread1();

        /*线程的状态*/
        // ThreadStatus ts = new ThreadStatus();
        // ts.threadStatus();

        /*中断线程*/
        InterruptThread it = new InterruptThread();
        // it.interruptThread();
        // it.interruptThread2();
        it.interruptThread3();
    }
}
