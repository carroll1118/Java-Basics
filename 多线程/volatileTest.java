package thread;

/**
 * @Auther Carroll
 * @Date 2020/4/5
 * @e-mail ggq_carroll@163.com
 */
public class volatileTest {
    public  static void main(String[] args) {
        // 1.启动线程，把线程对象中的flag改为true。
        VolatileThread t = new VolatileThread();
        t.start();

        // 2.定义一个死循环
        while(true){
            // 这里读取到了flag值一直是false,虽然线程已经把它的值改成了true。
            if(t.isFlag()){

            }
        }
    }
}
// 线程类。
class VolatileThread extends Thread {
    // 定义成员变量
    // volatile可以实现变量一旦被子线程修改，其他线程可以马上看到它修改后的最新值！
    private boolean flag = false ;
    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将flag的值更改为true
        this.flag = true ;
        System.out.println("线程修改了flag=" + flag);
    }
}
