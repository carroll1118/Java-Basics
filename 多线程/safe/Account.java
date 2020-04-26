package thread.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 *
 * 账户类
 */
public class Account {
    private String cardId;
    private double moeny;

    private final Lock lock = new ReentrantLock();

    public void drawMoney(double moeny) {
        String name = Thread.currentThread().getName();
        lock.lock();  //上锁
        try{
            if(this.moeny>=moeny){
                System.out.println(name+"来取钱，余额充足，取走："+moeny);
                this.moeny -= moeny;
                System.out.println("余额剩余："+this.moeny);
            }else {
                System.out.println(name+"来取钱，余额不足！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock(); //解锁
        }
    }

    public Account() {
    }

    public Account(String cardId, double moeny) {
        this.cardId = cardId;
        this.moeny = moeny;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getMoeny() {
        return moeny;
    }

    public void setMoeny(Double moeny) {
        this.moeny = moeny;
    }
}
