package lambda;

import thread.TestRunnable;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 *
 * @FunctionalInterface  函数式接口声明
 */
public class lambdaRunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(System.out::println);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("--------------2");
            }
        }).start();

        new Thread(() -> {
                System.out.println("--------------3");
        }).start();

        new Thread(() -> System.out.println("--------------4")).start();
    }
}
