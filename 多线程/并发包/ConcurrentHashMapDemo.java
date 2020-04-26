package thread.并发包;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    // 定义一个静态的HashMap集合，只有一个容器。
     public static Map<String,String> map = new HashMap<>();
      //public static Map<String,String> map = new Hashtable<>();
    //public static Map<String,String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        // HashMap线程不安全演示。
        // 需求：多个线程同时往HashMap容器中存入数据会出现安全问题。
        // 具体需求：提供2个线程分别给map集合加入50万个数据！
        Runnable target = new AddMapDataThread();
        Thread t1 = new Thread(target,"线程1");
        Thread t2 = new Thread(target,"线程2");
        t1.start();//让t1跑完，主线程不能抢t1的cpu，但是t2抢t1的cpu
        t2.start();//让t2跑完，主线程不能抢t1的cpu，但是t1抢t2的cpu

        /*t1.join();
        t2.join();*/

        //休息10秒，确保两个线程执行完毕
        Thread.sleep(1000 * 10);
        //打印集合大小
        System.out.println("Map大小：" + map.size());
    }
}

class AddMapDataThread implements Runnable{
    @Override
    public void run() {
        for(int i = 1 ; i <= 500000 ; i++ ){
            ConcurrentHashMapDemo.map.put(Thread.currentThread().getName()+"键："+i ,"值"+i);
        }
    }
}