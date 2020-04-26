package thread.并发包;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //创建1个计数器：用来控制 A , B线程的执行流程的。
        CountDownLatch down = new CountDownLatch(1);

        new ThreadA(down).start();
        new ThreadB(down).start();
    }
}

class ThreadA extends Thread{
    private CountDownLatch down;
    public ThreadA(CountDownLatch down){
        this.down = down;
    }
    @Override
    public void run() {
        System.out.println("A");
        try {
            down.await(); // A线程你进入等待，让B线程执行自己！
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}

class ThreadB extends Thread{
    private CountDownLatch down;
    public ThreadB(CountDownLatch down){
        this.down = down;
    }
    @Override
    public void run() {
        System.out.println("B");
        down.countDown(); // 这里相当于是-1，代表自己执行完毕了。A线程被唤醒！！
    }
}