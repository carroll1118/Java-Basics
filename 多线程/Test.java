package thread;

import java.util.concurrent.*;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
public class Test {
    public static void main(String[] args) {
        //子线程
        /*TestThread testThread = new TestThread();
        testThread.start();*/

        //子线程:匿名内部类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<100;i++){
                    System.out.println( Thread.currentThread().getName() + "  = " + i);
                }
            }
        }).start();

        //子线程：实现Callable接口
        //创建FutureTask实例，实现TestCallable实例
        /*FutureTask<String> task = new FutureTask<String>(new TestCallable());
        //创建Thread实例，执行FutureTask
        Thread thread = new Thread(task);
        thread.start();*/

        //子线程：使用线程池创建线程
      /*  //1.使用Executors获取线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //通过线程池对象获取线程并执行TestRunnable实例
        executorService.execute(new TestRunnable());*/

        //主线程
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"="+i);
        }
    }
}
