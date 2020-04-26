package thread;

import java.util.concurrent.Callable;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
public class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"="+i);
        }
        return "子线程执行成功！";
    }

}
