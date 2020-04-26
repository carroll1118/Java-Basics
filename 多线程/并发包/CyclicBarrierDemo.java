package thread.并发包;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 1.创建一个任务循环屏障对象。
        /**
         * 参数一：代表多少个线程的执行。
         * 参数二：到达执行屏障就开始触发的线程任务。
         */
        CyclicBarrier cb = new CyclicBarrier(5 , new MeetingRunnable());
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();

        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();
        new PeopleThread(cb).start();

    }
}

// 任务类：开始开会的任务
class MeetingRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("人员到齐了开始由"+Thread.currentThread().getName()+"主持会议！");
    }
}

// 员工类
class PeopleThread extends Thread{
    private CyclicBarrier cb ;
    public PeopleThread(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("员工："+Thread.currentThread().getName()+"进入会议室");
            cb.await(); // 自己做完了，告诉循环屏障我结束了！
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}