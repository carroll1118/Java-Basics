package thread.safe;
/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
public class ThreadSafe {
    public static void main(String[] args) {
        Account account = new Account("ICBC-888", 88888);

        Thread t1 = new DrawThread(account,"小黑");
        t1.start();

        Thread t2 = new DrawThread(account,"小白");
        t2.start();

    }
}
