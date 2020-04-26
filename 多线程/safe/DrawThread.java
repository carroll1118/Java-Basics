package thread.safe;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
public class DrawThread extends Thread {
    private Account acc ;

    public DrawThread(Account account, String name) {
        super(name);
        acc = account;
    }

    @Override
    public void run() {
        acc.drawMoney(88888);
    }
}
