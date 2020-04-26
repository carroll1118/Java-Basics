package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
class VolatileAtomicThread implements Runnable {

    // 定义一个int类型的变量
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        // 对该变量进行++操作，100次
        for(int x = 1 ; x <=100 ; x++) {
            int i = atomicInteger.incrementAndGet();
            System.out.println("count =========>>>> " + i);
        }
    }
}

public class VolatileAtomicThreadDemo {
    public static void main(String[] args) {

        // 创建VolatileAtomicThread对象
        VolatileAtomicThread volatileAtomicThread = new VolatileAtomicThread() ;

        // 开启100个线程对count进行++操作
        for(int x = 1 ; x <=100 ; x++) {
            new Thread(volatileAtomicThread).start();
        }

    }
}
