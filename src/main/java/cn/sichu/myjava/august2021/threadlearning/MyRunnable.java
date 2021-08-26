package cn.sichu.myjava.august2021.threadlearning;

/**
 * 
 * @author sichu
 * @date 2021/08/24
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("start new thread!");
    }

}
