package thread;
/**
 * @Auther Carroll
 * @Date 2020/4/4
 * @e-mail ggq_carroll@163.com
 */
public class TestThread extends Thread{
    public void run(){
        for(int i=1;i<100;i++){
            System.out.println( Thread.currentThread().getName() + "  = " + i);
        }
    }
}