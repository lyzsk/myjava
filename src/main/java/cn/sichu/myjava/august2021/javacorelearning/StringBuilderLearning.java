package cn.sichu.myjava.august2021.javacorelearning;

/**
 * 
 * @author sichu
 * @date 2021/08/19
 */
public class StringBuilderLearning {
    public long concurrentTime1;
    public long concurrentTime2;
    public long concurrentMemory1;
    public long concurrentMemory2;

    public void start() {
        // return the current value of running JVM time source
        concurrentTime1 = System.nanoTime();
        // Returns the runtime object associated with the current Java application
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory1 = runtime.totalMemory() - runtime.freeMemory();
    }

    public void end() {
        // return the current value of running JVM time source
        concurrentTime2 = System.nanoTime();
        // Returns the runtime object associated with the current Java application
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory2 = runtime.totalMemory() - runtime.freeMemory();

        // calculate the time cost(ms) and memory(M) cost between start - end
        // 1ms = 1000us = 1000 000 ns
        // 1M = 1*20^20 byte = 1024 * 1024 byte
        String time = String.valueOf((double)(concurrentTime2 - concurrentTime1) / 1000000);
        String memory = String.valueOf((double)(concurrentMemory2 - concurrentMemory1) / 1024 / 1024);
        System.out
            .println("Run time:    " + time.substring(0, time.equals("0.0") ? 1 : (time.indexOf(".") + 3)) + " ms");
        System.out.println(
            "Memory cost: " + memory.substring(0, memory.equals("0.0") ? 1 : (memory.indexOf(".") + 3)) + " M");
    }

    public void useString() {
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s = s + "," + i;
        }
        System.out.println(s);
    }

    public void useStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(',').append(i);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        StringBuilderLearning sblearning = new StringBuilderLearning();
        sblearning.start();
        sblearning.useString();
        sblearning.end();
        sblearning.start();
        sblearning.useStringBuilder();
        sblearning.end();
    }
}
